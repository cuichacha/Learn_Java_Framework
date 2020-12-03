package code1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/Test")
    public String testController() {
        System.out.println("啦啦啦");
        return "/Test.jsp";
    }
}
