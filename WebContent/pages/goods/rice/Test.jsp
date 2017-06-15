<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript">
			function goodsdetail() {
				var form = document.forms[0];
				form.action="/SpringMVC_Blog/goodsDetails/1";
			/* 	form.method="post"; */
				form.submit();
			}
		</script>
	</head>
	<body>
		<form name="goodsattrForm" action="">
			<input type="button" value="Good Details" onclick="goodsdetail()">
		</form>
	</body>
</html>