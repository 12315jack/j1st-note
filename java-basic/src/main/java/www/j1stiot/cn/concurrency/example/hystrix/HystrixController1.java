package www.j1stiot.cn.concurrency.example.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hystrix1")
@DefaultProperties(defaultFallback = "defaultFail")
public class HystrixController1 {

    // logger
    private static final Logger logger = LoggerFactory.getLogger(HystrixController1.class);

    @HystrixCommand(fallbackMethod = "fail1")
    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        throw new RuntimeException();
    }

    private String fail1() {
        logger.warn("fail1");
        return "fail1";
    }

    @HystrixCommand(fallbackMethod = "fail2")
    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {
        throw new RuntimeException();
    }

    @HystrixCommand(fallbackMethod = "fail3")
    private String fail2() {
        logger.warn("fail2");
        throw new RuntimeException();
    }

    @HystrixCommand
    private String fail3() {
        logger.warn("fail3");
        throw new RuntimeException();
    }

    private String defaultFail() {
        logger.warn("default fail");
        return "default fail";
    }
}
