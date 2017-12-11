<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html style="height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" href="hitcso.ico" type="image/x-icon"/>
<title>我要去健身</title>
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
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;体育馆基本信息更新
    </font>
    <h2>${msg }</h2>  s
   </p>
   </center>

<hr />
<div style="width:100%;min-height:500px;height:auto;position:relative;top:0px;left:0px;">
<div id="htl">
<div style="width:100%;min-height:300px;height:auto;background-color:rgba(255,245,238,0.5);position:relative;top:60px;left:50px">
<font face="楷体" size = "7" color="black">
<s:property value="name"/>
体育馆
</font>
<br><br>
<font face="楷体" size = "5" color="black">
位置：<s:property value="position"/>
<br>
价格：<s:property value="price"/>
<br>
时间：<s:property value="time"/>
<br>
分数：<s:property value="score"/>(10分满分)
<br>
<form action="checkcomment.action">
<input name="getuser" type="hidden" value=<s:property value="setuser"/>>
<input name="getname" type="hidden" value=<s:property value="name"/>>
<input type=submit value="查看评论"/>
<br>
</form>
<br>
联系电话：<s:property value="tele"/>
<br>
设施种类：
<br>
<s:iterator value="faclist" var='i'>
    <s:property value="fac"/>:
    <s:property value="introduction"/>
  <br>
</s:iterator>
<br><br>


<form action="order.action">
预定服务：
<input name="getuser" type="hidden" value=<s:property value="setuser"/>>
<input name="gymname" type="hidden" value=<s:property value="name"/>>
<input type=submit value="我要预订"/>
<br>
</form>
<br><br>


<form action="score.action">
<input name="getuser" type="hidden" value=<s:property value="setuser"/>>
<input name="gym" type="hidden" value=<s:property value="name"/>>
评分:(10分满分)
<s:select headerKey="-1" headerValue="请选择" name="userscore" list="#{'0':'0','1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10'}"/>
<br>
评论：
<input type=text name="usercomment"/>
</font>
<br>
<input type=submit value="提交"/>
<br>
</form>
<br><br>


<font face="楷体" size = "7" color="black">
<form action="searchusergame.action">
<input name="getuser" type="hidden" value=<s:property value="setuser"/>>
查看比赛信息
<br>
<input name="gymgetname" type="hidden" value=<s:property value="name"/>>
<s:select headerKey="-1" headerValue="请选择" name="index" list="gamelist"  listKey="index" listValue="name"/>
<input type=submit value="确定"/>
</form>


<form action="backHomepage.action">
<input name="getuser" type="hidden" value=<s:property value="setuser"/>>
<input type=submit value="返回首页"/>
<br>
</form>


</body>
</html>