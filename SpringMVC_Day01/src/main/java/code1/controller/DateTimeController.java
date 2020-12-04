package code1.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class DateTimeController {

    @RequestMapping("/Date1")
    public String test1(@DateTimeFormat(pattern = "yyyy-MM-dd")Date date) {
        System.out.println(date);
        return "Test1";
    }

    @RequestMapping("/Date2")
    public String test2(Date date) {
        System.out.println(date);
        return "Test1";
    }
}
