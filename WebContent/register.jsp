<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>注册界面</h3>
	<hr>
	<center>
		<form action="doRegister" method="post">
			    <input type="text" name="user.userName" placeholder="请输入注册名"
				required="required" maxlength="10"><br /> 
				<input
				type="password" name="user.password" placeholder="请输入注册密码"
				required="required" maxlength="12"><br /> 
				<input
				type="password" name="user.repassword" placeholder="请再次输入注册密码"
				required="required" maxlength="12"><br /> 
				<input
				type="submit" value="注册"> 
				<input
				 type="reset" value="重置">
		</form>
	</center>
</body>
</html>