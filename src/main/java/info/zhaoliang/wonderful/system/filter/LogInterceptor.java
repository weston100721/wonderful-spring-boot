package info.zhaoliang.wonderful.system.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

/**
 * @author zhaoliang
 * @create 2018-09-08
 **/
@Log4j2
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final String REQUEST_ID = "requestId";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        String xForwardedForHeader = httpServletRequest.getHeader("X-Forwarded-For");
        String remoteIp = httpServletRequest.getRemoteAddr();
        String uuid = UUID.randomUUID().toString();
        log.info("put requestId ({}) to logger", uuid);
        log.info("request id:{}, client ip:{}, X-Forwarded-For:{}", uuid, remoteIp, xForwardedForHeader);
        MDC.put(REQUEST_ID, uuid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
            ModelAndView modelAndView) throws Exception {
        String uuid = MDC.get(REQUEST_ID);
        log.info("remove requestId ({}) from logger", uuid);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
            Exception e) throws Exception {

    }
}
