package com.github.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.example.domain.User;
import com.github.example.service.UserService;

/**
 * @author xiaog
 */
@Controller
public class UserController {

  @Autowired
  private UserService userService;
  private final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(this.getClass());

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ModelAndView user() {
    int pageIndex = 1;
    int pageSize = 1;
    ModelAndView mv = new ModelAndView("user");
    User user = new User();
    List<User> dataPage = userService.listAll(user, pageIndex, pageSize);
    mv.addObject("dataPage", dataPage);
    mv.addObject("user", "xiaog");
    return mv;
  }

  @RequestMapping(value = "/user/add", method = RequestMethod.POST)
  public ModelAndView add(@RequestParam String userName, @RequestParam int age) {

    ModelAndView mv = new ModelAndView("user2");

    User user = new User();
    user.setAge(age);
    user.setUserName(userName);
    this.userService.addUser(user);

    return mv;
  }

  @RequestMapping(value = "/user2", method = RequestMethod.GET)
  public ModelAndView user2(@RequestParam int pageIndex, @RequestParam int pageSize) {
    ModelAndView mv = new ModelAndView("user2");
    return mv;
  }

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

}
