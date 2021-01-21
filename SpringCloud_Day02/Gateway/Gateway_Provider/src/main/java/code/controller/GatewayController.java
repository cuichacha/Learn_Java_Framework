package code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class GatewayController {

    @GetMapping("/method1")
    public String method1(String username) {
        System.out.println(username);
        return "123";
    }
}
