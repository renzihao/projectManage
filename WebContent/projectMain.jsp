<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>教师系统</title>
</head>
<body>
	<div style="width: 120px;margin: 0;position: absolute;left:0;top:50px;">
		<jsp:include page ="leftList.jsp"/>
	</div>
	<div style=" position: absolute;top: 60px;left:155px;bottom:0;">
		
		<div style="clear: both;">
			<form action="teacherSelect" method="get" >
				<ul style="list-style-type: none;">
					<li style="float: left;">项目名称：<input type="text" name="userName" /></li>
					<li style="float: left; margin: 0 0 0 20px">
						
					</li>
					<li style="float: left; margin: 0 0 0 20px">
						<input type="submit" value="查询" />
					</li>
					<li style="float: left; margin: 0 0 0 20px">
						<button >添加</button>
					</li>
				</ul>
			</form>
		</div>
		
		
		<table border="1" width="700px;" style="clear: both;margin: 50px 10px 0 20px">
	        <tr align = "center">
	            <td>ID</td>
	            <td>项目名称</td>
	            <td>指导老师</td>
	            <td>学生</td>
	        </tr>
	        <c:forEach items="${a}" var="res">
	            <tr align = "center">
	                <td>${res.userId}</td>
	                <td>${res.userName}</td>
	                <td>${res.userSex}</td>
	                <td>${res.userAge}</td>
	            </tr>
	        </c:forEach>
    	</table>
	</div>
</body>
</html>