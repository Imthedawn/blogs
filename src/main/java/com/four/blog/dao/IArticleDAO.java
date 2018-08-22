package com.four.blog.dao;

import java.util.List;

import com.four.blog.po.Article;

public interface IArticleDAO {

	List<Article> findAll(String pqge);

	List<Article> findByType(String articleType);
}
