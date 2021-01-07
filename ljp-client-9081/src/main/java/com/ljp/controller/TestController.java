package com.ljp.controller;

import com.ljp.common.vo.Result;
import com.ljp.service.TestService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private RestTemplate restTemplate;
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/test/rpc/helloWorld")
    public String helloWorld() {
        String result = restTemplate.getForObject("http://LJP-CLIENT-TWO/test/testOne", String.class);
        System.out.println("远程调用结果是：" + result);
        Application application = eurekaClient.getApplication("LJP-CLIENT-TWO");
        List<InstanceInfo> instances = application.getInstances();
        instances.forEach(t -> {
            System.err.println(t.getIPAddr());
            System.err.println(t.getAppName());
        });
//        List<ServiceInstance> ls = discoveryClient.getInstances("LJP-CLIENT-TWO");
//        ls.forEach(t -> {
//            System.out.println(t.getUri());
//        });
        return result;
    }

    @GetMapping("/test/helloWorld")
    public String helloWorld(@RequestParam("name") String name) {
        return "Hello World " + name + "!!!";
    }

    @GetMapping("/test/listAll")
    public Map<String, Object> listAll() {
        return testService.listAll();
    }

    @PostMapping("/test/saveAll")
    public Result saveAll() {
        return testService.saveAll();
    }

}
