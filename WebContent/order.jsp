<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="orderbygym.action">
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
   
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose11" list="f11"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose12" list="f12"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose13" list="f13"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose14" list="f14"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose15" list="f15"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose16" list="f16"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose17" list="f17"  listKey="index" listValue="name"/></td>

   </tr>
    
   <tr>
    <td>12:00~15:00</td>
   
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose21" list="f21"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose22" list="f22"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose23" list="f23"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose24" list="f24"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose25" list="f25"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose26" list="f26"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose27" list="f27"  listKey="index" listValue="name"/></td>
    
   </tr>
   <tr>
    <td>16:00~19:00</td>
    
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose31" list="f31"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose32" list="f32"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose33" list="f33"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose34" list="f34"  listKey="index" listValue="name"/></td> 
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose35" list="f35"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose36" list="f36"  listKey="index" listValue="name"/></td>
    <td><s:select headerKey="-1" headerValue="请选择" theme="simple" name="choose37" list="f37"  listKey="index" listValue="name"/></td>
    
   </tr>

</table>
 <input type=submit value="预定"/>
    </s:form>
    
    <s:form action="backgymdetail.action">
    <input name="gym" type="hidden" value=<s:property value="gymname"/>>
    <input type=submit value="返回"/>
    </s:form>
</body>
</html>