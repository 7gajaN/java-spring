package com.unibuc.Spring.Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @GetMapping("/")
    public String mainPage(){
        return "MAIN PAGE";
    }

}
