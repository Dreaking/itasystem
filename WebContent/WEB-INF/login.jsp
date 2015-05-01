<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录系统</title>
<s:head/>
</head>
<body>
<table width=780 align="center">
<tr >
<td >
请输入用户名和密码来登录<br />
<s:if test="tip!=null">
<div class="error">
	<s:property value="tip"/>
</div>
</s:if>
<div align="center">
<s:form action="Login.action">
	<s:textfield name="user.email" label="邮箱"/>
	<s:textfield name="user.pass" label="密码"/>
	<tr><td colspan="2">
	<s:submit value="登录" theme="simple"/><s:reset theme="simple" value="重填"/>
	</td></tr>
</s:form>
 <form action="Login.action" name="loginForm" method="post"> 
    <table align="center">
	    <tr>
		    <td>用户名：</td>
		    <td><input type="text" name="user.email" style="width:154px;" required="true" placeholder="必填"/>
		    </td>
		</tr>
		<tr>
			<td align="center">密码：</td>
			<td><input type="password" style="width:154px;" name="user.pass" required="true" placeholder="必填"/>
		    </td>
		</tr>
		<tr>
			<td colspan="2" align="center">	
		    <input type="submit" value="登陆" name="submit"/>
		    </td>
		</tr>

	</table>
	</form>	
	<p align="center">
		    <a href="/ITAsystem/register.jsp">现在注册,加入我们</a>
	</p>

</div>
</td>
</tr>
</table>
</body>
</html>
