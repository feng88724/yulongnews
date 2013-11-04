package com.yulong.news.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController extends BaseController{
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpServletRequest request) {
        return "auth/login";
    }
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, @RequestParam(value = "error", required = false) String error, HttpServletRequest request) {
		model.addAttribute("error", error);
		return "auth/login";
	}
}
