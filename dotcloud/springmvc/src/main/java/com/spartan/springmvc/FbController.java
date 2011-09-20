package com.spartan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/fb")
public class FbController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
