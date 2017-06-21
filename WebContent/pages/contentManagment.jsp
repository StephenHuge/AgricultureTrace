<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.mysql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>信息维护</title>
		<link rel="stylesheet" type="text/css" href="../../css/table.css">
		<style>
			#step1 {
			    font-size: 18px;
			    color: #C90014;
			    padding-left: 2px;
			    padding-top: 12px;
			}
			
			.datalist{  
			    border:1px solid #0058a3;   /* 表格边框 */  
			    font-family:Arial;  
			    border-collapse:collapse;   /* 边框重叠 */  
			    background-color:#eaf5ff;   /* 表格背景色 */  
			    font-size:14px;  
			}  
			.datalist caption{  
			    padding-bottom:5px;  
			    font:bold 1.4em;  
			    text-align:left;  
			}  
			.datalist th{  
			    border:1px solid #0058a3;   /* 行名称边框 */  
			    background-color:#4bacff;   /* 行名称背景色 */  
			    color:#FFFFFF;              /* 行名称颜色 */  
			    font-weight:bold;  
			    padding-top:4px; padding-bottom:4px;  
			    padding-left:12px; padding-right:12px;  
			    text-align:center;  
			}  
			.datalist td{  
			    border:1px solid #0058a3;   /* 单元格边框 */  
			    text-align:left;  
			    padding-top:4px; padding-bottom:4px;  
			    padding-left:10px; padding-right:10px;  
			}  
			.datalist tr.altrow{  
			    background-color:#c7e5ff;   /* 隔行变色 */  
			}  
		</style>
	</head>
	
	<body>
	
	
		
		
		<!--JDBC 驱动名及数据库 URL--> 
		<!--数据库的用户名与密码，需要根据自己的设置-->
		<!--useUnicode=true&characterEncoding=utf-8 防止中文乱码-->
		 
		<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		     url="jdbc:mysql://localhost:3306/AGRICULTURETRACE?useUnicode=true&characterEncoding=utf-8"
		     user="root"  password="1234"/>
		<sql:query dataSource="${snapshot}" var="result">
			SELECT * from GOODSATTR;
		</sql:query>
		<h1 id="step1">信息维护</h1>
		<table border="1" width="80%" class="datalist" align="center">
			<tr>
			   <th>商品ID</th>
			   <th>组ID</th>
			   <th>生产日期</th>
			   <th>保质期</th>
			   <th>重量</th>
			   <th>储存环境</th>
			   <th>营养</th>
			   <th>操作</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
			<tr align="center">
			   <td><c:out value="${row.goodsid}"/></td>
			   <td><c:out value="${row.groupid}"/></td>
			   <td><c:out value="${row.productdate}"/></td>
			   <td><c:out value="${row.shelflife}"/></td>
			   <td><c:out value="${row.weight}"/></td>
			   <td><c:out value="${row.stcondition}"/></td>
			   <td><c:out value="${row.nutrition}"/></td>
			   <td>
					<a href="/springMVC1/user/getUser?id=${u.id }">编辑</a>
					<a href="javascript:del('${u.id }')">删除</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		<%-- <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		     url="jdbc:mysql://localhost:3306/AGRICULTURETRACE?useUnicode=true&characterEncoding=utf-8"
		     user="root"  password="1234"/>
		<sql:query dataSource="${snapshot}" var="result">
			SELECT * from DEVICECODE;
		</sql:query>
		<h1 id="step1">生长环境</h1>
		<table border="1" width="60%" class="datalist" align="center">
			<tr>
			   <th>指标</th>
			   <th>值</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
			<tr align="center">
			   <td><c:out value="${row.字段}"/></td>
			   <td><c:out value="${row.值}"/></td>
			   
			</tr>
			</c:forEach>
		</table> --%>
		
		
		
		
	</body>
</html>