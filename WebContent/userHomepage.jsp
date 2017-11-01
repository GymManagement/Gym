<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

你好，
<s:property value="xxx"/>
<br>

<form action="searchGym.action">
你想查看什么体育馆呢
<input type="text" name="nameOfGym">
<input type=submit value="查看"/>
</form>
<br>

<a href="myPlan?username=<s:property value="xxx"/>">我的健身计划</a>
<br>

如果需要推荐，点击
<a href="rankingGym">这里</a>
<br>

<form action="backLogin.action">
<input type=submit value="返回登录界面"/>
</form>
<br>

</body>
</html>