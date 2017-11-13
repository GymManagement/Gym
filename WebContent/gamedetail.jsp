<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>比赛详细信息</title>
</head>
<body>
<h1>比赛详细信息</h1>
<br>
比赛日期：<s:property value="data"/>
<br><br>
比赛地点：<s:property value="location"/>
<br><br>
比赛内容：<s:property value="introduce"/>
<br><br>
报名链接：<s:property value="link"/>
<br><br>
<form action="backwelcome.action">
<input type=submit value="返回"/>
</form>
</body>
</html>