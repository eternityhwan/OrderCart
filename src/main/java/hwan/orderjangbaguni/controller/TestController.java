package hwan.orderjangbaguni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping(value = "test")
    public String Test(Model model) {
        model.addAttribute("name","hwan");
        return "test";
        // 리턴은 화면 이름이다.
        // templates 디렉토리 아래 html 파일에 반영된다.
    }
}
