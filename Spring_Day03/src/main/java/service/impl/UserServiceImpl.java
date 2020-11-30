package service.impl;

import service.UserService;

public class UserServiceImpl implements UserService {
    public void findAll() {
        System.out.println("FindAll...");
    }

    public String findById(String id) {
        System.out.println(id);
        return "啦啦啦";
    }
}
