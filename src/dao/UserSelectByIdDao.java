package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.UserPojo;

public class UserSelectByIdDao {

	String dbUrl= "jdbc:mysql://localhost:3306/project_manage?useSSL=false";
	String dbUser="root";
    String dbPassword="root";

	//根据id 查询用户
	public UserPojo selectUserById(String userId){
		
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
            
        	sql = "select * from user_data where userId = ?";
        	stmt = connection.prepareStatement(sql);//创建Statement对象
	        stmt.setString(1, userId);
            
            System.out.println(sql);
	        ResultSet rs = stmt.executeQuery();
	        // 展开结果集数据库
	        UserPojo userPojo = new UserPojo();
            while(rs.next()){
            	
                // 通过字段检索
            	userPojo.setUserId(rs.getString("userId"));
            	userPojo.setUserName(rs.getString("userName"));
            	userPojo.setUserSex(rs.getString("userSex"));
            	userPojo.setUserAge(rs.getString("userAge"));
            	userPojo.setUserType(rs.getString("userType"));
            	userPojo.setPassword(rs.getString("password"));
                // 输出数据
            	System.out.println(userPojo.toString());
            	
            }
	        rs.close();
	        
	        return userPojo;
	        
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return null;
	        
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
