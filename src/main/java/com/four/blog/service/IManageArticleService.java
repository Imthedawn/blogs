package com.four.blog.service;

import java.util.List;

import com.four.blog.po.Article;


public interface IManageArticleService {
	
	public boolean save(Article article);

	public List<Article> selectById(Integer userId);

	public void deleteById(Integer articleId);

	public List<Article> queryById(Integer articleId);

	public void modify(Article article);

}
