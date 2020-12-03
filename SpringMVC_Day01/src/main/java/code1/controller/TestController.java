package code1.controller;

import code1.domain.TestBean1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/Test1")
    public String testController1() {
        System.out.println("啦啦啦");
        return "/Test.jsp";
    }

    @RequestMapping("/Test2")
    public String testController2(String name, int age) {
        System.out.println(name + "," + age);
        return "/Test.jsp";
    }

    // list=1&list=2
    // 普通list必须这么写，不能list[0]=1&list[1]=2这么写，不然报错

    @RequestMapping("/Test3")
    public String testController3(@RequestParam List<String> list) {
        System.out.println(list);
        return "/Test.jsp";
    }

    // k1=v1&k2=v2
    // 普通map必须这么写，不能map['k1']=v1&map['k2']=v2这么写，不然报错

    @RequestMapping("/Test4")
    public String testController4(@RequestParam Map<String, String> map) {
        System.out.println(map);
        return "/Test.jsp";
    }

    // name=1&age=1&list[0]=1&list[1]=2&map['k1']=v1&map['k2']=v2&testBean2.name=1&testBean2.age=1
    // testBean2List[0].name=0&testBean2List[0].age=0&testBean2List[1].name=1&testBean2List[1].age=1
    // testBean2Map['k1'].name=1&testBean2Map['k1'].age=1&testBean2Map['k2'].name=2&testBean2Map['k2'].age=2

    @RequestMapping("/Test5")
    public String testController5(TestBean1 testBean1) {
        System.out.println(testBean1);
        System.out.println(testBean1.getTestBean2());
        System.out.println(testBean1.getTestBean2List());
        System.out.println(testBean1.getTestBean2Map());

        return "/Test.jsp";
    }
}
