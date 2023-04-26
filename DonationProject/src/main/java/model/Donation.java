package model;

public class Donation {
	private int id;
	private float money;
	private int userId,fundId;
	private String userName,fundName;
	private String message;
	public Donation() {
		
	}
	
	public Donation(int id, float money, int user_id, int fund_id, String message) {
		super();
		this.id = id;
		this.money = money;
		this.userId = user_id;
		this.fundId = fund_id;
		this.message = message;
	}
	

	public Donation(int id, String money, String user_id, String fund_id, String message) {
		super();
		this.id = id;
		this.money = Float.parseFloat(money);
		this.userId = Integer.parseInt(user_id);
		this.fundId = Integer.parseInt(fund_id);
		this.message = message;
	}
	

	public Donation(int id, float money, int userId, int fundId, String userName, String fundName, String message) {
		super();
		this.id = id;
		this.money = money;
		this.userId = userId;
		this.fundId = fundId;
		this.userName = userName;
		this.fundName = fundName;
		this.message = message;
	}
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoney() {
		return String.format("%.3f", money);
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getUser_id() {
		return userId;
	}
	public void setUser_id(int user_id) {
		this.userId = user_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getFund_id() {
		return fundId;
	}
	public void setFund_id(int fund_id) {
		this.fundId = fund_id;
	}
	
	
	
	
}
