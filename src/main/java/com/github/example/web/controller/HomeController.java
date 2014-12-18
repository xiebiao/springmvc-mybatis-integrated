package com.github.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView user(@Valid UserForm userForm,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("" + bindingResult.getAllErrors().get(0).getDefaultMessage());

        }
        System.out.println(HomeController.class.getName());
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/messages.json", method = RequestMethod.GET)
    public Map<String, String> messages() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiebiao");
        return map;
    }
}
