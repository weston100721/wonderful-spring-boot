package info.zhaoliang.wonderful.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import info.zhaoliang.wonderful.exception.BusinessException;

/**
 * 通讯体工厂类<BR>
 * 用于生成各种不同的通讯体.
 */
public class CommunicationFactory {
    /** 日志输出对象. **/
    protected static final Logger logger = LoggerFactory.getLogger(CommunicationFactory.class);

    private static final String REQUEST_ID_STRING = "requestId";

    /**
     * 生成异常响应.
     * 
     * @param clazz 异常处理现实现类
     * @param e 异常
     * @param <P> AbstractExceptionResponse
     * @return C
     */
    public static <P extends AbstractExceptionResponse> P createExceptionResponse(Class<P> clazz, Throwable e) {
        AbstractExceptionResponse resp = createCommunicationResponse(clazz);
        resp.processException(e);
        return null;
    }

    /**
     * 生成异常响应.
     * 
     * @param e 异常
     * @return ExceptionResponse
     */
    public static ExceptionResponse createExceptionResponse(Throwable e) {
        ExceptionResponse resp = createCommunicationResponse(ExceptionResponse.class);
        resp.processException(e);
        return resp;
    }

    /**
     * 生成最简单的响应体.
     * 
     * @return SimpleResponse
     */
    public static SimpleResponse createSimpleResponse() {
        return createCommunicationResponse(SimpleResponse.class);
    }

    /**
     * 创建普通响应体，请求和响应必须保持一致的命名.
     *
     * @param clazz 异常处理现实现类
     * @param <C> CommunicationResponse
     * @return C
     */
    public static <C extends CommunicationResponse> C createCommunicationResponse(Class<C> clazz) {
        try {
            C resp = clazz.newInstance();
            Object traceId = MDC.get(REQUEST_ID_STRING);
            if (traceId == null) {
                logger.error("createCommunicationResponse getTraceId is null.");
            }
            if (logger.isDebugEnabled()) {
                logger.debug(String.format("createCommunicationResponse(),traceId:%s", traceId));
            }
            resp.setRequestId(traceId == null ? "" : traceId.toString());
            resp.setStatus("0");
            resp.setMsg("success");
            return resp;
        } catch (Exception e) {
            throw new BusinessException();
        }
    }
}
