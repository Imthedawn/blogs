package com.four.blog.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.four.blog.dao.IWorldDao;
import com.four.blog.po.Article;

@Repository
public class WorldDaoImpl implements IWorldDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Object getArticleCount(Integer userId) {
		System.out.println(userId);
		return sessionFactory.getCurrentSession().createQuery("select count(articleId) from Article where author_id=:id").setParameter("id", userId).uniqueResult();
		}

	@Override
	public Object getCommentCount(Integer userId) {
		//return sessionFactory.getCurrentSession().createQuery("select count(commentId) from Comment where article_id=:id").setParameter("id", userId).uniqueResult();
		return null;
	}

	@Override
	public Object getDocumentCount(Integer userId) {
		return sessionFactory.getCurrentSession().createQuery("select count(doc_id) from Document where author_id=:id").setParameter("id", userId).uniqueResult();
	}

	@Override
	public String getLatestArticle(Integer userId) {
		String hql = "select articleTitle from Article where author_id=:id and articleId=(select max(articleId) from Article)";
		return (String) sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", userId).uniqueResult();
	}

	@Override
	public Object getLatestComment(Integer userId) {
		return sessionFactory.getCurrentSession().createQuery("select count(articleId) from Article where author_id=:id").setParameter("id", userId).uniqueResult();
	}
}
