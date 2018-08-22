package com.four.blog.service;

import java.util.List;

import com.four.blog.po.Comment;

public interface ICommentService {

	List<Comment> findAll(Comment comment);
}
