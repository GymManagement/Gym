<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>内容更新</title>
</head>
<body>
<center><h1><s:property value="name"/>体育馆内容更新</h1></center>
<style>
    body {
        word-spacing: 150px;
    }
</style>
<input type="button" onclick="window.location='gyminformation.jsp'" value="体育馆基本信息">
<input type="button" onclick="window.location='gymsheshi.jsp'" value="体育馆设施情况">
<input type="button" onclick="window.location='gymbiggame.jsp'" value="重大比赛">
<br><br><br>
<form action="checkfac.action">
<input type=submit value="查看当前设施使用情况"/>
<br><br>
</form>
<center><input type="button" onclick="window.location='welcome.jsp'" value="返回登陆界面"></center>
</body>
</html>