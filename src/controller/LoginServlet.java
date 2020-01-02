package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import dao.LoginDao;
import pojo.UserPojo;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		//获取参数
		//获取前端传递参数 dataType
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
		LoginDao loginDao = new LoginDao();
		UserPojo userPojo = loginDao.userLogin(userName, password);
		if (userPojo != null) {
			String userType = userPojo.getUserType();//1：教师；2：学生
			System.out.println(userType);
			if(userType.equals("1")) {
				//页面跳转
				req.getRequestDispatcher("teacherMain.jsp").forward(req, resp);
			}else {
				//页面跳转
				req.getRequestDispatcher("studentMain.jsp").forward(req, resp);
			}

		}
	}

	
}
