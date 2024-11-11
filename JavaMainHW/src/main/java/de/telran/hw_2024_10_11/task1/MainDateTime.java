package de.telran.hw_2024_10_11.task1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainDateTime {
    public static void main(String[] args) {
        //1) реализовать метод, который принимает год и проверяет на високосность
        System.out.println("Is 2000 leap: " + checkIfYearLeap(2000));
        System.out.println("Is 2021 leap: " + checkIfYearLeap(2021));
        System.out.println("Is 2022 leap: " + checkIfYearLeap(2022));
        System.out.println("Is 2023 leap: " + checkIfYearLeap(2023));
        System.out.println("Is 2024 leap: " + checkIfYearLeap(2024));
        System.out.println("-----------------------------------------------");

        //2) вывести на консоль дату локализованную для Индии (например)
        ZonedDateTime curZone = ZonedDateTime.now();
        System.out.println("Germany zone time: " + curZone);
        ZonedDateTime zoneDateTime = zoneDateTime =  ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("India zone time: " + zoneDateTime);
        System.out.println("-----------------------------------------------");

        //3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime);

        DateTimeFormatter frmDate = DateTimeFormatter.ofPattern("dd-MM-YY");
        DateTimeFormatter frmTime = DateTimeFormatter.ofPattern("HH:mm");

        String dateString = currentDateTime.format(frmDate);
        String timeString = currentDateTime.format(frmTime);

        System.out.println(dateString
                + ", "
                + currentDateTime.getDayOfMonth()
                + ", "
                + currentDateTime.getDayOfYear()
                + ", "
                + timeString);
        System.out.println("-----------------------------------------------");

        //4) создать дату своего рождения, вывести на консоль в формате "10 Января 1985"
        LocalDate birthDay = LocalDate.of(1984, Month.FEBRUARY, 29);
        System.out.println("Birth day: " + birthDay);
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("dd MMMM YYYY", new Locale("ru","RU"));
        System.out.println("Birthday in RU locale: " + ft.format(birthDay));
        System.out.println("-----------------------------------------------");

        //5) проверить дата "10 Января 1985" - это пятница, попробуйте получить день недели для любой другой даты?
        LocalDate date = LocalDate.now();
        LocalDate dayOfWeek = LocalDate.of(1985, Month.JANUARY, 10);
        System.out.println("Is Friday? " + date + " - " + dayOfWeek.getDayOfWeek());
        dayOfWeek = LocalDate.of(2000, Month.FEBRUARY, 29);
        System.out.println("" + dayOfWeek + " - " + dayOfWeek.getDayOfWeek());
        System.out.println("-----------------------------------------------");

        //6) вычесть 10 лет из созданной даты, вывести на консоль
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Cur time: " + now);
        System.out.println("Cur time - 10 years: " + now.minusYears(10));
        System.out.println("-----------------------------------------------");

        //7) получить ZonedDateTime из "Pacific/Midway", вывести на консоль
        curZone = ZonedDateTime.now();
        System.out.println("Germany zone time: " + curZone);
        zoneDateTime = zoneDateTime =  ZonedDateTime.now(ZoneId.of("Pacific/Midway"));
        System.out.println("Pacific/Midway zone time: " + zoneDateTime);
        System.out.println("-----------------------------------------------");

        //8)* получить возраст человека на текущий момент, если известна его дата рождения.
        // Разница между датами
        LocalDate curDate = LocalDate.now();
        //LocalDate birthDay = LocalDate.of(1984, Month.DECEMBER, 16);
        Period period = Period.between(birthDay, curDate);
        System.out.println("Current date: " + curDate);
        System.out.println("Birth day: " + birthDay);
        System.out.println("Person is " + period.getYears() + " years old!");
        System.out.println("-----------------------------------------------");

        //9)* Вы просыпаетесь и смотрите на будильник. Вам на работу нужно на 9 часов. Узнайте, сколько времени
        //осталось еще до начала работы или если вы проспали, то на сколько.
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current time: " + currentTime);
        LocalTime wakeupTime = LocalTime.of(9,0);
        System.out.println("Wakeup time: " + wakeupTime);

        Duration duration = Duration.between(currentTime, wakeupTime);
        if (duration.toHoursPart() < 0 || duration.toMinutesPart() < 0 || duration.toSecondsPart() < 0){
            System.out.println("вы проспали на "
                    + Math.abs(duration.toHoursPart()) + " hours "
                    + Math.abs(duration.toMinutesPart()) + " minutes "
                    + Math.abs(duration.toSecondsPart()) + " seconds.");
        } else {
            System.out.println("до начала работы осталось еще "
                    + duration.toHoursPart() + " hours "
                    + duration.toMinutesPart() + " minutes "
                    + duration.toSecondsPart() + " seconds.");
        }



        System.out.println("-----------------------------------------------");
    }

    public static boolean checkIfYearLeap(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;

    }
}
