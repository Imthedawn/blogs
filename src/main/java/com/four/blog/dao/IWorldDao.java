package com.four.blog.dao;

import java.util.List;

import com.four.blog.po.Article;

public interface IWorldDao {
	
	Object getArticleCount(Integer userId);
	
	Object getCommentCount(Integer userId);
	
	Object getDocumentCount(Integer userId);
	
	String getLatestArticle(Integer userId);
	
	Object getLatestComment(Integer userId);

}
