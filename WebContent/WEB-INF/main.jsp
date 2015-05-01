<%@ page contentType="text/html; charset=gb2312" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>ITA系统</title>
</head>
<body>
	<h1 align="center">
		登陆成功！
	</h1>
	<s:if test="tip!=null">
		<div class="error">
			<s:property value="tip"/>
		</div>
	</s:if>
	
	<form action="AddLocation.action" name="AddLocationForm" method="post"> 
    <table align="center">
	    <tr>
		    <td>经度：</td>
		    <td><input type="text" name="location.longitude" style="width:154px;" required="true" placeholder="必填"/>
		    </td>
		</tr>
		<tr>
			<td align="center">纬度：</td>
			<td><input type="text" style="width:154px;" name="location.latitude" required="true" placeholder="必填"/>
		    </td>
		</tr>
		<tr>
			<td colspan="2" align="center">	
		    <input type="submit" value="添加" name="submit"/>
		    </td>
		</tr>

	</table>
	</form>	

</body>
</html>
