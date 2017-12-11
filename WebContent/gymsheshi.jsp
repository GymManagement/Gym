<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>设施情况更新</title>
</head>
<body>
<center><h1>体育馆设施情况更新</h1></center>

<s:property value="nameOfGym"/>
体育馆
<br><br>


<form action="facinum.action">
添加或修改设施：(修改数量必须大于用户预订数量)
<br>
设施名称:<input type=text name="newname"/>
<br>
数量：<input type=text name="newnum"/>
<br>
简介：<input type=text name="newintroduce"/>
<br>
<input type=submit value="提交"/>
<br><br>
</form>
<br>



查询设施
<br>
<form action="findfac.action">
设施名称:<s:select headerKey="-1" headerValue="请选择" name="findname" list="facnow"  listKey="index" listValue="facname"/> 
<input name="way" type="hidden" value="1"/>
<input type=submit value="查询"/>
</form>
<form action="findfac.action">
日期：<s:select headerKey="-1" headerValue="请选择" name="finddate" list="week"  listKey="index" listValue="data"/> 
<input name="way" type="hidden" value="2"/>
<input type=submit value="查询"/>
</form>
<form action="findfac.action">
时间段：<s:select headerKey="-1" headerValue="请选择" name="findtime" list="#{'1':'1','2':'2','3':'3'}"/> 
<input name="way" type="hidden" value="3"/>
<input type=submit value="查询"/>
</form>
<form action="findfac.action">
用户名：<input type=text name="finduser"/>
<input name="way" type="hidden" value="4"/>
<input type=submit value="查询"/>
</form>
<br>

查询结果：
<br>
<table>
<tr>
  <td>日期</td>
  <td>时间段</td>
  <td>用户</td>
  <td>设施名称</td>
</tr>
<s:iterator value="resultout" var='i'>
<tr>
<td><s:property value="resulttdate"/></td>
<td> <s:property value="resulttime"/></td>
<td><s:property value="resultuser"/></td>
<td><s:property value="resultfac"/></td>
</tr>
</s:iterator>
</table>

<br><br>


当前设施信息：
(种类数量：<s:property value="facnum"/>)
<br>
<table>
<tr>
  <td>名称</td>
  <td>总数量</td>
  <td>介绍</td>
</tr>
<s:iterator value="facnow" var='i'>
<tr>
<td><s:property value="facname"/></td>
<td> <s:property value="num"/></td>
<td><s:property value="introduce"/></td>
</tr>
</s:iterator>
</table>
<br><br>







<form action="backstuffhome.action">
<input type="submit" value="返回主页面">
</form>

</body>
</html>