package code.controller;

import code.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/test")
    public String controlService() {
        return providerService.provideService();
    }
}
