<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>设施情况更新</title>
</head>
<body>
<center><h1>体育馆设施情况更新</h1></center>
<style>
    body {
        word-spacing: 150px;
    }
</style>
<input type="button" onclick="window.location='gyminformation.jsp'" value="体育馆基本信息">
<input type="button" onclick="window.location='gymsheshi.jsp'" value="体育馆设施情况">
<input type="button" onclick="window.location='gymbiggame.jsp'" value="重大比赛">
<br><br>
<label for=sheshi1>设施1剩余数量：</label>
<input type="text" name="name" /> <input type="submit" value="确认" />
<br><br>
<label for=sheshi2>设施2剩余数量：</label>
<input type="text" name="name" /> <input type="submit" value="确认" />
<br><br>
<label for=sheshi3>设施3剩余数量：</label>
<input type="text" name="name" /> <input type="submit" value="确认" />
</body>
</html>