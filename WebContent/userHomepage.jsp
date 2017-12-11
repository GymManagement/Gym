<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html style="height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" href="hitcso.ico" type="image/x-icon"/>
<title>用户注册界面</title>

<style type="text/css">
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
    boder:1px solid了，#000000; 
    margin:0px;
}
</style>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">

  
  
  </script>

</head>
<body class="img-circle" background="background.jpg"style="background-repeat:no-repeat ;background-size:100% 100%; background-attachment:fixed;">
<!--canvas id="myCanvas" width="1350" height="1000"
style="border:1px solid black">
your browser does not support the canvas element.
</canvas-->

<div id="dht">
<h1><img src="top.jpg" width="800" height="250"/></h1></div>
<hr />

<div style="width:100%;min-height:500px;height:auto;position:relative;top:0px;left:0px;">
<div id="htl">
<div style="width:100%;min-height:300px;height:500;background-color:rgba(255,245,238,0.5);position:relative;top:30px;left:200px">
<h4 style="position:relative;top">注意事项：</h4>
<ol style="list-style-type:decimal">

你好，
<a href="changeInfo?xxx=<s:property value="xxx"/>"><s:property value="xxxname"/></a>
<br>


<form action="searchGym.action">
你想查看什么体育馆呢
<s:select headerKey="-1" headerValue="请选择" name="nameOfGym" list="gymlist"  listKey="index" listValue="name"/> 

<input type=submit value="确定"/>
</form>
<br>

<a href="myplan?username=<s:property value="xxx"/>">我的健身计划</a>
<br>

如果需要推荐，点击
<a href="rankingGym">这里</a>
<br>

<form action="searchusergame.action">
查询比赛信息：
<s:select headerKey="-1" headerValue="请选择" name="index" list="gamelist"  listKey="index" listValue="name"/>
<input type=submit value="确定"/>
</form>

<a href="searchmyorder">查询预定信息</a>

<form action="backLogin.action">
<input type=submit value="返回登录界面"/>
</form>
<br>

 

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