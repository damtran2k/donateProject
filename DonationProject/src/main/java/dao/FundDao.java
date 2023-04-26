package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import context.DBContext;
import model.Category;
import model.DonationDetailFund;
import model.Foundation;

public class FundDao {
	Connection conn = null;
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	

	// GET ALL CATEGORY
	public List<DonationDetailFund> getAllFund() {
		List<DonationDetailFund> list = new ArrayList<>();
			String query ="select * from DonationDetail\r\n"
					+ "LEFT OUTER join category\r\n"
					+ "on category_id = category.id\r\n"
					+ "LEFT OUTER join foundation\r\n"
					+ "on foundation_id = foundation.id";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(
			new DonationDetailFund(rs.getInt(1),rs.getString(2),rs.getString(3),
			rs.getString(4),rs.getString(5),rs.getString(7),rs.getFloat(6),
									rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(17),rs.getString(13)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	// GET ToTAL item
	public int getTotalItems() {

		int totalItems =0;
		FundDao dao = new FundDao();
		List<DonationDetailFund> list = dao.getAllFund();
		for (DonationDetailFund item : list) {
			totalItems+=1;
		}
		return totalItems;
		
	}
	//PAGING
		public List<DonationDetailFund> pagingFund(int index,int amount) {
			List<DonationDetailFund> list = new ArrayList<>();
			String query ="select * from DonationDetail\r\n"
					+ "LEFT OUTER join category\r\n"
					+ "on category_id = category.id\r\n"
					+ "LEFT OUTER join foundation\r\n"
					+ "on foundation_id = foundation.id\r\n"
					+ "order by DonationDetail.id\r\n"
					+ "offset ? rows fetch next ? rows only";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setInt(1, (index-1)*amount);
				ps.setInt(2, amount);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new DonationDetailFund(rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(7),rs.getFloat(6),
							rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(17),rs.getString(13)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	// SEARCH BY NAME
		public List<DonationDetailFund> searchFundByName(String txtSearch) {
			List<DonationDetailFund> list = new ArrayList<>();
			String query ="select * from DonationDetail\r\n"
					+ "LEFT OUTER join category\r\n"
					+ "on category_id = category.id\r\n"
					+ "LEFT OUTER join foundation\r\n"
					+ "on foundation_id = foundation.id\r\n"
					+ "where DonationDetail.fund_name like ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1,"%"+txtSearch+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new DonationDetailFund(rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(7),rs.getFloat(6),
							rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(17),rs.getString(13)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	// SEARCH BY CATEGORY NAME
		public List<DonationDetailFund> searchFundByCategory(String txtSearch) {
			List<DonationDetailFund> list = new ArrayList<>();
			String query ="select * from DonationDetail\r\n"
					+ "LEFT OUTER join category\r\n"
					+ "on category_id = category.id\r\n"
					+ "LEFT OUTER join foundation\r\n"
					+ "on foundation_id = foundation.id\r\n"
					+ "where category_name like ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1,"%"+txtSearch+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(
							new DonationDetailFund(rs.getInt(1),rs.getString(2),rs.getString(3),
									rs.getString(4),rs.getString(5),rs.getString(7),rs.getFloat(6),
									rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(17),rs.getString(13)));	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	// SEARCH BY FOUNDATION NAME
		public List<DonationDetailFund> searchFundByFoundation(String txtSearch) {
			List<DonationDetailFund> list = new ArrayList<>();
			String query ="select * from DonationDetail\r\n"
					+ "LEFT OUTER join category\r\n"
					+ "on category_id = category.id\r\n"
					+ "LEFT OUTER join foundation\r\n"
					+ "on foundation_id = foundation.id\r\n"
					+ "where foundation_name like ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1,"%"+txtSearch+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(
							new DonationDetailFund(rs.getInt(1),rs.getString(2),rs.getString(3),
									rs.getString(4),rs.getString(5),rs.getString(7),rs.getFloat(6),
									rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(13),rs.getString(17)));	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	//	DELETE
		public void deleteFund(String id) {
			String query = "delete from DonationDetail\r\n"
					+ "where id = ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, id);
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//INSERT
		public void insertFund(
				String name,String description,String content,
				String img,float expectMoney,String status,String startDate,String endDate,int categoryID,int foundationID) {
			try {
				String query = "INSERT INTO DonationDetail (id, fund_name, description, content, img_url, expectDonate_Money, fund_status, created_date, end_date, category_id, foundation_id)\r\n"
						+ "VALUES\r\n"
						+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				conn = new DBContext().getConnection();
				st = conn.createStatement();
				rs = st.executeQuery("SELECT TOP 1 id FROM DonationDetail ORDER BY id DESC");
				int id = 0;
				while (rs.next()) {
					id = rs.getInt("id");
				}
				id++;
				try {
					conn = new DBContext().getConnection();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				ps = conn.prepareStatement(query);
				ps.setString(1,id+"");
				ps.setString(2,name);
				ps.setString(3,description);
				ps.setString(4,content);
				ps.setString(5,img);
				ps.setFloat(6,expectMoney);
				ps.setString(7,status);
				ps.setString(8, startDate);
				ps.setString(9, endDate);
				ps.setInt(10, categoryID);
				ps.setInt(11, foundationID);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	// GET FUND BY ID
		public DonationDetailFund getFundByID(String id) {
			DonationDetailFund fund = new DonationDetailFund();
			String query ="select * from DonationDetail\r\n"
					+ "LEFT OUTER join category\r\n"
					+ "on category_id = category.id\r\n"
					+ "LEFT OUTER join foundation\r\n"
					+ "on foundation_id = foundation.id\r\n"
					+ "where DonationDetail.id = ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					fund.setId(rs.getInt(1));
					fund.setName(rs.getString(2));
					fund.setDescription(rs.getString(3));
					fund.setContent(rs.getString(4));
					fund.setImg_url(rs.getString(5));
					fund.setExpectDonateMoney(rs.getFloat(6));
					fund.setStatus(rs.getString(7));
					fund.setCreatedDate(rs.getString(8));
					fund.setEndDate(rs.getString(9));
					fund.setCategory_id(rs.getInt(10));
					fund.setFoundation_id(rs.getInt(11));
					fund.setCategory(rs.getString(17));
					fund.setFoundation(rs.getString(13));
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fund;
		}
		//UPDATE
		public void updateFund(String id,String name,
				String content, String des,String imgURL,String expectMoney,String status,String createdDate,String endDate,String categoryId,String foundationId) {
				String query ="update DonationDetail\r\n"
						+ "set fund_name = ?,\r\n"
						+ "description = ?,\r\n"
						+ "content = ?,\r\n"
						+ "img_url = ?,\r\n"
						+ "expectDonate_Money = ?,\r\n"
						+ "fund_status = ?,\r\n"
						+ "created_date = ?,\r\n"
						+ "end_date = ?,\r\n"
						+ "category_id = ?,\r\n"
						+ "foundation_id =?\r\n"
						+ "where id =?";
				try {
					conn = new DBContext().getConnection();
					ps = conn.prepareStatement(query);
					ps.setString(1, name);
					ps.setString(2, des);
					ps.setString(3, content);
					ps.setString(4, imgURL);
					ps.setString(5, expectMoney);
					ps.setString(6, status);
					ps.setString(7, createdDate);
					ps.setString(8, endDate);
					ps.setString(9, categoryId);
					ps.setString(10, foundationId);
					ps.setString(11, id);
					ps.executeUpdate();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		// GET ALL CATEGORY
		public List<DonationDetailFund> showListFundIndexPage() {
			List<DonationDetailFund> list = new ArrayList<>();
				String query ="select TOP 4 * from DonationDetail\r\n"
						+ "LEFT OUTER join category\r\n"
						+ "on category_id = category.id\r\n"
						+ "LEFT OUTER join foundation\r\n"
						+ "on foundation_id = foundation.id\r\n"
						+ "ORDER BY DonationDetail.id DESC;";
				try {
					conn = new DBContext().getConnection();
					ps = conn.prepareStatement(query);
					rs = ps.executeQuery();
					while (rs.next()) {
						list.add(
				new DonationDetailFund(rs.getInt(1),rs.getString(2),rs.getString(3),
				rs.getString(4),rs.getString(5),rs.getString(7),rs.getFloat(6),
										rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getString(17),rs.getString(13)));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
}




