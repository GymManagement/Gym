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
添加比赛：
<br>
<form action="biggame.action">
名称：
<input type="text" name="newname" />
<br><br>
日期：
<input type="text" name="newdata" />
<br><br>
地点：
<input type="text" name="newlocation" />
<br><br>
介绍：
<textarea name="newintroduce" cols="30" rows="3"></textarea>
<br><br>
<input type="submit" value="提交" />
</form>
<br>

查询或修改比赛信息
<form action="checkgamedetail.action">
<s:select headerKey="-1" headerValue="请选择" name="index" list="gamelist"  listKey="index" listValue="name"/> 
<input type=submit value="确定"/>
</form>


<form action="backstuffhome.action">
<input type="submit" value="返回">
</form>
</body>
</html>