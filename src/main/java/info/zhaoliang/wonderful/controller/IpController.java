package info.zhaoliang.wonderful.controller;

import info.zhaoliang.wonderful.utils.IpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaoliang
 **/
@RestController @RequestMapping("/ip")
public class IpController {

    @GetMapping("/getIp")
    String getIp(HttpServletRequest request) {
        return IpUtils.getIpAddress(request);
    }

    @GetMapping("/getIp2")
    String getIp2(HttpServletRequest request) {
        return IpUtils.getIpAddress2(request);
    }
}
