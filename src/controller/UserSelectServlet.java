package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserSelectDao;
import pojo.UserPojo;

//教师查询
public class UserSelectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符集编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		//获取参数
		String userName = req.getParameter("userName");
		String userSex = req.getParameter("userSex");
		String userType = req.getParameter("userType");
		//查询用户
		UserSelectDao userDao = new UserSelectDao();
		List<UserPojo> list = userDao.selectUser(userName, userSex,userType);
		
		//将数据存入作用域中
		req.setAttribute("userList", list);
        //传给前端页面
		req.getRequestDispatcher("teacherMain.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
}
