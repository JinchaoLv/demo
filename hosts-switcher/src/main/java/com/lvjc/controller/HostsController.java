package com.lvjc.controller;

import com.lvjc.sevice.HostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by lvjc on 2017/11/2.
 */
@RestController
public class HostsController {

    @Autowired
    private HostsService hostsService;

    @RequestMapping(value = "/schemes", method = RequestMethod.GET)
    public List<String> getSchemes(){
        return hostsService.getSchemes();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addHost(@RequestBody String hosts){
        try {
            hostsService.addHosts(hosts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hostsService.getHosts(null);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getHosts(@RequestParam(value = "scheme", required = false) String scheme){
        return hostsService.getHosts(scheme);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newHostsScheme(@RequestParam("scheme") String scheme){
        if(scheme == null || scheme.equals(""))
            return "failure";
        try {
            hostsService.newScheme(scheme);
            return "success";
        } catch (IOException e) {
            return "failure";
        }
    }

    @RequestMapping(value = "/switch", method = RequestMethod.GET)
    public String switchScheme(@RequestParam("scheme") String scheme){
        try {
            hostsService.switchHosts(scheme);
            return hostsService.getHosts(null);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
