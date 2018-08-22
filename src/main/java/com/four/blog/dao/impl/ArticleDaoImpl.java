package com.four.blog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.four.blog.dao.IArticleDAO;
import com.four.blog.po.Article;

@Repository
public class ArticleDaoImpl implements IArticleDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	@Override
	public List<Article> findAll(String page) {
		String hql = "from Article order by article_id asc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findByType(String articleType) {
		String hql = "from Article where articleType =:type order by article_id asc";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameter("type", articleType).list();
	}
}
