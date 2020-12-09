package code.controller;

import code.domain.User;
import code.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @DubboReference
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return userService.hello();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

}
