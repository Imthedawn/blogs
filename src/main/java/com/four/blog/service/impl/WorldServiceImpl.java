package com.four.blog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.four.blog.dao.IWorldDao;
import com.four.blog.service.IWorldService;

@Service
@Transactional
public class WorldServiceImpl implements IWorldService{
	
	@Autowired 
	IWorldDao worldDao;
	
	@Override
	@Transactional(readOnly=true)
	public Object getArticleCount(Integer userId) {
		return worldDao.getArticleCount(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public Object getCommentCount(Integer userId) {
		return worldDao.getCommentCount(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public Object getDocumentCount(Integer userId) {
		return worldDao.getDocumentCount(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public String getLatestArticle(Integer userId) {
		return worldDao.getLatestArticle(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public Object getLatestComment(Integer userId) {
		return worldDao.getLatestArticle(userId);
	}
	

}
