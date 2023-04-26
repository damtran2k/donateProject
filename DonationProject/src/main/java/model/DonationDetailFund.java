package model;

import java.util.Date;

public class DonationDetailFund {
	private int id;
	private String name,description,content,img_url,status;
	private float expectDonateMoney;
	private String createdDate,endDate;
	private int category_id,foundation_id;
	private String foundation,category;
	
	public DonationDetailFund() {
		// TODO Auto-generated constructor stub
	}

	public DonationDetailFund(int id, String name, String description, String content, String img_url, String status,
			float expectDonateMoney, String createdDate, String endDate, int category_id, int foundation_id,
			String foundation, String category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.content = content;
		this.img_url = img_url;
		this.status = status;
		this.expectDonateMoney = expectDonateMoney;
		this.createdDate = createdDate;
		this.endDate = endDate;
		this.category_id = category_id;
		this.foundation_id = foundation_id;
		this.foundation = foundation;
		this.category = category;
	}
	

	public DonationDetailFund(int id, String name, String description, String content, String img_url, String status,
			float expectDonateMoney, String createdDate, String endDate, int category_id, int foundation_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.content = content;
		this.img_url = img_url;
		this.status = status;
		this.expectDonateMoney = expectDonateMoney;
		this.createdDate = createdDate;
		this.endDate = endDate;
		this.category_id = category_id;
		this.foundation_id = foundation_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getExpectDonateMoney() {
		return expectDonateMoney;
	}

	public void setExpectDonateMoney(float expectDonateMoney) {
		this.expectDonateMoney = expectDonateMoney;
	}

	

	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getFoundation_id() {
		return foundation_id;
	}

	public void setFoundation_id(int foundation_id) {
		this.foundation_id = foundation_id;
	}


	public String getFoundation() {
		return foundation;
	}


	public void setFoundation(String foundation) {
		this.foundation = foundation;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
