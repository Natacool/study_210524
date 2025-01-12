package de.telran.onlineshop.aspect;

import de.telran.onlineshop.dto.CategoryDto;
import de.telran.onlineshop.dto.UserDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
    @Pointcut("@annotation(GetMapping) && args(id,..)")
    public void callAtGetMappingAnnotation(Long id){ }

    @Around("callAtGetMappingAnnotation(id)")
    public Object aroundCallAt(ProceedingJoinPoint pjp, Long id) throws Throwable {
        Object retVal = null;
        UserDto userDtoTest2 = new UserDto(
            2L,
            "Dunia Smirnova",
            "dunia.smirnova@mail.com",
            "+49123654789",
            "Password2"
            );

        if (id >= 99) { // replacement according to condition
            retVal = userDtoTest2;
        } else {
            retVal = pjp.proceed(); // standard implementation of the method
        }
        return retVal;
    }
}
