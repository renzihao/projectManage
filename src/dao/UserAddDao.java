package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.UserIdUtil;

public class UserAddDao {
	String dbUrl= "jdbc:mysql://localhost:3306/project_manage?useSSL=false";
    String dbUser="root";
    String dbPassword="root";
	
    //添加用户
	public void addUser(String userName,String userSex,String userAge,String userType,String password) {
//		System.out.println("用户查询参数："+userId);

		Connection connection = null;
		PreparedStatement  stmt =null;
		try {
		    
		    String sql =null;
	    
	    	 // 注册 JDBC 驱动
	        Class.forName("com.mysql.jdbc.Driver");
	        // 打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            
            sql = "insert into  user_data (userId,userName,userSex,userAge,userType,password) value(?,?,?,?,?,?)";
            stmt = connection.prepareStatement(sql);//创建Statement对象
            
            //获取id
            String userId = UserIdUtil.getUserId();
            
            stmt.setString(1, userId);
            stmt.setString(2, userName);
	        stmt.setString(3, userSex);
	        stmt.setString(4, userAge);
	        stmt.setString(5, userType);
	        stmt.setString(6, password);
            
           
            System.out.println(sql);
	        int executeUpdate = stmt.executeUpdate();
	        
	        
	        
	        
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
