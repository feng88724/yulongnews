package com.yulong.news.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import com.yulong.news.bean.User;
import com.yulong.news.bean.UserForm;
import com.yulong.news.dao.UserDAO;
import com.yulong.news.validate.UserValidator;
 
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/showAdd", method = RequestMethod.GET)
	public String showAdd(ModelMap model) {
		model.addAttribute("user", new User());
		return "admin/user/add";
	}
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ModelMap model, @ModelAttribute("user") User user, BindingResult result, HttpServletRequest request){
		UserValidator userValidator = new UserValidator();
        userValidator.validate(user, result);
        if(result.hasErrors()){
        	model.addAttribute("user", user);
        	return "admin/user/add";
        }else{
        	int createFlag = this.userDAO.insertUser(user);
        	if(createFlag > 0){
        		this.setSuccessMsg(request, "用户创建成功！");
				return "redirect:getList";
        	}else{
        		model.addAttribute(FAIL_MSG, "用户创建失败！");
        		return "user/add";
        	}
        	 
        }
	}
	@RequestMapping(value="/getList", method = RequestMethod.GET)
	public String getList(ModelMap model,  HttpServletRequest request){
		List<User> users = this.userDAO.listUsersByUsername();
		model.addAttribute("users", users);
		this.getMsg(model, request);
		return "admin/user/list"; 
	}
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public String list(ModelMap model, @ModelAttribute("user") User user, HttpServletRequest request){
		List<User> users = this.userDAO.listUsersByUsername();
		model.addAttribute("users", users);
		this.getMsg(model, request);
		return "admin/user/list"; 
	}
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("userForm") UserForm userForm){
		User user = this.userDAO.getUserById(Integer.valueOf(userForm.getId()));
		model.addAttribute("user", user);
		return "admin/user/edit";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("user") User user, BindingResult result,  HttpServletRequest request){
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result);
		if(result.hasErrors()){
			model.addAttribute("user", user);
			return "admin/user/edit";
		}else{
			int saveFlag = this.userDAO.updateUser(user);
			if(saveFlag > 0){
				this.setSuccessMsg(request, "更新成功！");
				return "redirect:getList";
			}else{
				model.addAttribute(FAIL_MSG, "更新失败！");
				model.addAttribute("user", user);
				return "admin/user/edit";
			}
		}
	}
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(ModelMap model, @ModelAttribute("user") User user, HttpServletRequest request){
		int deleteFlag = this.userDAO.deleteUser(user.getId());
		if(deleteFlag > 0){
			this.setSuccessMsg(request, "删除成功！");
			return "redirect:getList";
		}else{
			model.addAttribute(FAIL_MSG, "删除失败！");
			model.addAttribute("user", user);
			return "admin/user/edit";
		}
	}
}
