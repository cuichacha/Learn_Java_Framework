package code2.controller;

import code2.domain.TestBean1;
import code2.domain.TestBean2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/Test1")
    public String test1() {
        System.out.println("啦啦啦");
        return "Test2";
    }

    @RequestMapping("/Test2")
    public String test2(String input) {
        System.out.println(input);
        return "Test2";
    }

    @RequestMapping("/Test3")
    public String test3(@RequestParam List<String> list, @RequestParam Map<String, String> map) {
        System.out.println(list);
        System.out.println(map);
        return "Test2";
    }

    // name=1&age=1&list[0]=1&list[1]=2&map['k1']=v1&map['k2']=v2&testBean2.name=1&testBean2.age=1
    // testBean2List[0].name=0&testBean2List[0].age=0&testBean2List[1].name=1&testBean2List[1].age=1
    // testBean2Map['k1'].name=1&testBean2Map['k1'].age=1&testBean2Map['k2'].name=2&testBean2Map['k2'].age=2

    @RequestMapping("/Test4")
    public String test4(TestBean1 testBean1) {
        System.out.println(testBean1);
        System.out.println(testBean1.getTestBean2List());
        System.out.println(testBean1.getTestBean2Map());
        return "Test2";
    }

    @RequestMapping("/Test5")
    public String test5(Date date) {
        System.out.println(date);
        return "Test2";
    }
}
