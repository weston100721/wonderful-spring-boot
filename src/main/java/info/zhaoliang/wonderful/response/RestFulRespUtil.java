package info.zhaoliang.wonderful.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import info.zhaoliang.wonderful.exception.RspExtException;
import info.zhaoliang.wonderful.exception.RspExtResultCode;
import info.zhaoliang.wonderful.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 符合 Restful的响应体. CommunicationResponse 支持几种高级操作 1,把bean里面的属性插到data中，支持单个添加也支持多次添加。 2,把data中的属性反回到bean中。
 * 3,把list.bean插到data的key中以list形式储存。 4,把bean插到data的key中以list形式储存。 5,把key value插到data的key中以list的每个数据中.
 * 
 * @author ？？
 * @version v1.0 2018/06/19
 */
public class RestFulRespUtil {

    /**日志输出对象.**/
    protected static final Logger logger = LoggerFactory.getLogger(RestFulRespUtil.class);

    /**
     * 把bean属性数据填充到resp的data(map结构)里面，以key value储存. value: 13243344 resp.data: {name:"fdfsf"} resp.data:
     * {name:"fdfsf",key:13243344}
     * 
     * @param resp 响应类
     * @param key 键
     * @param value 值
     */
    public static void addDataField(CommunicationResponse resp, String key, Object value) {
        Map<String, Object> map = new HashMap<>(20);
        map.put(key, value);
        fillDataField(resp, map);
    }

    /**
     * 把bean属性数据填充到resp的data(map结构)里面，以key value储存. bean: {name:"name",date:15648649687} resp.data: {} resp.data:
     * {name:"name",date:15648649687}
     * 
     * @param resp 响应类
     * @param bean 存储结果对象
     */
    public static void fillDataField(CommunicationResponse resp, Object bean) {
        resp.keepDataNotNull();
        Map<String, Object> map = BeanUtil.describe(bean);
        resp.addDatas(map);
    }

    /**
     * 把bean属性数据填充到resp的data(map结构)里面下的mapKey，以map储存. bean: {name:"name",date:15648649687} resp.data: {} resp.data:
     * {mapKey:{name:"name",date:15648649687}}
     * 
     * @param resp 响应类
     * @param mapKey map数据
     * @param bean 存储结果对象
     */
    public static void fillDataMap(CommunicationResponse resp, String mapKey, Object bean) {
        resp.keepDataNotNull();
        Object map = resp.getData().get(mapKey);
        map = merge(map, bean);
        resp.getData().put(mapKey, map);
    }

    /**
     * 合并数据.
     * 
     * @param targ 目标类
     * @param bean 结果类
     * @return Object
     */
    @SuppressWarnings("unchecked")
    private static Object merge(Object targ, Object bean) {
        if (targ == null) {
            targ = new LinkedHashMap<String, Object>();
        } else if (!(targ instanceof Map)) {
            Map<String, Object> tempTrag = new LinkedHashMap<String, Object>();
            tempTrag.putAll(BeanUtil.describe(targ));
            targ = tempTrag;
        }
        ((Map<String, Object>) targ).putAll(BeanUtil.describe(bean));
        return targ;
    }

    /**
     * 合并数据.
     * 
     * @param targ 目标类
     * @param key 键
     * @param value 值
     * @return Object
     */
    private static Object merge(Object targ, String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>(20);
        map.put(key, value);
        return merge(targ, map);
    }

    /**
     * 把value追加到resp的data(map结构)里面下的mapKey，以key value储存. value: {name:"name",date:15648649687} resp.data:
     * {mapKey:{name:"name",date:15648649687}} resp.data: {mapKey:{name:"name",date:15648649687,key:value}}
     * 
     * @param resp 响应体
     * @param mapKey map数据的key
     * @param key 键
     * @param value 值
     */
    public static void addDataMap(CommunicationResponse resp, String mapKey, String key, Object value) {
        Map<String, Object> map = new HashMap<>(20);
        map.put(key, value);
        fillDataMap(resp, mapKey, map);
    }

    /**
     * 把list.bean属性数据填充到resp的data(map结构)里面的tableKey，以[{key:value}],[{key:value}],[{key:value}]储存. list.bean:
     * [{key:value},{key:value},{key:value}] resp.data: {} resp.data: {tableKey:[{key:value},{key:value},{key:value}]}
     * 
     * @param resp 响应体
     * @param tableKey data中list数据的key
     * @param list list数据
     */
    @SuppressWarnings("unchecked")
    public static void fillDataTable(CommunicationResponse resp, String tableKey, List<? extends Object> list) {
        resp.keepDataNotNull();
        @SuppressWarnings("rawtypes")
        List beanList = holdDataTable(resp, tableKey);
        for (Object bean : list) {
            beanList.add(BeanUtil.describe(bean));
        }
    }

    /**
     * 把bean中的属性数据填充 到data中tableKey对应的list中的多个bean中使用 list中的多个bean扩展属性. key:key1 value:value1 resp.data:
     * {tableKey:[{key:value},{key:value},{key:value}]} resp.data:
     * {tableKey:[{key:value,key1:value1},{key:value,key1:value1},{key:value,key1:value1}]}
     * 
     * @param resp 响应体
     * @param tableKey data中list数据的key
     * @param key 键
     * @param value 值
     */
    @SuppressWarnings("unchecked")
    public static void fillDataTableField(CommunicationResponse resp, String tableKey, String key, String value) {
        resp.keepDataNotNull();
        if (resp.getData().get(tableKey) == null) {
            return;
        }
        @SuppressWarnings("rawtypes")
        List beanList = holdDataTable(resp, tableKey);
        for (int i = 0; i < beanList.size(); i++) {
            Object map = beanList.get(i);
            map = merge(map, key, value);
            beanList.set(i, map);
        }
    }

    /**
     * 把bean追加到 resp.data中tableKey 对应的list中. resp.data: {tableKey:[{key:value},{key:value},{key:value}]} bean: {key2:value2}
     * resp.data: {tableKey:[{key:value},{key:value},{key:value},{key2:value2}]}
     * 
     * @param resp 响应体
     * @param tableKey data中list数据的key
     * @param bean 结果对象
     */
    public static void addDataTableElement(CommunicationResponse resp, String tableKey, Object bean) {
        fillDataTable(resp, tableKey, Arrays.asList(bean));
    }

    /**
     * 确保data 存在某个key且value为list.
     * 
     * @param resp 响应体
     * @param tableKey data中list数据的key
     * @return List<?>
     */
    private static List<?> holdDataTable(CommunicationResponse resp, String tableKey) {
        resp.keepDataNotNull();
        List<?> beanList = (List<?>) resp.getData().get(tableKey);
        if (beanList == null) {
            beanList = new ArrayList<>();
            resp.getData().put(tableKey, beanList);
        } else if (!(beanList instanceof List)) {
            logger.error("转换错误", String.format("无法把data中的属性%s当成%s使用,目前只支持List", tableKey, beanList.getClass()));
            throw new RspExtException(RspExtResultCode.DATA_CONVERT_ERROR);
        }
        return beanList;
    }

}
