package info.zhaoliang.wonderful.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoliang
 * @create 2018-09-10
 **/
@Log4j2 @RestController @RequestMapping("/article")
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * redis生产者测试
     *
     * @param data
     * @return
     */
    @GetMapping("/send1") String send1(String data) {
        redisTemplate.convertAndSend("testkafka", data);
        return "success";
    }

    /**
     * redis生产者测试
     *
     * @param data
     * @return
     */
    @GetMapping("/send2") String send2(String data) {
        redisTemplate.convertAndSend("testkafka1", data);
        return "success";
    }
}
