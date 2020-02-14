package www.j1stiot.cn.pdf.itext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class Demo4 {

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }


}
