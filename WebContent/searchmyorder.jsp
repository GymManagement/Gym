<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

您当前的预定为：
<table>
<tr>
  <td>日期</td>
  <td>时间段</td>
  <td>体育馆</td>
  <td>设施名称</td>
  <td></td>
</tr>
<s:iterator value="orderlist" var='i'>
<tr>
<td><s:property value="date"/></td>
<td> <s:property value="timeregion"/></td>
<td><s:property value="gym"/></td>
<td><s:property value="facname"/></td>
<td><a href="deletemyorder?getindex=<s:property value="index"/>">删除</a></td>
</tr>
</s:iterator>
</table>

<form action="backHomepage.action">
<input type=submit value="返回首页"/>
<br>
</form>

</body>
</html>