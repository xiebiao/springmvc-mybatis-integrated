package com.github.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView index() {
    System.out.println(HomeController.class.getName());
    ModelAndView mv = new ModelAndView("index");
    return mv;
  }

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ModelAndView user() {
    System.out.println(HomeController.class.getName());
    ModelAndView mv = new ModelAndView();
    return mv;
  }
}
