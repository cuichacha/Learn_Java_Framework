package code.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "HYSTRIX-PROVIDER")
public interface HystrixInterface {

    @GetMapping("/test1")
    public abstract String method1();
}
