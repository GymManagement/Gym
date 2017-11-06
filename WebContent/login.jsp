<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>普通用户登录界面</title>  
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
<h1>普通用户登录</h1>  
<form action="LoginServlet" method="post">  
    <table>  
    <tr>  
    <td width="100" align="center"><font size="4">手机号：</font></td><td colspan="3"><input type="text" name="username" value="${username }" style="width:200;height:25;"/>
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
    <tr><td colspan="3" align="center"><input type="button" value="登录" style="width:130;height:30;"/></td></tr>  
    </table>  
    </form>  
    <a href="re-register2"><font size="3"><i>没有帐号？点击注册</i></font></a>  
<font color="red" size="2"> ${msg }</font>  
</div>  
</center>  
  </body>  
</html> 