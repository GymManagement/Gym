<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>重大比赛</title>
</head>
<body>
<center><h1>体育馆重大比赛更新</h1></center>
<style>
    body {
        word-spacing: 150px;
    }
</style>
<input type="button" onclick="window.location='gyminformation.jsp'" value="体育馆基本信息">
<input type="button" onclick="window.location='gymsheshi.jsp'" value="体育馆设施情况">
<input type="button" onclick="window.location='gymbiggame.jsp'" value="重大比赛">
<br><br>
<form action="biggame.action">
日期：
<input type="text" name="data" />
<br><br>
地点：
<input type="text" name="location" />
<br><br>
介绍：
<textarea name="introduce" cols="30" rows="3"></textarea>
<br><br>
报名链接
<input type="text" name="link" />
<br><br>
<input type="submit" value="提交" />
</form>
</body>
</html>