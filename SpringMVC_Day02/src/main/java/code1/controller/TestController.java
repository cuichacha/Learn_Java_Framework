package code1.controller;

import code1.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/Test1")
    public String test1() {
        System.out.println("啦啦啦");
        return "Test1";
    }

    @RequestMapping("/Test2")
    public String test2() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        System.out.println("啦啦啦");
        return "Test1";
    }
}
