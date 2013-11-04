package com.yulong.news.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

public class BaseController {
	public static final String SUCC_MSG = "SUCC_MSG";
	public static final String FAIL_MSG = "FAIL_MSG";
	public void getMsg(ModelMap model, HttpServletRequest request){
		if(request.getSession().getAttribute(SUCC_MSG) != null){
			model.addAttribute(SUCC_MSG, request.getSession().getAttribute(SUCC_MSG));
			request.getSession().removeAttribute(SUCC_MSG);
		}
		if(request.getSession().getAttribute(FAIL_MSG) != null){
			model.addAttribute(FAIL_MSG, request.getSession().getAttribute(FAIL_MSG));
			request.getSession().removeAttribute(FAIL_MSG);
		}
	}
	public void setSuccessMsg(HttpServletRequest request, String msg){
		request.getSession().setAttribute(SUCC_MSG, msg);
	}
	public void setFailedMsg(HttpServletRequest request, String msg){
		request.getSession().setAttribute(FAIL_MSG, msg);
	}
}
