<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体育馆信息</title>
</head>
<body>
<h1>体育馆信息</h1>
<s:property value="nameOfGym"/>
体育馆
<br><br>
位置：<s:property value="position"/>
<br><br>
价格：<s:property value="price"/>
<br><br>
时间：<s:property value="time"/>
<br><br>
标签：<s:property value="tag"/>
<br><br>
分数：<s:property value="score"/>
<br><br>
联系电话：<s:property value="tele"/>
<br><br>
当前设施信息:
<br><br>
名称（时间）   &nbsp; &nbsp;数量&nbsp;&nbsp; 时间段1 &nbsp;&nbsp;时间段2 &nbsp;&nbsp;时间段3
<br><br>
<s:iterator value="faclist" var='i'>
    <s:property value="name"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <s:property value="num"/>&nbsp;&nbsp;&nbsp;&nbsp;
<s:property value="time1"/>&nbsp;&nbsp;&nbsp;&nbsp;
<s:property value="time2"/>&nbsp;&nbsp;&nbsp;&nbsp;
<s:property value="time3"/>
  <br>
</s:iterator>
<br><br>

<br><br>
<form action="backstuff.action">
<input type=submit value="返回首页"/>
<br>
</form>

</body>
</html>