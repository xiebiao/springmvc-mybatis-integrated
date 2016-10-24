package com.github.example.web.controller;

import com.github.web.Result;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView user(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("" + bindingResult.getAllErrors().get(0).getDefaultMessage());

        }
        System.out.println(HomeController.class.getName());
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@Valid UserForm userForm, BindingResult bindingResult) {
        Result result = new Result();
        return result;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(@Valid UserForm userForm, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("test/add");
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
