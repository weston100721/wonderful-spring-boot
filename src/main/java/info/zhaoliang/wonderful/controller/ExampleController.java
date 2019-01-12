package info.zhaoliang.wonderful.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.zhaoliang.wonderful.model.params.CustomerDetailParams;
import info.zhaoliang.wonderful.response.CommunicationFactory;
import info.zhaoliang.wonderful.response.SimpleResponse;

/**
 * example.
 * 
 * @author zhaoliang
 **/
@RestController
@RequestMapping("/")
public class ExampleController {

    private static final Logger logger = LogManager.getLogger(ExampleController.class);

    /**
     * heart beat.
     * 
     * @return string
     */
    @RequestMapping("/home")
    SimpleResponse home() {
        SimpleResponse simpleResponse = CommunicationFactory.createSimpleResponse();
        simpleResponse.addData("ok", "Hello World!");
        return simpleResponse;
    }

    /**
     * 完善客户资料.
     *
     * @param params {@linkplain CustomerDetailParams}
     * @return {@linkplain SimpleResponse}
     */
    @PostMapping("/modify")
    public SimpleResponse modify(@Valid CustomerDetailParams params) {
        logger.info(params.toString());
        return CommunicationFactory.createSimpleResponse();
    }
}
