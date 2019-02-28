package info.zhaoliang.wonderful;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;


/**
 * starter application.
 * 
 * @author zhaoliang
 **/
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableConfigurationProperties
@EnableScheduling
@MapperScan("info.zhaoliang.wonderful.dao")
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 将long 装换Date类型.
     * 
     * @return Converter
     */
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String milliseconds) {
                Date date;
                try {
                    if (StringUtils.isEmpty(milliseconds)) {
                        return new Date();
                    }
                    Long dateLong = Long.valueOf(milliseconds);
                    date = new Date(dateLong);
                } catch (Exception e) {
                    throw new info.zhaoliang.wonderful.exception.BusinessException(e);
                }
                return date;
            }
        };
    }

    @Bean RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("testkafka"));
        container.addMessageListener(listenerAdapter, new PatternTopic("testkafka1"));//配置要订阅的订阅项
        return container;
    }
}
