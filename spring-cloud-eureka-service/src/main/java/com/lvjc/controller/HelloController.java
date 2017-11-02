package com.lvjc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lvjc on 2017/10/12.
 */
@RestController
public class HelloController {

    @Autowired
    private Registration registration;
    @Autowired
    private DiscoveryClient discoveryClient;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){
        ServiceInstance serviceInstance = this.getLocalServiceInstance();
        logger.info("/hello, host:" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ", serviceId:" + serviceInstance.getServiceId());
        return "Hello world";
    }

    private ServiceInstance getLocalServiceInstance(){
        List<ServiceInstance> instances = discoveryClient.getInstances(registration.getServiceId());
        return CollectionUtils.isEmpty(instances) ? null : instances.get(0);
    }
}
