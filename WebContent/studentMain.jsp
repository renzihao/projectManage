<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生系统</title>
</head>
<body>
	
	<div>
		<form action="teacherSelect" method="get" >
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
					<input type="submit" value="查询" />
				</li>
				<li style="float: left; margin: 0 0 0 20px">
					<button >添加</button>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>