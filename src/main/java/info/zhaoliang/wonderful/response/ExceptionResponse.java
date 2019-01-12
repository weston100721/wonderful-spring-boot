package info.zhaoliang.wonderful.response;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import info.zhaoliang.wonderful.exception.BusinessException;

/**
 * 响应异常处理.
 * 
 * @author kyle
 * @version v1.0 2018/06/19
 */
public class ExceptionResponse extends AbstractExceptionResponse {

    @Override
    public void processException(Throwable e) {
        this.msg = e.getMessage();
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            StringBuilder stringBuilder = new StringBuilder();
            for (ConstraintViolation<?> item : violations) {
                stringBuilder.append(item.getMessage());
            }
            super.quickSet("999999999", stringBuilder.toString());
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            BindingResult bindingResult = bindException.getBindingResult();
            FieldError fieldError = bindingResult.getFieldError();
            super.quickSet("999999999", fieldError.getField() + ":" + fieldError.getDefaultMessage());
        } else if (e instanceof BusinessException) {
            logger.debug("业务异常", e);
            BusinessException be = (BusinessException) e;
            super.quickSet(be.getCode(), be.getMsg());
        } else if (e instanceof IllegalArgumentException) {
            logger.debug("非法参数异常", e);
            super.quickSet("B0001", msg);
        } else if (e instanceof NullPointerException) {
            logger.error("空指针异常", e);
            super.quickSet("N0001", "为空异常");
        } else if (e instanceof RuntimeException) {
            logger.error("运行时异常", e);
            msg = this.filterErrorMsg(msg);
            super.quickSet("R0001", "系统异常");
        } else {
            logger.error("未知异常", e);
            msg = this.filterErrorMsg(msg);
            super.quickSet("W0001", "系统异常");
        }
        if (msg == null) {
            super.setStatus("W0001");
            this.msg = "未知异常";
        }
    }

}
