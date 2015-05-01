<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=gb2312" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>增加新员工</title>
<s:head/>
</head>
<body>

<table width=780 align="center">
<tr>
<td>
注册：<br/>
<s:if test="tip!=null">
<div class="error">
	<s:property value="tip"/>
</div>
</s:if>
<div align="center">
<s:form action="Register">
	<s:textfield name="user.email" label="邮箱（帐号）"/>
	<s:textfield name="user.pass" label="登陆密码"/>
	<s:textfield name="user.name" label="昵称"/>
	<s:textfield name="user.phone" label="联系电话"/>
	<s:textfield name="user.address" label="家庭地址"/>
	<s:token/>
	<tr><td colspan="2">
	<s:submit value="注册" theme="simple"/>
	<s:reset  theme="simple" value="重新输入"/>
	</td></tr>
</s:form>
</div>
</td>
</tr>
</table>

</body>
</html>
