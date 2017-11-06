<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>注册界面</title>  
      
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
    <div>  
    <h1>用户注册</h1>  
    <form action="RegistServlet" method="post">  
    请输入姓名：<input type="text" name="username"><br/>  
  <br>
    请输入编号：<input type="text" name="number"><br/>  
  <br>
    请输入验证信息：<input type="text" name="identity"><br/>  
  <br>
    请输入邮箱：<input type="text" name="email"><br/>  
  <br>
    请输入手机号：<input type="text" name="phonenum"><br/>  
  <br>
    请输入密码：<input type="password" name="password"><br/>  
  <br>
    请确认密码：<input type="password" name="rpsw"><br/>  
  <br>
    
    
    <a  href=registersuccess align="center"><button type="button" >注册</button></a>
    </form>  
   <font color="red" size="3"> ${msg }</font>  
    </div>  
    </center>  
  </body>  
</html>  