package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by huang on 2017/11/13.
 */
@Controller
public class ErrorController {

    @GetMapping("/403")
    public String forbidden(){
        return"error/403";
    }

    @GetMapping("/404")
    public String notFound(){
        return"error/404";
    }

    @GetMapping("/500")
    public String serverError(){
        return"error/500";
    }

}
