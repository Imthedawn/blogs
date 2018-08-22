package com.four.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.four.blog.dao.IManageArticleDAO;
import com.four.blog.po.Article;

@Repository
public class ManageArticleDaoImpl implements IManageArticleDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Serializable save(Article article) {
		return sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public List<Article> selectById(Integer userId) {
		String hql = "from Article a where author_id=:id";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", userId).list();
	}

	@Override
	public void deleteById(Integer articleId) {
		Article article = new Article();
		article.setArticleId(articleId);
		sessionFactory.getCurrentSession().delete(article);
	}

	@Override
	public void modify(Article article) {
		sessionFactory.getCurrentSession().update(article);
	}

	@Override
	public List<Article> queryById(Integer articleId) {
		String hql = "from Article where article_id=:id";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", articleId).list();
	}
	

}
