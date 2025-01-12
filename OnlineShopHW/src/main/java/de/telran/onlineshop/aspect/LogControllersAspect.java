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
public class LogControllersAspect {
    @Pointcut("execution(public * de.telran.onlineshop.controller.*.*(..))")
    public void callAtControllerPublic() { }

/*
    @Before("callAtControllerPublic()")
    public void beforeCallAt(JoinPoint jp) {
        log.info("-- start "
                + jp.toString()
                + " time -> "
                + LocalDateTime.now());
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before "
                + jp.toString()
                + ", args=["
                + args
                + "]");
    }

    @After("callAtControllerPublic()")
    public void afterCallAt(JoinPoint jp) {
        log.info("-- end "
                + jp.toString()
                + " time -> "
                + LocalDateTime.now());
    }
*/

    @Around("callAtControllerPublic()")
    public Object aroundCallAt(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = null;
        long start = System.currentTimeMillis();
        log.info("-- start "
                + pjp.getSignature().getName()
                + " time -> "
                + LocalDateTime.now());

        log.info("before "
                + pjp.getSignature().getName()
                + ", args=["
                + pjp.getArgs()
                + "]");

        retVal = pjp.proceed();

        log.info("-- end "
                + pjp.getSignature().getName()
                + " time -> "
                + LocalDateTime.now());

        log.info(" ----- " + pjp.getSignature().getName()
                + " отработал за "
                + (System.currentTimeMillis() - start));

        log.info(" ----- " + pjp.getSignature().getName()
                + " result: "
                + retVal.toString());

        return retVal;
    }

}
