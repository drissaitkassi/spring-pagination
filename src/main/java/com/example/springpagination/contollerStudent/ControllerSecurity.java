package com.example.springpagination.contollerStudent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerSecurity {

    @GetMapping(path = "/403")
    public String accessDenied(){
        return "403";
    }
}
