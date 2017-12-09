<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>基本信息更新</title>
</head>
<body>
<center><h1>体育馆基本信息更新</h1></center>
<center>
<style>
    body {
        word-spacing: 180px;
    }
</style>
<s:property value="nowname"/>
体育馆
<br>



<form action="gyminfo.action">

详细地址：<s:property value="nowposition"/>
<input type="text" name="newposition" />
<br><br>

价格范围：<s:property value="nowprice"/>
<input type="text" name="newprice" /> 
<br><br>

联系电话：<s:property value="nowtele"/>
<input type="text" name="newtele" />
<br><br>

开放时间：<s:property value="nowtime"/>
<input type="text" name="newtime" /> 
<br><br>

评价人数：<s:property value="nowscorenum"/>
<br>

评分：<s:property value="nowscore"/>
<br>
<input type="submit" value="确认" />
</form>
<br>
<form action="backstuffhome.action">
<input type="submit" value="返回主页面">
</form>
</center>
</body>
</html>