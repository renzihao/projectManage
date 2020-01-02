<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div  style="border: 1px solid;width: 300px ; position:absolute;  top:50%;left:50%;margin: -150px 0 0 -160px; ">
		<form action="userAdd" method="post">
			<ul style="list-style-type: none">
				<li>
					用户类型：
					<select name="userType" style="height: 25px">
						<option value="1">教师</option>
						<option value="2">学生</option>
					</select>
				</li>
				<li>姓名：
					<input type="text" name="userName" style="width:150px;margin-top: 10px" >
				</li>
				<li>
					性别：
					<select name="userSex" style="height: 25px;margin-top: 10px">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</li>
				<li>
					年龄：
					<input type="text" name="userAge" style="width:150px;margin-top: 10px " >
				</li>
				<li>
					密码：
					<input type="password" name=password style="width:150px;margin-top: 10px " />
				</li>
				<li>
					<input type="submit" value="提交" style="width:50px;margin: 10px 0 0 40px" />
				</li>
			</ul>
		
		</form>
		<a href="teacherMain.jsp" style=" position: absolute;top: 172px;left:154px;">
			<button style="width:50px;margin: 10px 0 0 30px">返回</button>
		</a>
	</div>
</body>
</html>