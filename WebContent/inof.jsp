<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
</head>
<body>
<form action=error.action>
<center>
<h3>书籍信息：</h3>
<font size=3 color="green">
<br>

</font>



<table border="1">
 <tr>

    <th>书籍名称</th>

    <th>ISBN</th>
    
    <th>作者i d</th>
    
    <th>出版社</th>
    
    <th>出版日期</th>
    
    <th>价格</th>
     

  </tr>

  <tr>

    <td><s:property value="thetitle.title" /></td>

    <td><s:property value="thetitle.ISBN" /></td>
    
    <td><s:property value="thetitle.authorID" /></td>
    
    <td><s:property value="thetitle.publisher" /></td>
    
    <td><s:property value="thetitle.publishdate" /></td>
    
    <td><s:property value="thetitle.price" /></td>

  </tr>

</table>

<br>
<br>
</center>
<center>
<h3>作者信息：</h3>
<font size=3 color="blue">

<br>
</font>

<table border="1">
 <tr>

    <th>作者姓名</th>

    <th>作者i d</th>
    
    <th>作者国籍</th>
    
    <th>作者年龄</th>
    
     

  </tr>

  <tr>
	
           
    <td><s:property value="theauthor.name" /></td>

    <td><s:property value="theauthor.authorid" /></td>
    
    <td><s:property value="theauthor.country" /></td>
    
    <td><s:property value="theauthor.age" /></td>
   
  </tr>

</table>

<br>
<br>
<input type=submit value="返回"/>
</center>

</form>
</body>
</html>