package com.four.blog.service;

import java.util.List;

import com.four.blog.po.Article;

public interface IArticleService {

	List<Article> select(String page);

	List<Article> selectByType(String articleService);
}
