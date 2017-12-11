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
<div style="width:400%;min-height:300px;height:auto;background-color:rgba(255,245,238,0.5);position:relative;top:60px;left:50px">
<font face="楷体" size = "5" color="black">
<s:form action="orderbygym.action">
<input name="getuser" type="hidden" value=<s:property value="setuser"/>>
<input name="gym" type="hidden" value=<s:property value="gymname"/>>
<s:property value="gymname"/>
体育馆
今天是<s:property value="week[0]"/>

<table border="1">

  <tr>
    <td> &nbsp;</td>
    <td> <s:property value="week[1]"/> </td>
    <td> <s:property value="week[2]"/> </td>
    <td> <s:property value="week[3]"/> </td>
    <td> <s:property value="week[4]"/> </td>
    <td> <s:property value="week[5]"/> </td>
    <td> <s:property value="week[6]"/> </td>
    <td> <s:property value="week[7]"/> </td>
  </tr>
  
  <tr>
    <td>8:00~11:00</td>
   
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[0][0]" list="f11"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[0][1]" list="f12"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[0][2]" list="f13"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[0][3]" list="f14"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[0][4]" list="f15"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[0][5]" list="f16"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[0][6]" list="f17"  listKey="index" listValue="name"/></td>

   </tr>
    
   <tr>
    <td>12:00~15:00</td>
   
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[1][0]" list="f21"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[1][1]" list="f22"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[1][2]" list="f23"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[1][3]" list="f24"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[1][4]" list="f25"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[1][5]" list="f26"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[1][6]" list="f27"  listKey="index" listValue="name"/></td>
    
   </tr>
   <tr>
    <td>16:00~19:00</td>
    
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[2][0]" list="f31"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[2][1]" list="f32"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[2][2]" list="f33"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[2][3]" list="f34"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[2][4]" list="f35"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[2][5]" list="f36"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="" headerValue="请选择" theme="simple" name="choose[2][6]" list="f37"  listKey="index" listValue="name"/></td>
   
   </tr>

</table>
 <input type=submit value="预定"/>
    </s:form>
    
    <s:form action="backgymdetail.action">
    <input name="getuser" type="hidden" value=<s:property value="setuser"/>>
    <input name="gym" type="hidden" value=<s:property value="gymname"/>>
    <input type=submit value="返回"/>
    </s:form>

</body>
</html>