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
<div style="width:500%;min-height:300px;height:auto;background-color:rgba(255,245,238,0.5);position:relative;top:60px;left:50px">
<font face="楷体" size = "4" color="black">
<s:form action="originplan.action" theme="simple">
今天是<s:property value="date[0]"/>
<font face="楷体" size = "7" color="black">
请在表格中输入您打算更改进行的项目名
</font>
<table border="1">
  <tr>
    <td> 开始时间</td>
    <td> 结束时间</td>
    <td> <s:property value="date[1]"/> </td>
    <td> <s:property value="date[2]"/> </td>
    <td> <s:property value="date[3]"/> </td>
    <td> <s:property value="date[4]"/> </td>
    <td> <s:property value="date[5]"/> </td>
    <td> <s:property value="date[6]"/> </td>
    <td> <s:property value="date[7]"/> </td>
  </tr>
  <tr>
    <td><s:property value="showtimebegin[0]"/><br><input type="text" name="timebegin[0]"></td>
    <td><s:property value="showtimeend[0]"/><br><input type="text" name="timeend[0]"></td>
    <td><s:property value="showfac[0][0]"/><br><input type="text" name="fac[0][0]"></td>
    <td><s:property value="showfac[0][1]"/><br><input type="text" name="fac[0][1]"></td>
    <td><s:property value="showfac[0][2]"/><br><input type="text" name="fac[0][2]"></td>
    <td><s:property value="showfac[0][3]"/><br><input type="text" name="fac[0][3]"></td>
    <td><s:property value="showfac[0][4]"/><br><input type="text" name="fac[0][4]"></td>
    <td><s:property value="showfac[0][5]"/><br><input type="text" name="fac[0][5]"></td>
    <td><s:property value="showfac[0][6]"/><br><input type="text" name="fac[0][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[1]"/><br><input type="text" name="timebegin[1]"></td>
    <td><s:property value="showtimeend[1]"/><br><input type="text" name="timeend[1]"></td>
    <td><s:property value="showfac[1][0]"/><br><input type="text" name="fac[1][0]"></td>
    <td><s:property value="showfac[1][1]"/><br><input type="text" name="fac[1][1]"></td>
    <td><s:property value="showfac[1][2]"/><br><input type="text" name="fac[1][2]"></td>
    <td><s:property value="showfac[1][3]"/><br><input type="text" name="fac[1][3]"></td>
    <td><s:property value="showfac[1][4]"/><br><input type="text" name="fac[1][4]"></td>
    <td><s:property value="showfac[1][5]"/><br><input type="text" name="fac[1][5]"></td>
    <td><s:property value="showfac[1][6]"/><br><input type="text" name="fac[1][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[2]"/><br><input type="text" name="timebegin[2]"></td>
    <td><s:property value="showtimeend[2]"/><br><input type="text" name="timeend[2]"></td>
    <td><s:property value="showfac[2][0]"/><br><input type="text" name="fac[2][0]"></td>
    <td><s:property value="showfac[2][1]"/><br><input type="text" name="fac[2][1]"></td>
    <td><s:property value="showfac[2][2]"/><br><input type="text" name="fac[2][2]"></td>
    <td><s:property value="showfac[2][3]"/><br><input type="text" name="fac[2][3]"></td>
    <td><s:property value="showfac[2][4]"/><br><input type="text" name="fac[2][4]"></td>
    <td><s:property value="showfac[2][5]"/><br><input type="text" name="fac[2][5]"></td>
    <td><s:property value="showfac[2][6]"/><br><input type="text" name="fac[2][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[3]"/><br><input type="text" name="timebegin[3]"></td>
    <td><s:property value="showtimeend[3]"/><br><input type="text" name="timeend[3]"></td>
    <td><s:property value="showfac[3][0]"/><br><input type="text" name="fac[3][0]"></td>
    <td><s:property value="showfac[3][1]"/><br><input type="text" name="fac[3][1]"></td>
    <td><s:property value="showfac[3][2]"/><br><input type="text" name="fac[3][2]"></td>
    <td><s:property value="showfac[3][3]"/><br><input type="text" name="fac[3][3]"></td>
    <td><s:property value="showfac[3][4]"/><br><input type="text" name="fac[3][4]"></td>
    <td><s:property value="showfac[3][5]"/><br><input type="text" name="fac[3][5]"></td>
    <td><s:property value="showfac[3][6]"/><br><input type="text" name="fac[3][6]"></td>
   </tr>
   <tr>
    <td><s:property value="showtimebegin[3]"/><br><input type="text" name="timebegin[4]"></td>
    <td><s:property value="showtimeend[3]"/><br><input type="text" name="timeend[4]"></td>
    <td><s:property value="showfac[4][0]"/><br><input type="text" name="fac[4][0]"></td>
    <td><s:property value="showfac[4][1]"/><br><input type="text" name="fac[4][1]"></td>
    <td><s:property value="showfac[4][2]"/><br><input type="text" name="fac[4][2]"></td>
    <td><s:property value="showfac[4][3]"/><br><input type="text" name="fac[4][3]"></td>
    <td><s:property value="showfac[4][4]"/><br><input type="text" name="fac[4][4]"></td>
    <td><s:property value="showfac[4][5]"/><br><input type="text" name="fac[4][5]"></td>
    <td><s:property value="showfac[4][6]"/><br><input type="text" name="fac[4][6]"></td>
   </tr>
   <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><a href="deleteplan?day=0">删除</a></td>
    <td><a href="deleteplan?day=1">删除</a></td>
    <td><a href="deleteplan?day=2">删除</a></td>
    <td><a href="deleteplan?day=3">删除</a></td>
    <td><a href="deleteplan?day=4">删除</a></td>
    <td><a href="deleteplan?day=5">删除</a></td>
    <td><a href="deleteplan?day=6">删除</a></td>
    
   </tr>
</table>
<input type=submit value="保存"/>
</s:form>
<br>
<s:form action="backmyplan.action" theme="simple">
<input type=submit value="返回"/>
</s:form>





</form>
</div>
</div>
</div>
<hr />




</body>
</html>