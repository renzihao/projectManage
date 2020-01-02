package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserSelectByIdDao;
import dao.UserSelectDao;
import pojo.UserPojo;

public class UserSelectByIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符集编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		//获取参数
		String userId = req.getParameter("userId");
		//查询用户
		UserSelectByIdDao userSelectByIdDao = new UserSelectByIdDao();
		UserPojo userPojo = userSelectByIdDao.selectUserById(userId);
		
		//将数据存入作用域中
		req.setAttribute("userPojo", userPojo);
        //传给前端页面
		req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	 
}
