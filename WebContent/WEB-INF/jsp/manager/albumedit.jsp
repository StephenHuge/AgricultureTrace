<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Album Edit</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/about.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/base.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/media.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/style.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/css/index.css"
	type="text/css">
</head>
<body>
	<div class="ibody">
		<header>
			<h1>So Cool!</h1>
			<h2>If you never try, you will never know!</h2>
			<%@ include file="managernavi.jsp"%>
		</header>

		<article>
			<h2 class="about_h">
				You now as:<a
					href="http://localhost:8080/SpringMVC_Blog/manager/index">Index</a>>>
				<a href="http://localhost:8080/SpringMVC_Blog/manager/album">Album</a>
				<a href="http://localhost:8080/SpringMVC_Blog/manager/addalbum">Add
					album</a>
			</h2>
			<div class="about">
				<h2 align="center">Edit Album</h2>
			</div>
			<div class="template">
				<h3>
					My album
					<!--           <a href="#"  class="more"></a> More -->
				</h3>
			</div>
			<sf:form method="post" modelAttribute="album">
				<table width=700 align="center" border="1">
					<tr>
						<td>Album Name:</td>
						<td><sf:input path="album" /></td>
					</tr>
					<tr>
					<td>Type:</td>
					<td>
						<%-- <sf:input path="type" /> --%> 
						<select name="photonumber">
							<option value='Me'>Me</option>
							<option value='Cool'>Weather</option>
							<option value='Beauty'>Beauty</option>
							<option value='Sea'>Sea</option>
					</select>
					</td>
					</tr>
					<tr>
						<td>Photo:</td>
						<td><sf:input path="photo" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Update Album" />
						</td>
					</tr>
				</table>
			</sf:form>

			<!-- 			<h3> -->
			<!-- 				<span>New Comments</span> -->
			<!-- 			</h3> -->
			<!-- 			<ul class="pl_n"> -->
			<%-- 				<c:forEach items="${albumlist}" var="album1"> --%>
			<!-- 					<dl> -->
			<!-- 						<dt> -->
			<%-- 							<img src="<%=request.getContextPath()%>/Resources/images/s8.jpg"> --%>
			<!-- 						</dt> -->
			<!-- 						<dt></dt> -->
			<%-- 						<dd>${album1.photoname} --%>
			<%-- 							<time>${album1.pdate}</time> --%>
			<!-- 						</dd> -->
			<!-- 						<dd> -->
			<%-- 							<a href="#">${album1.pcomment}</a> --%>
			<!-- 						</dd> -->
			<!-- 					</dl> -->
			<%-- 				</c:forEach> --%>
			<!-- 			</ul> -->
		</article>

		<aside>
			<%@ include file="information.jsp"%>
			<div class="rnav">
				<ul>
					<li class="rnav1 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumme">Me</a></li>
					<li class="rnav2 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumcool">Cool</a></li>
					<li class="rnav3 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumbeauty">Beauty</a></li>
					<li class="rnav4 "><a href="http://localhost:8080/SpringMVC_Blog/manager/albumsea">Sea</a></li>
				</ul>
			</div>
			<div class="links">
				<h2>
					<p>Link</p>
				</h2>
				<ul>
					<li><a href="http://www.facebook.com">Facebook</a></li>
					<li><a href="http://www.twitter.com">Twitter</a></li>
					<li><a href="https://wx.qq.com/"> Wechat</a></li>
					<li><a href="http://www.qq.com"> QQ</a></li>
				</ul>
			</div>
			<%@ include file="../copyright.jsp"%>
		</aside>
		<div class="clear"></div>
	</div>
</body>
</html>