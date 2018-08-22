package com.four.blog.dao;

import java.util.List;

import com.four.blog.po.Comment;

public interface ICommentDAO {

	List<Comment> findAll(Comment comment);
}
