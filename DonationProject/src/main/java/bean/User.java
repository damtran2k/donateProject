package bean;

public class User {
	private int id;
	private  String username,password;
	private  String role = "User";
	private  String name,email,address, phone;
	private String status;
	public User() {
		
	}
	
	

	public User(int id, String username, String password, String role, String name, String email, String address,
			String phone, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}



	public User(String username, String password, String name, String email, String address, String phone,
			String status) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}



	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean regexUsername(String username) {
		String pattern = "^[a-zA-Z0-9_]{7,}$";
		if (username.matches(pattern)) {
		   return true;
		} 
		return false;
	}
	public boolean regexEmail(String email) {
		String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if (email.matches(pattern)) {
		   return true;
		} 
		return false;
	}
	public boolean regexPassword(String pass) {
		String pattern = "^[a-zA-Z0-9_]{7,}$";
		if (pass.matches(pattern)) {
		   return true;
		} 
		return false;
	}
	
	
	
}
