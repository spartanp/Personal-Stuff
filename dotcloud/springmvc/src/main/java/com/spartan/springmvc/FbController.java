package com.spartan.springmvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/fb")
public class FbController {
    private Logger logger = Logger.getLogger(this.getClass());
    
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        logger.info("facebook request came in");
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String hellopost() {
        logger.info("facebook request came in");
        return "hello";
    }

}
