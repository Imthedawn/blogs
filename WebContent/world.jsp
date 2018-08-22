<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>

<h2>博客数量：${sessionScope.articleCount }</h2><!-- 待 --> 
<h2>评论数量：${sessionScope.commentCount }</h2><!--未  -->
<h2>文件数量：<%-- ${sessionScope.docCount } --%></h2><!-- 待 --> 
<h2>最新文章：${sessionScope.latestArticle}</h2><!-- 待 --> 
<h2>最新留言：<%-- ${sessionScope.articleCount } --%></h2><!--未  -->
</body>
</html>