package com.four.blog.action;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.four.blog.po.User;
import com.four.blog.service.IWorldService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class WorldAction extends ActionSupport {
	
	@Autowired 
	IWorldService worldService;
	
	private User user_in_session;
	
	//统计文章数量
	@Action(value="worldCount",results={
		@Result(name="input",location="error.jsp",type="redirect"),
		@Result(name="success",location="world.jsp")
	})
	public String countArticle(){
		HttpServletRequest req =ServletActionContext.getRequest();
		Integer userId =new Integer(req.getParameter("id"));
		Object articleCount = worldService.getArticleCount(userId);
		Object commentCount = worldService.getCommentCount(userId);
		Object latestArticle = worldService.getLatestArticle(userId);
		//Object docCount = worldService.getDocumentCount(userId);
		ActionContext.getContext().getSession().put("articleCount", articleCount);
		ActionContext.getContext().getSession().put("latestArticle", latestArticle);
		ActionContext.getContext().getSession().put("commentCount", commentCount);
		//ActionContext.getContext().getSession().put("docCount", docCount);
		
		return SUCCESS;
	}
	
	/*//统计评论数量
	@Action(value="commentCount",results= {
		@Result(name="input",location="error.jsp",type="redirect"),
		@Result(name="success",location="myWorld.jsp")
	})
	public String countComment(){
		Integer userId = user.getUserId();
		Integer count = worldService.getCommentCount(userId);
		if(null==count){
			return INPUT;
		}
		else{
			ActionContext.getContext().getSession().put("commentCount", count);
		}
		return SUCCESS;
	}
	
	//统计文件数量
	@Action(value="documentCount",results= {
			@Result(name="input",location="error.jsp",type="redirect"),
			@Result(name="success",location="myWorld.jsp")
		})
		public String countDocument(){
			Integer userId = user.getUserId();
			Integer count = worldService.getDocumentCount(userId);
			if(null==count){
				return INPUT;
			}
			else{
				ActionContext.getContext().getSession().put("documentCount", count);
			}
			return SUCCESS;
		}
	
	//获得最新文章标题
	@Action(value="latestArticle",results= {
			@Result(name="input",location="error.jsp",type="redirect"),
			@Result(name="success",location="myWorld.jsp")
		})
		public String getLatestArticle(){
			Integer userId = user.getUserId();
			String tittle = worldService.getLatestArticle(userId);
			if(null==tittle){
				return INPUT;
			}
			else{
				ActionContext.getContext().getSession().put("latestArticle", tittle);
			}
			return SUCCESS;
		}
	
	//获得最新评论（留言人，留言时间）
	@Action(value="latestComment",results= {
			@Result(name="input",location="error.jsp",type="redirect"),
			@Result(name="success",location="myWorld.jsp")
		})
		public String getLatestComment(){
			Integer userId = user.getUserId();
			String tittle = worldService.getLatestComment(userId);
			if(null==tittle){
				return INPUT;
			}
			else{
				ActionContext.getContext().getSession().put("latestArticle", tittle);
			}
			return SUCCESS;
		}
	*/
}
