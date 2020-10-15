package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.userService;

@Controller
public class UserController {
	@Autowired
	userService service;
	
	@RequestMapping("show")
	public String show(HttpServletRequest req,HttpServletResponse rep){
		List<User> list = service.select();
		req.setAttribute("list",list);
		return "show";
	}
	
	@RequestMapping("add")
	public String add(User user,HttpServletRequest req,HttpServletResponse rep){
		service.add(user);
		return "forward:show";
	}
	@RequestMapping("delete")
	public String delete(int id,HttpServletRequest req,HttpServletResponse rep){
		service.delete(id);
		return "forward:show";
	}	
	@RequestMapping("Byid")
	public String selectByid(int id,HttpServletRequest req,HttpServletResponse rep){
		User user = service.selectById(id);
		req.setAttribute("user", user);
		return "update";
		
	}
	
	@RequestMapping("update")
	public String update(User user,HttpServletRequest req,HttpServletResponse rep){
		service.update(user);
		return "forward:show";
		
	}
}
