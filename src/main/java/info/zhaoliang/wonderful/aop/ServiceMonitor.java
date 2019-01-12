package info.zhaoliang.wonderful.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j2;

/**
 * 服务检测.
 * 
 * @author zhaoliang
 **/
@Log4j2
@Aspect
@Component
public class ServiceMonitor {

    /**
     * 切点.
     */
    @Pointcut("execution(public * info.zhaoliang.wonderful.service.*.*(..))")
    public void servicePoint() {
    }

    /**
     * 切点前要做的事.
     * 
     * @param joinPoint JoinPoint
     */
    @Before("servicePoint()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url = {},ip = {},args = {}", request.getRequestURI(), request.getRemoteAddr(), joinPoint.getArgs());
    }

    /**
     * 切点之后要做的事.
     * 
     * @param joinPoint JoinPoint
     */
    @AfterReturning("servicePoint()")
    public void logServiceAccess(JoinPoint joinPoint) {
        log.info("joinPoint : {}", joinPoint);

    }
}
