<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		a{
			text-decoration: none;
		}
	</style>
</head>
<body>
	<div  style="border: 1px solid;width: 300px ; position:absolute;  top:50%;left:50%;margin: -150px 0 0 -160px; ">
		<form action="userUpadte" method="post">
			<ul style="list-style-type: none">
				<li>ID：
					<input type="text" name="userId" value="${userPojo.userId}" readonly style="width:150px;margin-top: 10px" >
				</li>
				<li>
					用户类型：
					<select name="userType" style="height: 25px;margin-top: 10px">
						<c:if test="${userPojo.userType=='1'}">
		                	<option value="1" selected>教师</option>
							<option value="2">学生</option>
	                	</c:if>
	                	<c:if test="${userPojo.userType=='2'}">
	                		<option value="1">教师</option>
							<option value="2" selected>学生</option>
	                	</c:if>
					</select>
				</li>
				<li>姓名：
					<input type="text" name="userName" value="${userPojo.userName}" style="width:150px;margin-top: 10px" >
				</li>
				<li>
					性别：
					<select name="userSex" style="height: 25px;margin-top: 10px;">
						<c:if test="${userPojo.userSex=='1'}">
		                	<option value="1" selected>男</option>
							<option value="2">女</option>
	                	</c:if>
	                	<c:if test="${userPojo.userSex=='2'}">
	                		<option value="1">男</option>
							<option value="2" selected>女</option>
	                	</c:if>
					</select>
				</li>
				<li>
					年龄：
					<input type="text" name="userAge" value="${userPojo.userAge}" style="width:150px;margin-top: 10px " >
				</li>
				<li>
					密码：
					<input type="password" name="password" value="${userPojo.password}" style="width:150px;margin-top: 10px " />
				</li>
				<li>
					<input type="submit" value="提交" style="width:50px;margin: 20px 0 0 40px" />
				</li>
			</ul>
		
		</form>
		<a href="teacherMain.jsp" style=" position: absolute;top: 224px;left:154px;">
			<button style="width:50px;margin: 10px 0 0 30px">返回</button>
		</a>
	</div>
</body>
</html>