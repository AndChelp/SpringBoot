package test.log;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class AOPLogger {
    private Logger logger = Logger.getLogger(AOPLogger.class.getName());

}
