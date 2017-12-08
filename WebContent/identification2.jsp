<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
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
  
     <a  href=registerworker align="center"><button type="button" >健身房员工</button></a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    
      <a  href=registerguest align="center"><button type="button" >普通用户</button></a>
    <br>
    <br>
    <br>
    <br>

    <a href="welcomegame?id=1">体育馆比赛信息</a>
    <br>
     <img src="C:\Users\asus\Desktop\GYM\GYM\src\com\game.jpg" width="200" height="150" hspace="300" /> 
     <br>
    <br>
    <br>
    <br> 
    <img src="C:\Users\asus\Desktop\GYM\GYM\src\com\gym.jpg" width="200" height="150" hspace="300" />

    </p>
  </center>
  </body>  
</html>  