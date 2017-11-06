<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作者作品目录</title>
</head>
<body>
<center>
<h3>作者作品查询</h3> 
<br>
<blink>
<font size=4 color="blue">
<s:form action="delete.action">
你查询的该作者所著的书籍为以下(若想了解详细信息，请点击书名，若想删除，请点击删除按钮)
<br>
<s:iterator value="booklist" var='i'>

<a href="show?isbn=<s:property value="isbn"/>"><s:property value="booktitle"/></a>
<br>

<a href="delete?isbn=<s:property value="isbn"/>">   删除</a>

	<br>
</s:iterator>
</s:form>
</font>
</blink>
 </center>

</body>
</html>