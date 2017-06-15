<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>用户登陆</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">		
</head>
<%  
    String incode = (String)request.getParameter("code");   
    String rightcode = (String)session.getAttribute("rCode");   
      
    if(incode != null && rightcode != null){  
        if(incode.equals(rightcode)){  
            out.println("验证码输入正确！");  
        }else{  
            out.println("验证码输入不正确，请重新输入！");  
        }  
    }  
  %>  
<body style="margin-top: 0px; margin-left: 173px; background-color: #FFF;">
	<form id="login" action="user_login.action" method="post">
			<table cellpadding="0px" cellspacing="0px" align="center">
				<tr>
					<td width="450px" >
						<font size="2px" color="#8816511">用户名：</font>
						<input type="text" id="username" name="username" size="16"/>
					</td>
				</tr>
				<tr>
					<td width="450px">
						<font size="2px" color="#8816511">密码：</font>
						<input type="password" id="password" name="password" size="16"/>
					</td>
				</tr>
				<tr>
					<td width="450px" >
						<font size="2px" color="#8816511">验证码：</font>  
						<input type="text" name="code"/>  
	    				<img src="number.jsp"/>  
 					</td>
				</tr>
				<tr>
					<td width="450px">
						<input type="submit" value="确认提交"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="刷新重置"/>
					</td>
				</tr>
			</table>
		</form>	
</body>
</html>