package tesena.advanced.automation.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

@Aspect
public class LogAspect {

    @Pointcut("execution(* *.*(..)) && this(tesena.advanced.automation.components.Component+)")
    public void componentsMethods() {
    }

    @Pointcut("execution(* *.*(..)) && this(tesena.advanced.automation.objects.PageObject+)")
    public void objectsMethods() {
    }

    @Before(value = "componentsMethods() || objectsMethods()")
    public void log(JoinPoint joinPoint) {
        String className = joinPoint.getThis().getClass().getSimpleName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();
        Object [] arguments = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className)
                .append(".")
                .append(methodName)
                .append(Arrays.toString(arguments));
        TestLogger.getLogger().info(stringBuilder.toString());
    }
}
