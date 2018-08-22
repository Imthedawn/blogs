package com.four.blog.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.four.blog.po.User;
import com.four.blog.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/*
	   用户进行注册操作
	*/
	@Autowired IUserService userService;
	private User user;
	
	@Action(value="doRegister",results={
			@Result(name="success",location="login.jsp",type="redirect"),
			@Result(name="input",location="register.jsp")
	})
	public String doRegister() {
        boolean flag = userService.addUser(user);
        System.out.println("标志为："+flag);
        return flag ? SUCCESS : INPUT;
	}
	
	/*
	   用户进行登录操作
	*/
	@Action(value="doLogin",results= {
			@Result(name="success", location="menu.jsp", type="redirect"),
			@Result(name="input",location="login.jsp")
	})
	public String doLogin() {
		// TODO Auto-generated method stub
        User u = userService.select(user);
		if(u == null) {
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("user_in_session", u);
		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
