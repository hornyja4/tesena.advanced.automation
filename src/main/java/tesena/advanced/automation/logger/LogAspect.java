package tesena.advanced.automation.logger;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

@Aspect
public class LogAspect {

    @Pointcut(value = "execution(* *.*(..)) && this(tesena.advanced.automation.objects.PageObject+)")
    public void logPageObjectMethods() {
    }

    @Pointcut(value = "execution(* *.*(..)) && this(tesena.advanced.automation.driver.Driver)")
    public void logDriverMethods() {
    }

    @Before(value = "logPageObjectMethods() || logDriverMethods()")
    public void logIntoConsole(JoinPoint joinPoint) {
        String className = joinPoint.getThis().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();

        StringBuilder builder = new StringBuilder();
        builder
                .append(className)
                .append(".")
                .append(methodName)
                .append(Arrays.toString(args));
        LogManager.getLogger("TestLogger").info(builder.toString());
    }
}
