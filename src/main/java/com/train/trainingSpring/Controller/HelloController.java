package com.train.trainingSpring.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data","Hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hellotemplate";
    }

}
