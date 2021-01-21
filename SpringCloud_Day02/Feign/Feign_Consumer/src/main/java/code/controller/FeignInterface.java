package code.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "FEIGN-PROVIDER")
public interface FeignInterface {

    @GetMapping("/test1")
    public abstract String method1();
}
