package com.four.blog.po;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_article",schema="scott")//name为表名，schema为要连接的数据库
public class Article {


	private Integer articleId;
	
	private String articleTitle;
	
	private String articleType;
	
	private String articleContent;
	
	private Date articleTime;
	
	private User author;
	
	private List<Comment> comment;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="author_id")
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Id   
	@Column(name="article_id")
	@GeneratedValue(generator="article_id",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name ="article_id",sequenceName="seq_article_id")
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
//	@Column(length=30, nullable=false, updatable=true)
	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

//	@Temporal(TemporalType.TIME)
	@Column(name="createTime")
	public Date getArticleTime() {
		return articleTime;
	}

	public void setArticleTime(Date articleTime) {
		this.articleTime = articleTime;
	}

	@OneToMany(mappedBy="article")
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Article(Integer articleId, String articleTitle, String articleType, String articleContent, Date articleTime,
			User author, List<Comment> comment) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleType = articleType;
		this.articleContent = articleContent;
		this.articleTime = articleTime;
		this.author = author;
		this.comment = comment;
	}

	public Article() {
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleType=" + articleType
				+ ", articleContent=" + articleContent + ", articleTime=" + articleTime + ", author=" + author
				+ ", comment=" + comment + "]";
	}
	
	
}
