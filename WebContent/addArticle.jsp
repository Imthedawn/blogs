<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ?userName=${sessionScope.user_in_session.userName }
&userId=${sessionScope.user_in_session.userId }&password=${sessionScope.user_in_session.password } --%>
<form action="addArticle" method="post">
			    <input type="text" name="article.articleTitle" placeholder="请输入文章标题" required="required"><br /> 
				<input type="text" name="article.articleType" placeholder="请输入文章标签" required="required" maxlength="12"><br/> 
				<input type="text" name="article.articleContent" placeholder="请输入文章内容" required="required" minlength="5"><br/> 
				<input type="submit" value="发布"> 
				<input type="reset" value="重置">
</form>

</body>
</html>