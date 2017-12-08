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
<s:form action="searchfac.action">
搜索健身设施：
<input type="text" name="facneed"/>
<input type="submit" value="查询"/>
</s:form>
<s:iterator value="gymlist" var='i'>
    <a href="searchGym?nameOfGym=<s:property value="index"/>"><s:property value="name"/></a>
    <s:property value="num"/>人评价
    <s:property value="score"/>分
  <br>
</s:iterator>

<s:form action="backHomepage.action">
<input type="submit" value="返回"/>
</s:form>
<br>



</body>
</html>