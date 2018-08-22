package com.four.blog.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;

import com.four.blog.po.Article;
import com.four.blog.po.User;
import com.four.blog.service.IManageArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ManageArticleAction extends ActionSupport{
	
	private Article article;
	private User user;

	@Autowired
	IManageArticleService manageArticleService;
	/**
	 * 添加文章
	 */
	@Override
	@Action(value="addArticle",results= {
			@Result(name="success",location="manageArticle",type="redirect"),
			@Result(name="input",location="addArticle.jsp",type="redirect"),
	})
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user_in_session");
		article.setArticleTime(new Date());
		
		article.setAuthor(u);
		boolean flag = manageArticleService.save(article);
		return flag ? SUCCESS : INPUT;
	}
	
	/**
	 * 管理文章，实现查询所有该作者的文章
	 * @return 返回一个文章List
	 */
	@Action(value="manageArticle", results= {
			@Result(name="success",location="manageArticle.jsp",type="redirect")
	})
	public String manageArticle() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user_in_session");
		List<Article> list = manageArticleService.selectById(u.getUserId());
		ActionContext.getContext().getSession().put("selectById_list_session", list);
		return SUCCESS;
	}
	
	/**
	 * 管理个人博文，实现根据文章ID删除功能
	 */
	@Action(value="deleteArticle", results= {
			@Result(name="success",location="manageArticle",type="redirect")
	})
	public String deleteArticle() {
		HttpServletRequest req = ServletActionContext.getRequest();
		Integer articleId = Integer.parseInt(req.getParameter("articleId"));
		manageArticleService.deleteById(articleId);
		return SUCCESS;
	}
	
	/**
	 * 根据文章ID对文章进行修改
	 * @return
	 */
	@Action(value="modifyArticle", results= {
			@Result(name="success",location="manageArticle",type="redirect")
	})
	public String modifyArticle() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user_in_session");
		
		article.setArticleId(Integer.parseInt(req.getParameter("articleId")));
		article.setArticleTime(new Date());
		article.setAuthor(u);
		System.out.println(article);
		manageArticleService.modify(article);
		return SUCCESS;
		
	}
	
	@Action(value="queryArticleById", results= {
			@Result(name="success",location="queryArticleById.jsp",type="redirect"),
			@Result(name="input",location="manageArticle",type="redirect")
	})
	public String queryArticleById() {
		HttpServletRequest req = ServletActionContext.getRequest();
		Integer articleId = Integer.parseInt(req.getParameter("articleId"));
		List<Article> list = manageArticleService.queryById(articleId);
		ActionContext.getContext().getSession().put("init_list_session", list);
		return SUCCESS;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
