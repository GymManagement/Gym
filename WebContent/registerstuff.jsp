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
            <td>编号</td>  
            <td><input type="text" name="stuff.identity"></td>  
        </tr>  
        <tr>  
            <td>密码</td>  
            <td><input type="password" name="stuff.password"></td>  
        </tr>  
         <tr>  
            <td>姓名</td>  
            <td><input type="text" name="stuff.username"></td>  
        </tr> 
         <tr>  
            <td>邮箱</td>  
            <td><input type="text" name="stuff.email"></td>  
        </tr>  
         <tr>  
            <td>电话</td>  
            <td><input type="text" name="stuff.phonenum"></td>  
        </tr>  
        <tr>  
            <td>体育馆</td>  
             
            <td><s:select headerKey="-1" headerValue="请选择" name="stuff.gym" list="gymlist"  listKey="name" listValue="name"/></td>  
        </tr> 
       
        <tr>  
            <td><input type="submit" value="注册"></td>  
            <td><input type="reset" value="重置"></td>  
        </tr>  
    </table>  
    <s:actionerror/>  
    </form>  
  </body>  
</html>  