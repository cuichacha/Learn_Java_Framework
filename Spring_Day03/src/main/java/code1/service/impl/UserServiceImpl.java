package code1.service.impl;

import code1.service.UserService;

public class UserServiceImpl implements UserService {
    public void findAll() {
        System.out.println("FindAll...");
    }

    public String findById(String id) {
        System.out.println(id);
        return "啦啦啦";
    }

    public void save() {
        System.out.println("嘿嘿嘿");
    }
}
