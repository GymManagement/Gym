<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>设施情况更新</title>
</head>
<body>
<center><h1>体育馆设施情况更新</h1></center>
<center>
<style>
    body {
        word-spacing: 180px;
    }
</style>
<input type="button" onclick="window.location='gyminformation.jsp'" value="体育馆基本信息">
<input type="button" onclick="window.location='gymsheshi.jsp'" value="体育馆设施情况">
<input type="button" onclick="window.location='gymbiggame.jsp'" value="重大比赛信息">
<br><br>
</center>



<form action="facinum.action">
设施名称:<input type=text name="name"/>
<br>
数量：<input type=text name="num"/>
<br>
<input type=submit value="提交"/>
<br><br>
</form>
<input type="button" onclick="window.location='index.jsp'" value="返回主页面">
</body>
</html>