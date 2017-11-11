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

先点
<a href="test">这里</a>
做个小测试吧
<br>
你的测试结果是：
<br>
身高：
<s:property value="height"/>
<br>
体重：
<s:property value="weight"/>
<br>
体型：
<s:property value="testresult"/>
<br>
建议锻炼频率：
<s:property value="suggestfreq"/>
<br>
<br>
目标体重:<s:property value="aimweight"/>
<br>

<form action="myplanaim.action">
更改目标体重：<input type="text" name="changedaimweight">
<br>
<input type=submit value="提交"/>
</form>
<br>

如果需要推荐，点击
<a href="rankingGym">这里</a>
<br>

<form action="backHomepage.action">
<input type=submit value="返回首页"/>
<br>
</form>

</body>
</html>