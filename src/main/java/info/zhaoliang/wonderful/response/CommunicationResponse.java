package info.zhaoliang.wonderful.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象的通讯响应体.
 */
public abstract class CommunicationResponse {
    protected static final Logger logger = LoggerFactory.getLogger(CommunicationResponse.class);

    /**
     * 唯一id.
     */
    protected String requestId;
    /**
     * 状态码0代表成功 其它代表失败.
     */
    protected String status;
    /**
     * 错误或成功信息.
     */
    protected String msg;

    /**
     * 数据容器.
     */
    protected Map<String, Object> data = new HashMap<>();

    /**
     * 快速的设置各种信息.
     * 
     * @param status 状态码
     * @param msg 描述信息
     */
    public void quickSet(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 快速的设置各种信息.
     * 
     * @param msg 代替描述信息
     */
    public void quickSet(String msg) {
        this.msg = msg;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * 请求结果状态码 0代码成功。其它数据代表失败.
     * 
     * @return String
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 请求结果描述，成功 一个会显示成功字样，如果失败一般会显示失败的原因.
     * 
     * @return String
     */
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 响应数据体，具体的数据一般放到这个里面，并且map的key一个要写成静态fianl变量，一般放到具体的响应类里面.
     * 
     * @return Map
     */
    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * 向data节点里面添加数据.
     * 
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     */
    public void addData(String key, Object value) {
        this.keepDataNotNull();
        data.put(key, value);
    }

    /**
     * 保证Data数据不为空.
     */
    public void keepDataNotNull() {
        if (data == null) {
            data = new LinkedHashMap<String, Object>();
        }
    }

    /**
     * 向data节点里面添加多个数据.
     * 
     * @param datas Map数据
     */
    public void addDatas(Map<String, ? extends Object> datas) {
        this.keepDataNotNull();
        data.putAll(datas);
    }

    @Override
    public String toString() {
        return "CommunicationResponse{" + "requestId='" + requestId + '\'' + ", status='" + status + '\'' + ", msg='" + msg
                + '\'' + ", data=" + data + '}';
    }
}
