package com.four.blog.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.four.blog.dao.ICommentDAO;
import com.four.blog.po.Comment;

@Repository
public class CommentDaoImple implements ICommentDAO {

	@Autowired SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll(Comment comment) {
		String hql = "from Comment where comment_id=:id order by comment_id asc";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", comment.getCommentId()).list();
	}

}
