<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>博客主界面</h3>
<hr>

<h2>欢迎${sessionScope.user_in_session.userName}</h2>
<form action="worldCount?id=${sessionScope.user_in_session.userId }" method="post">
	<input type="submit" value="我的世界" >
	
</form>

<a href="addArticle.jsp?user=${sessionScope.user_in_session }">添加文章</a>
<a href="manageArticle?userId=${sessionScope.user_in_session.userId }">管理文章</a>
</body>
</html>