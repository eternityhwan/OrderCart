package hwan.orderjangbaguni.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    //@Slf4j 한방에 이 코드 하나가 사라진다.
    //Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/")
    public String home() {
        log.info("home controller");
        return "home";
    }
}
