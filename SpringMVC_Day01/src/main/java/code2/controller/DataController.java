package code2.controller;

import code2.domain.TestBean1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"name", "age"})
public class DataController {
    @RequestMapping("/Data1")
    public ModelAndView test1(ModelAndView modelAndView) {
        TestBean1 testBean1 = new TestBean1();
        modelAndView.addObject("something", "啦啦啦");
        modelAndView.addObject("aBean", testBean1);
        modelAndView.setViewName("Test2");
        return modelAndView;
    }

    @RequestMapping("/Data2")
    @ResponseBody
    public String test2() throws JsonProcessingException {
        TestBean1 testBean1 = new TestBean1();
        testBean1.setStr("啦啦啦");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(testBean1);
    }

    @RequestMapping("/Data3")
    public String test3(Model model) {
        model.addAttribute("name", "啦啦啦");
        model.addAttribute("age", 0);
        return "Test2";
    }

    @RequestMapping("/Data4")
    public String test4(@SessionAttribute("name") String name, @SessionAttribute("age") int age) {
        System.out.println(name);
        System.out.println(age);
        return "Test2";
    }

}
