package test.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class AOPLogger {
    private Logger logger = Logger.getLogger(AOPLogger.class.getName());

    @AfterReturning(value = "execution(* test.controller.UsersController.read())", returning = "result")
    public void logPoint(JoinPoint joinPoint, Object result) {
        System.out.println(result.toString());
    }
}
