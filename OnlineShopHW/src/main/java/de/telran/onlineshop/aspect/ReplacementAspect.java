package de.telran.onlineshop.aspect;

import de.telran.onlineshop.dto.UserDto;
import de.telran.onlineshop.entity.enums.Role;
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
public class ReplacementAspect {
    @Pointcut("execution(public * de.telran.onlineshop.controller.UsersController.getUserById(..))") // методы аннотации UserAnnotation
    public void callAtGetMappingAnnotation() { }

    // Замещение функциональности метода
    @Around("callAtGetMappingAnnotation()")
    public Object aroundCallAt(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = null;
        retVal = pjp.proceed();
        UserDto userDtoTest2 = new UserDto(
                2L,
                "Дуня Смирнова",
                "dunya@i.com",
                "+491607654321",
                "Password2"
        );
        retVal = ResponseEntity.status(222).body(userDtoTest2);
        return retVal;
    }

}
