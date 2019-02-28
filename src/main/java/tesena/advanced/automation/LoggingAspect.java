package tesena.advanced.automation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* *.*(..)) && this(tesena.advanced.automation.PageObject+)")
    public void pageObjectMethods() {
    }

    @Before("pageObjectMethods()")
    public void loggingPageObjectMethod(JoinPoint joinPoint) {
        String className = joinPoint.getThis().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        TestLogger.getLogger().info(className + "." + methodName + Arrays.toString(arguments));
    }
}
