package com.four.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.four.blog.po.Article;
import com.four.blog.service.IArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class ArticleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Article article;
	/*
	  ��һ����ҳ�棬ֱ�ӽ��в������µĲ�ѯ
	*/
	@Autowired IArticleService articleService;
	
	@Override
	@Action(value="init",results= {
			@Result(name="success",location="index.jsp",type="redirect"),
			@Result(name="input",location="404.jsp",type="redirect")
	})
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		String page = req.getParameter("page");
        List<Article> list = articleService.select(page);
        if(null == list){
        	System.out.println(list.size()+"����");
        	return INPUT;
        }else {
        	ActionContext.getContext().getSession().put("init_list_session", list);
        }
		return SUCCESS;
	}
	
	/*
	  ���Խ�������ѯ��������
	*/
	@Action(value="findByType",results= {
			@Result(name="success",location="index.jsp",type="redirect"),
			@Result(name="input",location="index.jsp")
	})
	public String showBlogByTitle() {
        List<Article> list = articleService.selectByType(article.getArticleType());
		if(list == null) {
			System.out.println(list.size()+"����");
			ActionContext.getContext().getSession().put("msg", "û���������");
		}else {
			ActionContext.getContext().getSession().put("init_list_session", list);
		}
		return SUCCESS;
	}
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

}
