package com.lvjc.controller;

import com.lvjc.bean.Host;
import com.lvjc.sevice.HostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lvjc on 2017/11/2.
 */
@RestController
public class HostsController {

    @Autowired
    private HostsService hostsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addHost(@RequestBody List<Host> hosts){
        hostsService
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getHosts(@RequestParam(value = "scheme", required = false) String scheme){
        return hostsService.getHosts(scheme);
    }
}
