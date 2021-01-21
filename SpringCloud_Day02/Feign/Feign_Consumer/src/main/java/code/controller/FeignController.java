package code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("/test1")
    public String method1() {
        return feignInterface.method1();
    }
}
