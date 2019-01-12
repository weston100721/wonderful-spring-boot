package info.zhaoliang.wonderful.exception;

/**
 * 错误信息返回接口.
 * 
 * @author: kyle
 * @date: 2018年6月19日 下午5:37:53
 */
public interface IErrorCode {

    /**
     * 返回的错误码.
     * 
     * @return String
     */
    public String getCode();

    /**
     * 返回的错误信息.
     * 
     * @return String
     */
    public String getMsg();
}
