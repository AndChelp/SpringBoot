package test.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import test.response.Response;

import java.util.logging.Logger;

@Component
@Aspect
public class AOPLogger {
    private Logger log = Logger.getLogger(AOPLogger.class.getName());

    @Before(value = "within(test.controller.UsersController)")
    public void logDeleteUserBefore(JoinPoint joinPoint) {
        log.info("Execute " + joinPoint.getSignature().toString());
    }

    @AfterReturning(value = "within(test.controller.UsersController)", returning = "result")
    public void logReturn(ResponseEntity<Response> result) {
        Response response = result.getBody();
        if (response != null) {
            log.info(response.toString());
        }
    }

    @AfterReturning(value = "within(test.exception.GlobalExceptionHandler)", returning = "result")
    public void logExceptions(ResponseEntity<Response> result) {
        Response response = result.getBody();
        if (response != null) {
            log.warning("Caught error... " + response.toString());
        }
    }
}

























