package service.impl;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private Integer num;
    private String str;

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public UserServiceImpl(UserDao userDao, Integer num, String str) {
//        this.userDao = userDao;
//        this.num = num;
//        this.str = str;
//    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("啦啦啦");
        userDao.save();
        System.out.println(num);
        System.out.println(str);
    }

    public void print() {
        System.out.println(username);
        System.out.println(password);
    }

}
