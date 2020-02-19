package test.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import test.model.User;

import java.util.List;
import java.util.logging.Logger;

@Component
@Aspect
public class AOPLogger {
    private Logger log = Logger.getLogger(AOPLogger.class.getName());

    @Before(value = "execution(* test.controller.UsersController.create(..))")
    public void logCreateUserBefore(JoinPoint joinPoint) {
        log.info("Create "+joinPoint.getArgs()[0]);
    }

    @Before(value = "execution(* test.controller.UsersController.read())")
    public void logReadAllUsersBefore(JoinPoint joinPoint) {
        log.info("Read users...");
    }

    @AfterReturning(value = "execution(* test.controller.UsersController.read())", returning = "result")
    public void logReadAllUsersReturn(ResponseEntity<List<User>> result) {
        List<User> users = result.getBody();
        if (users != null)
            log.info(users.size() + " users found!");
        else
            log.warning("Users not found!");
    }

    @Before(value = "execution(* test.controller.UsersController.read(int))")
    public void logReadUserBefore(JoinPoint joinPoint) {
        log.info("Read user with id " + joinPoint.getArgs()[0] +"...");
    }

    @AfterReturning(value = "execution(* test.controller.UsersController.read(..))", returning = "result")
    public void logReadUserReturn(ResponseEntity<User> result) {
        User user = result.getBody();
        if (user != null)
            log.info("Found " + user.toString());
        else
            log.warning("User is not found!");
    }
}
























