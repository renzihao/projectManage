package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.UserPojo;

public class UserSelectDao<E> {
	
	
	String dbUrl= "jdbc:mysql://localhost:3306/project_manage?useSSL=false";
    String dbUser="root";
    String dbPassword="root";

	//根据用户名、性别查询用户
	public List<UserPojo> selectUser(String userName,String userSex,String userType){
		
		System.out.println("用户查询参数："+userName+"-"+userSex);

		Connection connection = null;
		PreparedStatement  stmt =null;
		try {
			
		    
		    StringBuffer sql = new StringBuffer("select * from user_data where ");
		    
		    List<String> params = new ArrayList<String>();
	    
	    	 // 注册 JDBC 驱动
	        Class.forName("com.mysql.jdbc.Driver");
	        // 打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            if(!userName.equals("")&&userName != null) {
            	sql.append("userName = ?");
            	params.add(userName);
            }
            if(!userSex.equals("")&&userSex != null) {
            	
            	if(params.size() != 0) {
            		//集合长度不为0，则说明前面有条件，需要加and
            		sql.append(" and ");
            	}
            	//添加查询条件
            	sql.append("userSex = ?");
            	params.add(userSex);
            }
            if(!userType.equals("")&&userType != null) {
            	if(params.size() != 0) {
            		sql.append(" and ");
            	}
            	sql.append("userType = ?");
            	params.add(userType);
            }
            if(params.size() == 0) {
            	sql = new StringBuffer(sql.substring(0, sql.length()-6));
            }
            stmt = connection.prepareStatement(sql.toString());//创建Statement对象
            //根据 params 集合的大小判断是否有查询条件
            if(params.size() != 0) {
            	for (int i = 0; i < params.size(); i++) {
            		stmt.setString(i+1, params.get(i));
				}
            } 
//            if(userName == ""&&userSex == "") {
//            	sql = ;
//            	stmt = connection.prepareStatement(sql);//创建Statement对象
//            }
//            if(userName != ""&&userSex == "") {
//            	sql = "select * from user_data where userName=?";
//            	stmt = connection.prepareStatement(sql);//创建Statement对象
//    	        stmt.setString(1, userName);
//            }
//            if(userName ==""&&userSex != "") {
//            	sql = "select * from user_data where userSex=?";
//            	stmt = connection.prepareStatement(sql);//创建Statement对象
//    	        stmt.setString(1, userSex);
//            }
//            if(userName != ""&&userSex != "") {
//            	sql = "select * from user_data where userName=? and userSex = ?";
//            	stmt = connection.prepareStatement(sql);//创建Statement对象
//    	        stmt.setString(1, userName);
//    	        stmt.setString(2, userSex);
//            }
            System.out.println(sql.toString());
	        ResultSet rs = stmt.executeQuery();
	        List<UserPojo> list = new ArrayList<UserPojo>();
	        // 展开结果集数据库
            while(rs.next()){
            	UserPojo userPojo = new UserPojo();
            
                // 通过字段检索
            	userPojo.setUserId(rs.getString("userId"));
            	userPojo.setUserName(rs.getString("userName"));
            	userPojo.setUserSex(rs.getString("userSex"));
            	userPojo.setUserAge(rs.getString("userAge"));
            	userPojo.setUserType(rs.getString("userType"));
                // 输出数据
//            	System.out.println(userPojo.toString());
            	list.add(userPojo);
            }
	        rs.close();
	        
	        return list;
	        
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
