<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推荐体育馆及评分</title>
</head>
<body>
<h1>所有体育馆及评分</h1>
<s:iterator value="gymlist" var='i'>
    <a href="searchGym?nameOfGym=<s:property value="name"/>"><s:property value="name"/></a>
    <s:property value="num"/>人评价
    <s:property value="score"/>分
  <br>
</s:iterator>
<br>
<form action="backHomepage.action">
<input type=submit value="返回首页"/>
<br>
</form>


</body>
</html>