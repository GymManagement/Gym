<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@taglib prefix="s" uri="/struts-tags" %>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>欢迎使用我要去健身系统</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
  
  </head>  
    
  <body>  
  <center>
    <h1>欢迎来到体育馆查询系统</h1>  
    <h2>${msg }</h2>  
    <p>
    <a  href=login align="center"><button type="button" >登录</button></a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a  href=register align="center"><button type="button" >注册</button></a>
    <br>
    <br>
    <br>
    <br>

        体育馆设施介绍
    <br>
     &nbsp; &nbsp;<img src="D:/java-learn/lab2/src/com/gym.jpg" width="200" height="150" hspace="300" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="welcomegame?id=1">体育馆比赛信息</a>
       
    <br>
    <img src="D:/java-learn/lab2/src/com/game.jpg" width="200" height="150" hspace="300" />

    </p>
  </center>
  </body>  
</html>  