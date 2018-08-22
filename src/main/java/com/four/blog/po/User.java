package com.four.blog.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_user")
public class User {

	private Integer userId;
	private String userName;
	private String password;
	private transient String repassword;
	private List<Article> article;

	@Id @Column(name="user_id", updatable=true)
	@GeneratedValue(generator="user_id", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="user_id", sequenceName="seq_user_id", allocationSize = 1)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@OneToMany(mappedBy="author")
	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public User(Integer userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public User() {}
	
	
//
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", article=" + article
//				+ "]";
//	}

}