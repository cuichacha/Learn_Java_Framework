package code.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @Autowired
    private HystrixInterface hystrixInterface;

    @GetMapping("/test1")
    @HystrixCommand(fallbackMethod = "method2")
    public String method1() {
//        int i = 1 / 0;
        return hystrixInterface.method1();
    }

    public String method2() {
        return "Consumer降级";
    }
}
