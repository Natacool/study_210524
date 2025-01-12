package de.telran.onlineshop.aspect;

import de.telran.onlineshop.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class BeforeAfterAspect {
    @Pointcut("execution(public * de.telran.onlineshop.controller.CategoriesController.*(..))")
    public void callAtCategoriesControllerPublic() { }

    @Before("callAtCategoriesControllerPublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        log.info("-- start "+jp.toString()+" time -> "+ LocalDateTime.now());
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("callAtCategoriesControllerPublic()")
    public void afterCallAt(JoinPoint jp) {
        log.info("-- end "+jp.toString()+" time -> "+ LocalDateTime.now());
    }
}
