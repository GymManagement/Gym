<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>重大比赛</title>
</head>
<body>
<center><h1>体育馆重大比赛更新</h1></center>
<s:property value="nameOfGym"/>
体育馆
<br><br>
修改信息
<br>
<form action="gymchangegame.action">
<input name="index" type="hidden" value=<s:property value="index"/>>
名称：<s:property value="name"/><br>
<input type="text" name="newname" />
<br>
日期：<s:property value="data"/><br>
<input type="text" name="newdata" />
<br>
地点：<s:property value="location"/><br>
<input type="text" name="newlocation" />
<br>
介绍：<s:property value="introduce"/><br>
<textarea name="newintroduce" cols="30" rows="3"></textarea>
<input type="submit" value="提交" />
</form>
<br>

报名人员：

<s:iterator value="signup" var='i'>
<s:property value="i"/>
<br>
</s:iterator>

<form action="backcheckgame.action">
<input type="submit" value="返回">
</form>
</body>
</html>