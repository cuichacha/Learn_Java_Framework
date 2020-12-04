package code1.controller;

import code1.domain.TestBean2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"name", "age"})
public class DataController {
    @RequestMapping("/Data1")
    public String test1(@RequestHeader("Accept-Encoding") String head, @RequestParam String username) {
        System.out.println(head);
        System.out.println(username);
        return "Test1";
    }

    @RequestMapping("/Data2")
    public String test2(@CookieValue("JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
        return "Test1";
    }

    @RequestMapping("/Data3")
    public String test3(@SessionAttribute("name") String name, @SessionAttribute("age") int age) {
        System.out.println(name);
        System.out.println(age);
        return "Test1";
    }

    @RequestMapping("/Data4")
    public ModelAndView test4(ModelAndView modelAndView) {
        TestBean2 testBean2 = new TestBean2();
        modelAndView.addObject("aThing", "something");
        modelAndView.addObject("aTestBean", testBean2);
        modelAndView.setViewName("Test1");
        return modelAndView;
    }

    @RequestMapping("/Data5")
    public String test5(Model model) {
        model.addAttribute("name", "啦啦啦");
        model.addAttribute("age", 0);
        return "Test1";
    }

    @RequestMapping("/Data6")
    @ResponseBody
    public String test6() throws JsonProcessingException {
        TestBean2 testBean2 = new TestBean2();
        testBean2.setName("嘿嘿嘿");
        testBean2.setAge(0);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(testBean2);
    }

}
