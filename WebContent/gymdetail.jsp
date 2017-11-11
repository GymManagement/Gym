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

<s:property value="nameOfGym"/>
体育馆
<br>
位置：<s:property value="position"/>
<br>
价格：<s:property value="price"/>
<br>
时间：<s:property value="time"/>
<br>
标签：<s:property value="tag"/>
<br>
分数：<s:property value="score"/>
<br>
联系电话：<s:property value="tele"/>
<br>
当前设施信息:
<br>
名称（时间）   &nbsp; &nbsp;数量&nbsp;&nbsp; 时间段1 &nbsp;&nbsp;时间段2 &nbsp;&nbsp;时间段3
<br>
<s:iterator value="faclist" var='i'>
    <s:property value="name"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <s:property value="num"/>&nbsp;&nbsp;&nbsp;&nbsp;
<s:property value="time1"/>&nbsp;&nbsp;&nbsp;&nbsp;
<s:property value="time2"/>&nbsp;&nbsp;&nbsp;&nbsp;
<s:property value="time3"/>
  <br>
</s:iterator>
<br><br>


<form action="order.action">
预定服务：
<input name="gym" type="hidden" value=<s:property value="nameOfGym"/>>
时间段:
<input type=text name="timeorder"/>
<br>
名称：
<input type=text name="name"/>
<br>
<input type=submit value="提交"/>
<br>
</form>
<br><br>
<form action="score.action">
<input name="gym" type="hidden" value=<s:property value="nameOfGym"/>>
评分:
<input type=text name="userscore"/>
<br>
评论：
<input type=text name="usercomment"/>
<br>
<input type=submit value="提交"/>
<br>
</form>
<br><br>
<form action="backHomepage.action">
<input type=submit value="返回首页"/>
<br>
</form>

</body>
</html>