<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${sessionScope.selectById_list_session}"
		var="article">
		<div class="con">
			<a href="#">
				<p>${article.articleTitle} <a href="deleteArticle?articleId=${article.articleId }">删除</a><a href="queryArticleById?articleId=${article.articleId }">修改</a></p>
				<p>#${article.articleType}</p>
			</a>
		</div>
	</c:forEach>
</body>
</html>