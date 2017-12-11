<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitionloal.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html style="height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" href="hitcso.ico" type="image/x-icon"/>
<title>我要去健身</title>
<script type="text/javascript">
    function jump1() {
    	  window.location = 'login.action';
	  }
    function jump2() {
        window.location = 'register.action';
    }
</script>
<style type="text/css">

html{width:100%;height:100%;} 

line-height:18px;padding:0px;margin:0px;text-align:center} 
div{padding:18px} 
img{border:0px;vertical-align:middle;padding:0;margin:0} 
input, button{font-family:"Arial", "Tahoma", "微软雅黑", "雅黑";border:0;
vertical-align:middle;margin:8px;line-height:18px;font-size:18px} 
.btn{width:140px;height:36px;line-height:18px;font-size:18px;
background:url("1.jpg") no-repeat left top;color:#FFF;padding-bottom:4px}

html,body{
    margin:0;
    padding:0;
    list-style:none;
}
h1{
    font-family:"华云彩体"; 
    font-size:20px;
    margin-bottom:0;
    position:relative;
    top:0px;
    left:40px;
}
#htl{
/*     background-color:#FF0000; */
    width:50%;
    boder:1px solid #000000;
    min-height:500px;
    height:auto;
    position:relative;
    top:0px;
    left:0px;
    float:left;
}
#htr{
    /*background-color:black;*/
    width:50%;
    boder:1px solid #000000;
    min-height:500px;
    height:auto;
    position:relative;
    top:0px;
    left:0px;
    float:left;
}
#dht{
    padding:10px;
    boder:1px solid#000000; 
    margin:0px;
}
</style>

</head>
<body class="img-circle" background="background.jpg"style="background-repeat:no-repeat ;background-size:100% 100%; background-attachment:fixed;">
<!--canvas id="myCanvas" width="1350" height="1000"
style="border:1px solid black">
your browser does not support the canvas element.
</canvas-->
<center>
<br>
<br>
<br>
<br>

      
    <font face="楷体" size = "50" color="#00ffff">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎来到体育馆查询系统
    </font>
    <h2>${msg }</h2>  s
   </p>
   </center>

<hr />
<div style="width:100%;min-height:500px;height:auto;position:relative;top:0px;left:0px;">
<div id="htl">
<div style="width:80%;min-height:300px;height:auto;background-color:rgba(255,245,238,0.5);position:relative;top:60px;left:50px">
<font face="楷体" size = "6" color="black">
注意事项：
</font>
<ol style="list-style-type:decimal">
<font face="楷体" size = "5" color="black">
<li>
若您已有账号，请点击登录
</li>
<br>
<li>
若还未注册，请先进行注册。
</li>
<br>
<li>
点击登录/注册后进行身份选择
</li>
<br>
<li>
请记住自己的密码
</li>
</font>
<br>
</ul>
</div>
</div>
<p> 
<br>
<br>
<br>
<form id="form1" name="form1" method="" action="login.action" target="_blank"> 
<div> 
<input type="button" align="right" size = "2000" class="btn" id="login_btn" value="登录"  onmouseover="this.style.backgroundPosition='left -36px'"
 onmouseout="this.style.backgroundPosition='left top'" onclick="jump1()"/>
</div> 
</form> 
</p> 

<br>
<p> 
<br>
<br>
<br>
<form id="form1" name="form1" method="" action="register.action" target="_blank"> 
<div> 
<input type="button" align="right" size = "2000" class="btn" id="register_btn" value="注册"  onmouseover="this.style.backgroundPosition='left -36px'"
 onmouseout="this.style.backgroundPosition='left top'" onclick="jump2()"/>
</div> 
</form> 
</p> 


</form>
</div>
</div>
</div>
<hr />
<div id="dht">
<p style="position:relative;top:0px;left:200px;">Copyright © 2009 all rights reserved. Power by 上海众臻信息科技有限公司
Please contact Us : market@sportoa.com
Tel : 021-54933212
</p>
</div>


</body>
</html>