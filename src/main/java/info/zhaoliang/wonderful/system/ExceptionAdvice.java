package info.zhaoliang.wonderful.system;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import info.zhaoliang.wonderful.response.CommunicationFactory;
import info.zhaoliang.wonderful.response.CommunicationResponse;
import info.zhaoliang.wonderful.response.ExceptionResponse;

/**
 * Controller Advice.
 */
@ControllerAdvice
public class ExceptionAdvice {

    /**
     * 错误处理.
     * 
     * @param e Throwable
     * @return CommunicationResponse
     */
    @ExceptionHandler({Throwable.class})
    @ResponseBody
    public CommunicationResponse exceptionHandler(Throwable e) {
        ExceptionResponse response = CommunicationFactory.createCommunicationResponse(ExceptionResponse.class);
        response.processException(e);
        return response;
    }
}