<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<div style="border: 1px solid;width: 300px ; position:absolute;  top:50%;left:50%;margin: -100px 0 0 -160px; ">
		<form action="login" method="post" >
			<ul style="list-style-type: none">
				<li>
					<span style="display: inline-block;width: 70px">用户名：</span>
					<input type="text" name=userName style="width:100px "/>
				</li>
				<li>
					<span style="display: inline-block;width: 70px;margin-top: 5px">密码：</span>
					<input type="password" name=password style="width:100px " />
				</li>
				<li>
					<input type="submit" value="登录" style="margin:10px 0 0 80px">
				</li>
			</ul>
		</form>
	</div>
	
</body>
</html>