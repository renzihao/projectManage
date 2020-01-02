<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>教师系统</title>
	<style type="text/css">
		a{
			text-decoration: none;
		}
	</style>
</head>
<body>
	<div style="width: 120px;margin: 0;position: absolute;left:0;top:50px;">
		<jsp:include page ="leftList.jsp"/>
	</div>
	<div style=" position: absolute;top: 60px;left:155px;bottom:0;">
		
		<div style="clear: both;">
			<form action="userSelect" method="get" >
				<ul style="list-style-type: none;">
					<li style="float: left;">姓名：<input type="text" name="userName" /></li>
					<li style="float: left; margin: 0 0 0 20px">
						性别：
						<select name="userSex" style="height: 25px">
							<option value="">全部</option>
							<option value="1">男</option>
							<option value="2">女</option>
						</select>
					</li>
					<li style="float: left; margin: 0 0 0 20px">
						用户类型：
						<select name="userType" style="height: 25px">
							<option value="">全部</option>
							<option value="1">教师</option>
							<option value="2">学生</option>
						</select>
					</li>
					<li style="float: left; margin: 0 0 0 20px">
						<input type="submit" value="查询" />
					</li>
					<li style="float: left; margin: 0 0 0 20px">
						<button>
							<a href="userAdd.jsp" >添加</a>
						</button>
					</li>
				</ul>
			</form>
		</div>
		
		
		<table border="1" width="700px;" style="clear: both;margin: 50px 10px 0 20px">
	        <tr align = "center">
	            <td>ID</td>
	            <td>姓名</td>
	            <td>性别</td>
	            <td>年龄</td>
	            <td>用户类型</td>
	            <td>操作</td>
	        </tr>
	        <c:forEach items="${userList}" var="res">
	            <tr align = "center">
	                <td>${res.userId}</td>
	                <td>${res.userName}</td>
	                <td>
	                	<c:if test="${res.userSex=='1'}">
	                		男
	                	</c:if>
	                	<c:if test="${res.userSex=='2'}">
	                		女
	                	</c:if>
	                </td>
	                <td>${res.userAge}</td>
	                <td>
	                	<c:if test="${res.userType=='1'}">
	                		教师
	                	</c:if>
	                	<c:if test="${res.userType=='2'}">
	                		学生
	                	</c:if>
					</td>
					<td>
						<a href="http://localhost:8080/projectManage/userSelectById?userId=${res.userId}">修改</a>
						<a href="http://localhost:8080/projectManage/userDelete?userId=${res.userId}">删除</a>
					</td>
	            </tr>
	        </c:forEach>
    	</table>
	</div>
</body>
</html>