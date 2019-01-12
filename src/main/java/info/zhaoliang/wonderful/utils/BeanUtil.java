package info.zhaoliang.wonderful.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 扩充beanUtils里面没有的方法.
 * 
 * @author ??
 * @version v1.0 2018/06/19
 */
public class BeanUtil {
    /**
     * MAP转成class对象.
     * 
     * @param clazz 对象类
     * @param map map数据
     * @param <T> 转换对象
     * @return T
     */
    public static <T> T populate(Class<T> clazz, Map<String, Object> map) {
        try {
            T t;
            t = clazz.newInstance();
            populate(t, map);
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("系统异常", e);
        }
    }

    /**
     * 把map里的值放到obj中.
     * 
     * @param obj 转换对象
     * @param map map数据
     */
    @SuppressWarnings("unchecked")
    public static void populate(Object obj, Map<String, Object> map) {
        if (obj instanceof Map) {
            map.putAll((Map<? extends String, ? extends Object>) obj);
            return;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            throw new RuntimeException("系统异常", e);
        }

    }

    /**
     * 把对象转换成map.
     * 
     * @param obj 转换对象
     * @return Map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> describe(Object obj) {
        Map<String, Object> map = new HashMap<>(20);
        if (obj instanceof Map) {
            map.putAll((Map<? extends String, ? extends Object>) obj);
            return map;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!"class".equals(key)) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }

            }
            return map;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            throw new RuntimeException("系统异常", e);
        }

    }

}
