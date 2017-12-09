<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>比赛信息</title>
</head>
<body>


举办方：<s:property value="nameOfGym"/>体育馆
<br>
名称：<s:property value="name"/><br>
<br>
日期：<s:property value="data"/><br>
<br>
地点：<s:property value="location"/><br>
<br>
介绍：<s:property value="introduce"/><br>
<br>

<form action="usersignupone.action">
<input name="indexget" type="hidden" value=<s:property value="index"/>>
<input type="submit" value="我要报名">
</form>

<form action="backgymdetail.action">
<input type="submit" value="返回">
</form>
</body>
</html>