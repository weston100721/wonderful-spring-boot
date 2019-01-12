package info.zhaoliang.wonderful.exception;

/**
 * 业务异常.
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -3982645755980473694L;
    /** 错误描述. */
    private String msg;
    /** 错误代码. */
    private String code;

    /**
     * 构造方法.
     */
    public BusinessException() {
        super();
    }

    /**
     * 构造方法.
     * 
     * @param resultCode the detail message.
     */
    public BusinessException(IErrorCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * 构造方法.
     *
     * @param cause the cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造方法.
     *
     * @param resultCode the detail message.
     * @param cause the cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public BusinessException(IErrorCode resultCode, Throwable cause) {
        super(resultCode.getMsg(), cause);
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * 构造方法.
     *
     * @param resultCode the detail message.
     * @param cause the cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled or disabled
     * @param writableStackTrace whether or not the stack trace should be writable
     */
    public BusinessException(IErrorCode resultCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(resultCode.getMsg(), cause, enableSuppression, writableStackTrace);
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
