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


<form action="backchangeinfo.action">


请输入密码以验证身份：<input type=text name="password"/>
<br>
新密码：<input type=text name="newpassword"/>
<br>
新名字：<input type=text name="newname"/>
<br>
新邮箱：<input type=text name="newemail"/>
<br>


<input type=submit value="提交"/>
<br>
</form>

<form action="backHomepage.action">
<input type=submit value="返回首页"/>
<br>
</form>
</body>
</html>