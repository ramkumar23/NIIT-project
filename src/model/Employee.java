 package model;

public class Employee {
	private int empId;
	private String FirstName;
	private String LastName;
	private String userId;
	private String password;
	private String role;
	private String gender;
	private String active;
	//default constructor methods
	
	public Employee() {
		
		
		//parameterized constructor methods
	}
	public Employee(String firstName, String lastName, String userId, String password, String role, String gender) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.gender = gender;
	}
	//All setter and getter method
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", userId=" + userId
				+ ", password=" + password + ", role=" + role + ", gender=" + gender + ", active=" + active + "]";
	}
	

}
