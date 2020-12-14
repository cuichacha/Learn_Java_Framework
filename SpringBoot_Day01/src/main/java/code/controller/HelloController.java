package code.controller;

import code.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Student student;

    @Autowired
    private Environment environment;

    @Value("${something1}")
    private String something1;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(environment.getProperty("something2"));
        System.out.println(something1);
        System.out.println(student);
        return "Hello";
    }
}
