<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
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
<title>������Ա��</title>
<s:head/>
</head>
<body>

<table width=780 align="center">
<tr>
<td>
ע�᣺<br/>
<s:if test="tip!=null">
<div class="error">
	<s:property value="tip"/>
</div>
</s:if>
<div align="center">
<s:form action="Register">
	<s:textfield name="user.email" label="���䣨�ʺţ�"/>
	<s:textfield name="user.pass" label="��½����"/>
	<s:textfield name="user.name" label="�ǳ�"/>
	<s:textfield name="user.phone" label="��ϵ�绰"/>
	<s:textfield name="user.address" label="��ͥ��ַ"/>
	<s:token/>
	<tr><td colspan="2">
	<s:submit value="ע��" theme="simple"/>
	<s:reset  theme="simple" value="��������"/>
	</td></tr>
</s:form>
</div>
</td>
</tr>
</table>

</body>
</html>
