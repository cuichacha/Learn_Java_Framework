package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/TestJsp")
    public String test1() {
        return "Test";
    }

    @RequestMapping("/TestHtml")
    public String test2() {
        return "Test";
    }
}
