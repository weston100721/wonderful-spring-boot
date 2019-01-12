/*
 * 文  件  名：ResultCode.java
 * 版         权：
 * 描         述：
 * 修  改  人：Arris
 * 修改时间：2018-04-17
 * 修改内容：新增
 */

package info.zhaoliang.wonderful.exception;


/**
 * Define the Flow Service return error code to the client
 * All error codes for 6 digits.
 *
 * @author Arris
 * @version C01 2018-04-17
 * @since
 */
public enum RspExtResultCode implements IErrorCode {
    /** 000000 处理成功. */
    CREATE_COMMUNICATION_RESPONSE_ERROR("Rsp001", "创建响应体失败"), DATA_CONVERT_ERROR("Rsp002", "转换错误");

    /**
     * 返回码编码.
     */
    private final String code;

    /**
     * 返回码描述.
     */
    private final String msg;

    /**
     * 构造函数.
     *
     * @param code 返回码编码
     * @param msg 返回码描述
     */
    private RspExtResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取返回码编码.
     *
     * @return 返回码编码
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * 获取返回码描述.
     *
     * @return 返回码描述
     */
    @Override
    public String getMsg() {
        return msg;
    }
}
