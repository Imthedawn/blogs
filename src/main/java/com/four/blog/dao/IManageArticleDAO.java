package com.four.blog.dao;

import java.io.Serializable;
import java.util.List;

import com.four.blog.po.Article;

public interface IManageArticleDAO {

	Serializable save(Article article);

	List<Article> selectById(Integer userId);

	void deleteById(Integer articleId);

	void modify(Article article);

	List<Article> queryById(Integer articleId);
}
