package code.service;

import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    public String method() {
        return "123";
    }
}
