<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写您的信息</title>
</head>
<body>
请填写您的基本信息
<br><br>
<form action="myplantest.action">
身高：<input type="text" name="changedheight">
体重：<input type="text" name="changedweight">


<br><br>


<input type=submit value="提交结果"/>
</form>
<br>

</body>
</html>