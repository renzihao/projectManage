package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDeleteDao {

	String dbUrl= "jdbc:mysql://localhost:3306/project_manage?useSSL=false";
    String dbUser="root";
    String dbPassword="root";
	
    //根据用户id 删除用户
	public void deleteUser(String userId) {
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
            
            sql = "delete from user_data where userId = ?";
            stmt = connection.prepareStatement(sql);//创建Statement对象
            stmt.setString(1, userId);
            
           
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
