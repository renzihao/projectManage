package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.UserPojo;

public class LoginDao {
	
//	public static void main(String[] args) {
//		new LoginDao().userLogin("111","111");
//	}
	public UserPojo userLogin(String userName,String password){
		
		Connection connection = null;
		PreparedStatement  stmt =null;
		try {
			
		    String url= "jdbc:mysql://localhost:3306/project_manage?useSSL=false";
		    String dbUser="root";
		    String dbPassword="root";
	    
	    	 // 注册 JDBC 驱动
	        Class.forName("com.mysql.jdbc.Driver");
	        // 打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            
	        String sql = "select * from user_data where userName=? and password=?";
	        stmt = connection.prepareStatement(sql);//创建Statement对象
	        stmt.setString(1, userName);
	        stmt.setString(2, password);
	        ResultSet rs = stmt.executeQuery();
	        UserPojo userPojo = new UserPojo();
	        // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
            	userPojo.setUserId(rs.getString("userId"));
            	userPojo.setUserName(rs.getString("userName"));
            	userPojo.setUserSex(rs.getString("userSex"));
            	userPojo.setUserAge(rs.getString("userAge"));
            	userPojo.setUserType(rs.getString("userType"));
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
