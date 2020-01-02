package pojo;

public class UserPojo {
	
	private String userId;
	private String userName;
	private String userSex; //1：男；2：女
	private String userAge;
	private String userType;//1：教师；2：学生
	private String password;
	
	
	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserPojo(String userId, String userName, String userSex, String userAge, String userType, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userType = userType;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge
				+ ", userType=" + userType + ", password=" + password + "]";
	}
	
	
	
	

}
