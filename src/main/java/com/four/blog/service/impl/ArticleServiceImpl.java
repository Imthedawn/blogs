package com.four.blog.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.four.blog.dao.IArticleDAO;
import com.four.blog.po.Article;
import com.four.blog.service.IArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Autowired IArticleDAO articleDao;
	
	@Override
	public List<Article> select(String page) {
		List<Article> list = articleDao.findAll(page);
		return list;
	}

	@Override
	public List<Article> selectByType(String articleType) {
		List<Article> list = articleDao.findByType(articleType);
		return null;
	}

}
