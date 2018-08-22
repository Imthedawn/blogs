package com.four.blog.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.four.blog.dao.ICommentDAO;
import com.four.blog.po.Comment;
import com.four.blog.service.ICommentService;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

	@Autowired ICommentDAO commentDao;
	
	@Override
	public List<Comment> findAll(Comment comment) {
		
		return commentDao.findAll(comment);
	}

}
