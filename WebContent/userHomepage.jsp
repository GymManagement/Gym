<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户首页</title>
</head>
<body>
<h1>我要去健身</h1>
你好，
<a href="changeInfo?xxx=<s:property value="xxx"/>"><s:property value="xxx"/></a>
<br>

<form action="searchGym.action">
<h3>场馆查询</h3>
我们提供多个场馆信息查询，你想查看什么体育馆呢
<br><br>
请输入：
<input type="text" name="nameOfGym">
<input type=submit value="查看"/>
</form>
<br>
<h3>健身计划</h3>
<a href="myplan?username=<s:property value="xxx"/>">我的健身计划</a>
<br>
<br>
<h3>体育馆推荐</h3>
如果需要查看体育馆推荐，点击
<a href="rankingGym">这里</a>
<br><br>

<form action="backLogin.action">
<input type=submit value="返回登录界面"/>
</form>
<br>

</body>
</html>