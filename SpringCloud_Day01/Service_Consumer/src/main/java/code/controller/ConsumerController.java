package code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/test1")
    public String controlConsumer1() {

        String forObject = restTemplate.getForObject("http://localhost:8081/test", String.class);
        return forObject;
    }

    @GetMapping("test2")
    public String controlConsumer2() {

        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        if (instances == null || instances.isEmpty()) {
            return null;
        }

        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        System.out.println(host);
        int port = serviceInstance.getPort();

        String forObject = restTemplate.getForObject("http://" + host + ":" + port + "/test", String.class);
        return forObject;
    }
}
