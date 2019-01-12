package info.zhaoliang.wonderful.exception;

/**
 * 扩展组件响应异常.
 * 
 * @author kyle
 * @version v1.0 2018/06/19
 */
public class RspExtException extends BusinessException {
    private static final long serialVersionUID = -1918365948197438940L;

    /**
     * 构造方法.
     * 
     * @param resultCode 返回错误结果
     * @param cause 异常原因
     */
    public RspExtException(IErrorCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    /**
     * 构造方法.
     * 
     * @param resultCode 返回错误结果
     */
    public RspExtException(IErrorCode resultCode) {
        super(resultCode);
    }

    /**
     * 构造方法.
     * 
     * @param cause 异常原因
     */
    public RspExtException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造方法.
     * 
     * @param resultCode 返回错误结果
     * @param cause 异常原因
     * @param enableSuppression 是否启用或禁用抑制
     * @param writableStackTrace 堆栈跟踪是否应该可写
     */
    public RspExtException(IErrorCode resultCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(resultCode, cause, enableSuppression, writableStackTrace);
    }

}
