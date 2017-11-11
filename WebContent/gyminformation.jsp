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
<label for=name>体育馆名：</label>
<input type="text" name="name" /> <input type="submit" value="确认" />
<br><br>
<label for=address>详细地址：</label>
<input type="text" name="address" /> <input type="submit" value="确认" />
<br><br>
<label for=price>价格范围：</label>
<input type="text" name="price" /> <input type="submit" value="确认" />
<br><br>
<label for=kind>器材种类：</label>
<input type="text" name="kind" /> <input type="submit" value="确认" />
<br><br>
<label for=time>开放时间：</label>
<input type="text" name="time" /> 
<form action="liujiaxi.action">
<input type="submit" value="确认" />
</form>
</body>
</html>