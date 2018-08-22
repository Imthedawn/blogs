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

import com.four.blog.po.Comment;
import com.four.blog.service.ICommentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class CommentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Autowired ICommentService commentService;
	private Comment comment;
	
	@Action(value="addComment",results= {
			@Result(name="success",location="#",type="redirect"),
			@Result(name="input",location="#",type="redirect")
	})
	public String AddComment() {
		List<Comment> list = commentService.findAll(comment);
		if( list != null ) {
			System.out.println(list.size()+"长度");
			ActionContext.getContext().getSession().put("msg", "暂时还没有评论哦！亲！！！");
		}else {
			ActionContext.getContext().getSession().put("init_commentlist_session", list);
		}
		return SUCCESS;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
