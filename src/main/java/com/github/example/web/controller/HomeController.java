package com.github.example.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView index(HttpServletRequest request) {
    WebApplicationContext applicationContext =
        WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

    // Map<String, HandlerMapping> matchingBeans =
    // BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, HandlerMapping.class,
    // true, false);
    // for(HandlerMapping handlerMapping:matchingBeans.values()){
    // System.out.println(handlerMapping.getClass());
    // }

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
