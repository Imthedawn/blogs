package com.four.blog.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.four.blog.dao.IManageArticleDAO;
import com.four.blog.po.Article;
import com.four.blog.service.IManageArticleService;

@Service
@Transactional
public class ManageArticleServiceImpl implements IManageArticleService{

	@Autowired
	IManageArticleDAO manageArticleDao;
	
	@Override
	public boolean save(Article article) {
		Serializable serializable = manageArticleDao.save(article);
		return (serializable == null) ? false : true;
	}

	@Override
	public List<Article> selectById(Integer userId) {
		List<Article> list = manageArticleDao.selectById(userId);
		return list;
	}

	@Override
	public void deleteById(Integer articleId) {
		manageArticleDao.deleteById(articleId);
	}

	@Override
	public void modify(Article article) {
		manageArticleDao.modify(article);
	}

	@Override
	public List<Article> queryById(Integer articleId) {
		return manageArticleDao.queryById(articleId);
	}

}
