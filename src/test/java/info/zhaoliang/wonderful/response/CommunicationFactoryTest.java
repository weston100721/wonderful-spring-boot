package info.zhaoliang.wonderful.response;

import org.slf4j.MDC;

/**
 * @author zhaoliang
 * @create 2018-09-06
 **/
public class CommunicationFactoryTest {

    @org.junit.Test
    public void createExceptionResponse() {
    }

    @org.junit.Test
    public void createExceptionResponse1() {
    }

    @org.junit.Test
    public void createSimpleResponse() {
    }

    @org.junit.Test
    public void createCommunicationResponse() {
        Object traceId = MDC.get("traceId");
        System.out.println(traceId);
    }
}