package code1.controller;

import code1.domain.Person;
import code1.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/Test1")
    public String test1() {
        System.out.println("啦啦啦");
        return "Test1";
    }

    @RequestMapping("/Test2")
    public String test2() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        System.out.println("啦啦啦");
        return "Test1";
    }

    @RequestMapping("/Test3")
    public String test3() throws Exception {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new Exception(e);
        }
        System.out.println("啦啦啦");
        return "Test1";
    }

    @RequestMapping("/Test4")
    public String test4(@RequestBody String message) {
        System.out.println(message);
        return "Test1";
    }

    @RequestMapping("/Test5")
    public String test5(@RequestBody Person person) {
        System.out.println(person);
        return "Test1";
    }

    @RequestMapping("/Test6")
    public String test6(@RequestBody List<Person> list) {
        System.out.println(list);
        return "Test1";
    }

    @RequestMapping("/Test7")
    @ResponseBody
    public String test7() {
        System.out.println("啦啦啦");
        return "啦啦啦";
    }

    @RequestMapping("/Test8")
    @ResponseBody
    public Person test8() {
        Person person = new Person();
        person.setName("啦啦");
        person.setAge(0);
        System.out.println("啦啦啦");
        return person;
    }

    @RequestMapping("/Test9")
    @ResponseBody
    public List test9() {
        Person person1 = new Person();
        person1.setName("啦啦");
        person1.setAge(0);
        Person person2 = new Person();
        person2.setName("嘿嘿");
        person2.setAge(1);
        System.out.println("啦啦啦");
        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        return people;
    }
}
