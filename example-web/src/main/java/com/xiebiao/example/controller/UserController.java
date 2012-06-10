package com.xiebiao.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xiebiao.common.util.DataPage;
import com.xiebiao.example.domain.User;
import com.xiebiao.example.service.UserService;

/**
 * 
 * @author xiaog
 * 
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(this
			.getClass());

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView user() {
		int pageIndex = 1;
		int pageSize = 1;
		ModelAndView mv = new ModelAndView("user");
		User user = new User();
		DataPage<User> dataPage = userService
				.listAll(user, pageIndex, pageSize);
		mv.addObject("dataPage", dataPage);
		mv.addObject("user", "xiaog");
		return mv;
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("user_add");
		return mv;
	}

	@RequestMapping(value = "/user/add/action", method = RequestMethod.POST)
	public ModelAndView userAddAction() {
		ModelAndView mv = new ModelAndView("user2");
		User user = new User();
		this.userService.addUser(user);
		return mv;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
