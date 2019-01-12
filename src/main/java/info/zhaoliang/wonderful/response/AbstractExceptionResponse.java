package info.zhaoliang.wonderful.response;

/**
 * 装载异常的响应体.
 */
public abstract class AbstractExceptionResponse extends CommunicationResponse {

    /** 错误消息的长度. **/
    public static final int ERROR_MSG_LENGTH = 30;

    /**
     * 标记异常，获取异常信息.
     * 
     * @param e 接到到的异常类
     */
    public abstract void processException(Throwable e);

    /**
     * 过滤错误的消息.
     * 
     * @param msg 错误信息
     * @return 返回截取后的错误信息
     */
    public String filterErrorMsg(String msg) {
        if (msg != null) {
            if (msg.length() > ERROR_MSG_LENGTH) {
                msg = msg.substring(0, 30) + "...";
            }
        }
        return msg;
    }
}
