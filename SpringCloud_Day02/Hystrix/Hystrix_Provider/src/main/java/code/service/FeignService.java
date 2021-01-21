package code.service;

import org.springframework.stereotype.Service;

@Service
public class FeignService {

    public String method() {
        return "123";
    }
}
