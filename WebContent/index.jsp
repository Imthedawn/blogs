<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#list {
	width: 960px;
	height: 320px;
	background: #eee;
	border-radius: 2px;
	margin: 30px auto;
	padding: 20px;
	box-shadow: -1px 1px 5px #999;
}

.title {
	width: 960px;
	height: 40px;
	line-height: 40px;
	cursor: pointer
}

.title h2 {
	font-size: 24px;
	color: #000;
	font-weight: 300;
	float: left;
}

.title .look {
	float: right;
	font-size: 14px;
	color: #669999;
	margin-right: 20px;
	text-decoration: none;
}

#picture {
	width: 960px;
	height: 650px;
	margin-top: 30px;
	border-top: 2px solid #eee;
	padding: 20px;
}

#picture .con {
	width: 960px;
	height: 550px;
	border-top: 4px solid #ccc;
}

#picture .con ul li {
	width: 420px;
	height: 230px;
	border-radius: 3%;
	float: left;
	border: 1px solid #eee;
	margin: 25px;
	position: relative;
}

#picture .con ul li p {
	width: 420px;
	height: 20px;
	text-align: center;
	font-size: 12px;
	color: #333;
}

#picture .con ul li img {
	width: 360px;
	height: 150px;
	box-shadow: 0px 0px 8px #000;
	border: 5px solid #eee;
	margin: 20px;
}

#picture .con ul li span {
	width: 360px;
	height: 150px;
	position: absolute;
	display: block;
	top: 24px;
	left: 24px;
	background: rgba(255, 255, 255, 0);
	transition: all 0.4s;
}

#picture .con ul li:hover span {
	background: rgba(255, 255, 255, 0.4);
}
;
</style>
<body>
	<h3>游客界面</h3>
	<hr>
	<center>
		<div id="picture">
			<div class="title">
				<h2>博客集<%=session.getAttribute("msg") %></h2>
				
				<a class="look" href="#" target="_blank">查看更多>></a>
			</div>
			<hr>
			<c:forEach items="${sessionScope.init_list_session}" var="article">
				<div class="con">
					<a href="#">
						<li><img src="images/list1.jpg" />
							<p>${article.articleTitle}</p>
							<p>#${article.articleType}</p></li>
					</a>
				</div>
			</c:forEach>
		</div>
	</center>
</body>
</html>