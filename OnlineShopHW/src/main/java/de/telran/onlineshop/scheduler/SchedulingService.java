package de.telran.onlineshop.scheduler;

import de.telran.onlineshop.entity.OrdersEntity;
import de.telran.onlineshop.entity.UsersEntity;
import de.telran.onlineshop.entity.enums.Status;
import de.telran.onlineshop.repository.OrdersRepository;
import de.telran.onlineshop.repository.ProductsRepository;
import de.telran.onlineshop.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class SchedulingService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Scheduled(cron = "0 0 9 * * *") // at 9 am every day
    public void scheduledReminderNonPaidOrderCron() throws InterruptedException {

        List<OrdersEntity> orders = ordersRepository.findAll();

        for (OrdersEntity order : orders) {
            if ((order.getStatus() == Status.CREATED
                    || order.getStatus() == Status.WAIT_PAYMENT)
                    && greaterThanOneDay(order.getCreatedAt())) {
                UsersEntity user = order.getUser();
                // or find via userRepository if user object is not valid
                log.trace("Send email to User: "
                        + user.getUserId()
                        + ", about unpaid order: "
                        + order.getOrderId()
                );

                System.out.println("Send email notification to: "
                        + user.getEmail()
                        + ", you have unpaid Order: "
                        + order.getOrderId()
                        );

            }
        }
    }

    boolean greaterThanOneDay(Timestamp orderCreatedTime){
        LocalDateTime created = orderCreatedTime.toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();
        return Duration.between(created, now).toDays() > 1;
    }


    @Async //код метода будет выполняться в отдельном потоке
//    @Scheduled(initialDelay = 10000, //задержка старта
//               fixedDelay=5000 //пертод срабатывания
//              ) //Новое задание всегда будет ждать завершения предыдущего задания

    @SchedulerLock(name = "scheduledTaskFixedDelay")
    @Scheduled(fixedDelayString="${fixedDelay.in.milliseconds}") // берет время из параметров
    public void scheduledTaskFixedDelay() throws InterruptedException {
        log.error("Пример работы scheduledTask (fixedDelay) -> "+ LocalDateTime.now());
        Thread.sleep(3000);
    }

    // @Async //код метода будет выполняться в отдельном потоке
    @SchedulerLock(name = "scheduledTaskFixedRate", lockAtMostFor = "10s")
    @Scheduled(fixedRate=5000) //Время выполнения метода не учитывается при решении, когда начинать следующее задание
    public void scheduledTaskFixedRate() throws InterruptedException {
        log.info("Пример работы scheduledTask (fixedRate) -> "+ LocalDateTime.now());
        Thread.sleep(3000);
    }

    //@Scheduled(cron="15 * * * * *") //каждую минуту на 15 секунде
    @Scheduled(cron = "${cron.expression}")
    @SchedulerLock(name = "scheduledTaskCron")
    public void scheduledTaskCron() throws InterruptedException {
        log.info("Пример работы scheduledTask (Cron) -> "+ LocalDateTime.now());
    }

}
