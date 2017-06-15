<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
	</head>
	
	<body>
		<form name="userForm" action="/SpringMVC_Blog/goodsDetail" method="post">
			<table border="1" width="100%">
				<caption>Goods Details</caption>
				<tbody>
					<c:if test="${!empty model }">
						<c:forEach items="${model }" var="u">
							<tr align="center">
								<td>${u.goodsId }</td>
								<td>${u.groupId }</td>
								
								<td>${u.productDate }</td>
								
								<td>${u.shelfLife }</td>
								<td>${u.weight }</td>
								<td>${u.stcondition }</td>
								<td>${u.nutrition }</td>
							
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</form>
					
					
					
					
					
					
<%-- 						<tr>
							<td>商品编号</td>
							<td>${goodsattr.goodsid }</td>
						</tr>
						<tr>
							<td>组编号</td>
							<td>${goodsattr.groupid }</td>
						</tr>
						<tr>
							<td>生产日期</td>
							<td>${goodsattr.productdate }</td>
						</tr>
						<tr>
							<td>保质期</td>
							<td>${goodsattr.shelflife }</td>
						</tr>
						<tr>
							<td>重量</td>
							<td>${goodsattr.weight }</td>
						</tr>
						<tr>
							<td>生长环境</td>
							<td>${goodsattr.stcondition }</td>
						</tr>
						<tr>
							<td>所含营养</td>
							<td>${goodsattr.nutrition }</td>
						</tr> --%>
						

		<%-- 	<c:if test="${!empty user }">
			<c:forEach items="${user }" var="u">
			<tr align="center">
				<td>${u.userName }</td>
				<td>${u.age }</td>
				<td>
					<a href="/springMVC1/user/getUser?id=${u.id }">编辑</a>
					<a href="javascript:del('${u.id }')">删除</a>
				</td>
			</tr>
			</c:forEach>
			</c:if>
		</tbody> --%>
		
	</body>
</html>