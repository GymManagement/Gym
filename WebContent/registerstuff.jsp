<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="/struts-tags" prefix="s" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title><s:text name="title_registstuff"></s:text></title>  
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">  
  </head>  
  <body>  
    <form action="registstuffAction" method="post" name="form1">  
    <table align="center">  
        <tr>  
            <td><s:text name="identity"></s:text></td>  
            <td><input type="text" name="stuff.identity"></td>  
        </tr>  
        <tr>  
            <td><s:text name="password"></s:text></td>  
            <td><input type="password" name="stuff.password"></td>  
        </tr>  
         <tr>  
            <td><s:text name="username"></s:text></td>  
            <td><input type="text" name="stuff.username"></td>  
        </tr> 
         <tr>  
            <td><s:text name="email"></s:text></td>  
            <td><input type="text" name="stuff.email"></td>  
        </tr>  
         <tr>  
            <td><s:text name="phonenum"></s:text></td>  
            <td><input type="text" name="stuff.phonenum"></td>  
        </tr>  
        <tr>  
            <td><s:text name="gym"></s:text></td>  
            <td><input type="text" name="stuff.gym"></td>  
        </tr> 
       
        <tr>  
            <td><input type="submit" value=<s:text name="regist"></s:text>></td>  
            <td><input type="reset" value=<s:text name="reset"></s:text>></td>  
        </tr>  
    </table>  
    <s:actionerror/>  
    </form>  
  </body>  
</html>  