package code.service;

import code.domain.User;

public interface UserService {
    public abstract String hello();

    public abstract User findById(Integer id);
}
