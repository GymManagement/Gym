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
<s:form action="originplan.action" theme="simple">
今天是<s:property value="date[0]"/>
请在表格中输入您打算更改进行的项目名，我们将在开始时间的前一天为您提醒
<table border="1">
  <tr>
    <td> 开始时间</td>
    <td> 结束时间</td>
    <td> <s:property value="date[1]"/> </td>
    <td> <s:property value="date[2]"/> </td>
    <td> <s:property value="date[3]"/> </td>
    <td> <s:property value="date[4]"/> </td>
    <td> <s:property value="date[5]"/> </td>
    <td> <s:property value="date[6]"/> </td>
    <td> <s:property value="date[7]"/> </td>
  </tr>
  <tr>
    <td><s:property value="showtimebegin[0]"/><br><input type="text" name="timebegin[0]"></td>
    <td><s:property value="showtimeend[0]"/><br><input type="text" name="timeend[0]"></td>
    <td><s:property value="showfac[0][0]"/><br><input type="text" name="fac[0][0]"></td>
    <td><s:property value="showfac[0][1]"/><br><input type="text" name="fac[0][1]"></td>
    <td><s:property value="showfac[0][2]"/><br><input type="text" name="fac[0][2]"></td>
    <td><s:property value="showfac[0][3]"/><br><input type="text" name="fac[0][3]"></td>
    <td><s:property value="showfac[0][4]"/><br><input type="text" name="fac[0][4]"></td>
    <td><s:property value="showfac[0][5]"/><br><input type="text" name="fac[0][5]"></td>
    <td><s:property value="showfac[0][6]"/><br><input type="text" name="fac[0][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[1]"/><br><input type="text" name="timebegin[1]"></td>
    <td><s:property value="showtimeend[1]"/><br><input type="text" name="timeend[1]"></td>
    <td><s:property value="showfac[1][0]"/><br><input type="text" name="fac[1][0]"></td>
    <td><s:property value="showfac[1][1]"/><br><input type="text" name="fac[1][1]"></td>
    <td><s:property value="showfac[1][2]"/><br><input type="text" name="fac[1][2]"></td>
    <td><s:property value="showfac[1][3]"/><br><input type="text" name="fac[1][3]"></td>
    <td><s:property value="showfac[1][4]"/><br><input type="text" name="fac[1][4]"></td>
    <td><s:property value="showfac[1][5]"/><br><input type="text" name="fac[1][5]"></td>
    <td><s:property value="showfac[1][6]"/><br><input type="text" name="fac[1][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[2]"/><br><input type="text" name="timebegin[2]"></td>
    <td><s:property value="showtimeend[2]"/><br><input type="text" name="timeend[2]"></td>
    <td><s:property value="showfac[2][0]"/><br><input type="text" name="fac[2][0]"></td>
    <td><s:property value="showfac[2][1]"/><br><input type="text" name="fac[2][1]"></td>
    <td><s:property value="showfac[2][2]"/><br><input type="text" name="fac[2][2]"></td>
    <td><s:property value="showfac[2][3]"/><br><input type="text" name="fac[2][3]"></td>
    <td><s:property value="showfac[2][4]"/><br><input type="text" name="fac[2][4]"></td>
    <td><s:property value="showfac[2][5]"/><br><input type="text" name="fac[2][5]"></td>
    <td><s:property value="showfac[2][6]"/><br><input type="text" name="fac[2][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[3]"/><br><input type="text" name="timebegin[3]"></td>
    <td><s:property value="showtimeend[3]"/><br><input type="text" name="timeend[3]"></td>
    <td><s:property value="showfac[3][0]"/><br><input type="text" name="fac[3][0]"></td>
    <td><s:property value="showfac[3][1]"/><br><input type="text" name="fac[3][1]"></td>
    <td><s:property value="showfac[3][2]"/><br><input type="text" name="fac[3][2]"></td>
    <td><s:property value="showfac[3][3]"/><br><input type="text" name="fac[3][3]"></td>
    <td><s:property value="showfac[3][4]"/><br><input type="text" name="fac[3][4]"></td>
    <td><s:property value="showfac[3][5]"/><br><input type="text" name="fac[3][5]"></td>
    <td><s:property value="showfac[3][6]"/><br><input type="text" name="fac[3][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[3]"/><br><input type="text" name="timebegin[4]"></td>
    <td><s:property value="showtimeend[3]"/><br><input type="text" name="timeend[4]"></td>
    <td><s:property value="showfac[4][0]"/><br><input type="text" name="fac[4][0]"></td>
    <td><s:property value="showfac[4][1]"/><br><input type="text" name="fac[4][1]"></td>
    <td><s:property value="showfac[4][2]"/><br><input type="text" name="fac[4][2]"></td>
    <td><s:property value="showfac[4][3]"/><br><input type="text" name="fac[4][3]"></td>
    <td><s:property value="showfac[4][4]"/><br><input type="text" name="fac[4][4]"></td>
    <td><s:property value="showfac[4][5]"/><br><input type="text" name="fac[4][5]"></td>
    <td><s:property value="showfac[4][6]"/><br><input type="text" name="fac[4][6]"></td>
   </tr>
   <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><a href="deleteplan?day=0">删除</a></td>
    <td><a href="deleteplan?day=1">删除</a></td>
    <td><a href="deleteplan?day=2">删除</a></td>
    <td><a href="deleteplan?day=3">删除</a></td>
    <td><a href="deleteplan?day=4">删除</a></td>
    <td><a href="deleteplan?day=5">删除</a></td>
    <td><a href="deleteplan?day=6">删除</a></td>
    
   </tr>
</table>
<input type=submit value="保存"/>
</s:form>
<br>
<s:form action="backmyplan.action" theme="simple">
<input type=submit value="返回"/>
</s:form>

</body>
</html>