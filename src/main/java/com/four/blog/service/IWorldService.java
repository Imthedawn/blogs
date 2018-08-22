package com.four.blog.service;

public interface IWorldService {
	
	Object getArticleCount(Integer userId);
	
	Object getCommentCount(Integer userId);
	
	Object getDocumentCount(Integer userId);
	
	String getLatestArticle(Integer userId);
	
	Object getLatestComment(Integer userId);

}
