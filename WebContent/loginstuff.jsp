<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="/struts-tags" prefix="s" %>  
<%@ page import = "com.Stuff" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title>工作人员注册</title>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>  
  <body>  
  <div><s:fielderror /></div>  
    <form action="loginstuffAction" method="post" name="form1">  
    <table align="center">  
        <tr>  
            <td>体育馆</td>  
            <td><s:select headerKey="-1" headerValue="请选择" name="stuff.gym" list="gymlist"  listKey="name" listValue="name"/></td>  
        </tr>  
        <tr>  
            <td>序号</td>  
            <td><input type="text" name="stuff.identity"></td>  
        </tr>  
        <tr>  
            <td>密码</td>  
            <td><input type="password" name="stuff.password"></td>  
        </tr>  
        
    
        <tr>  
            <td><input type="submit" value="提交"></td>  
            <td><input type="reset" value="重置">    
            <td><input type="button" value="注册"></td>
              
        </tr>  
    </table>  
    <s:actionerror/>  
    </form>  
  </body>  
</html> 