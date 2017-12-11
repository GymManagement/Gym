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

<s:property value="name"/>
体育馆
<br>
位置：<s:property value="position"/>
<br>
价格：<s:property value="price"/>
<br>
时间：<s:property value="time"/>
<br>
分数：<s:property value="score"/>(10分满分)
<br>
联系电话：<s:property value="tele"/>
<br>
设施种类：
<br>
<s:iterator value="faclist" var='i'>
    <s:property value="fac"/>:
    <s:property value="introduction"/>
  <br>
</s:iterator>
<br><br>


<form action="order.action">
预定服务：
<input name="gymname" type="hidden" value=<s:property value="name"/>>
<input type=submit value="我要预订"/>
<br>
</form>
<br><br>


<form action="score.action">
<input name="gym" type="hidden" value=<s:property value="name"/>>
评分:(10分满分)
<s:select headerKey="-1" headerValue="请选择" name="userscore" list="#{'0':'0','1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10'}"/>
<br>
评论：
<input type=text name="usercomment"/>
<br>
<input type=submit value="提交"/>
<br>
</form>
<br><br>

<form action="searchusergame.action">
查看比赛信息
<input name="gymgetname" type="hidden" value=<s:property value="name"/>>
<s:select headerKey="-1" headerValue="请选择" name="index" list="gamelist"  listKey="index" listValue="name"/>
<input type=submit value="确定"/>
</form>


<form action="backHomepage.action">
<input type=submit value="返回首页"/>
<br>
</form>

</body>
</html>