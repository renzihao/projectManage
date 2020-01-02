package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.UserPojo;

public class UserUpadteDao {

	String dbUrl= "jdbc:mysql://localhost:3306/project_manage?useSSL=false";
	String dbUser="root";
    String dbPassword="root";

	//用户修改
	public void updateUserById(String userId,String userName,String userSex,String userAge,String userType,String password){
		
		System.out.println("用户查询参数："+userId);

		Connection connection = null;
		PreparedStatement  stmt =null;
		try {
			
		    
		    String sql =null;
	    
	    	 // 注册 JDBC 驱动
	        Class.forName("com.mysql.jdbc.Driver");
	        // 打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            
        	sql = "update  user_data set userName=?,userSex=?,userAge=?,userType=?,password=? where userId = ?";
        	stmt = connection.prepareStatement(sql);//创建Statement对象
	        stmt.setString(1, userName);
	        stmt.setString(2, userSex);
	        stmt.setString(3, userAge);
	        stmt.setString(4, userType);
	        stmt.setString(5, password);
	        stmt.setString(6, userId);
            
            System.out.println(sql);
	        int rs = stmt.executeUpdate();
	       System.out.println("更新结果："+rs);
	        
	        
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        
	    }finally {
	    	// 完成后关闭
            try {
				stmt.close();
				connection.close();
				System.out.println("连接关闭");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
		
		
	}
}
