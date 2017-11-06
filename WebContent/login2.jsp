<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>工作人员登录界面</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
    <script type="text/javascript">  
      function change(){  
          var img =document.getElementById("verify");  
          img.src="VerifyCodeServlet?a="+new Date().getTime();  
      }  
    </script>  
  </head>  
    
  <body>  
  <center>  
<div>  
<h1>工作人员登录</h1>  
 
    <table>  
    <tr>  
    <td width="100" align="center"><font size="4">编码：</font></td><td colspan="3"><input type="text" name="username" value="${username }" style="width:200;height:25;"/>
    <br>
    <br>
    </td>  

    </tr>  
  
    <tr>  
    <td align="center"><font size="4">密码：</font></td><td colspan="3"><input type="password" name="password"  style="width:200;height:25;"/>
    <br> 
    <br>
    </td>  
    </tr>  
    
    
    </table>  

    <a  href=loginsuccess align="center"><button type="button" >登录</button></a>
    <a href="noidentity"><button type="button" >没有账号？点击注册</button></a> 
<font color="red" size="2"> ${msg }</font>  
</div>  
</center>  
  </body>  
</html> 