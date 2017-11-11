<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>基本信息更新</title>
</head>
<body>
<center><h1>体育馆基本信息更新</h1></center>
<style>
    body {
        word-spacing: 150px;
    }
</style>
<input type="button" onclick="window.location='gyminformation.jsp'" value="体育馆基本信息">
<input type="button" onclick="window.location='gymsheshi.jsp'" value="体育馆设施情况">
<input type="button" onclick="window.location='gymbiggame.jsp'" value="重大比赛">
<br><br>
<form action="gyminfo.action">
体育馆名：
<input type="text" name="name" /> 
<br><br>
详细地址：
<input type="text" name="address" />
<br><br>
价格范围：
<input type="text" name="price" /> 
<br><br>
器材种类：
<input type="text" name="kind" />
<br><br>
标签：
<input type="text" name="tag" />
<br><br>
联系电话：
<input type="text" name="tele" />
<br><br>
开放时间：
<input type="text" name="time" /> <input type="submit" value="确认" />
</form>
</body>
</html>