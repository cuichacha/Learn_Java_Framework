package code.controller;

import code.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/test1")
    @HystrixCommand(fallbackMethod = "method2")
    public String method1() {
//        int i = 1 / 0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hystrixService.method();
    }

    public String method2() {
        return "provider降级";
    }
}
