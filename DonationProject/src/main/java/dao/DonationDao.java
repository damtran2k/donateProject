package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Category;
import model.Donation;

public class DonationDao {
	Connection conn = null;
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	public static void main(String[] args) {
		DonationDao dao = new DonationDao();
		List<Donation> list = dao.getAllDonation();
		for (Donation donation : list) {
			System.out.println(donation.getId());
		}
	}
	
	// GET ALL Donation
		public List<Donation> getAllDonation() {
			List<Donation> list = new ArrayList<>();
			String query ="select * from userDonation\r\n"
					+ "LEFT JOIN MyUser\r\n"
					+ "ON userDonation.user_id = MyUser.id\r\n"
					+ "LEFT JOIN DonationDetail\r\n"
					+ "ON userDonation.donationDetail_id = DonationDetail.id";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Donation(rs.getInt(1), rs.getFloat(2), rs.getInt(4),
							rs.getInt(5),rs.getString(7),rs.getString(16), rs.getString(3)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		//GET TOTAL ITEM
		public int getTotalItems() {
			int totalItems =0;
			DonationDao dao = new DonationDao();
			List<Donation> list = dao.getAllDonation();
			for (Donation donation : list) {
				totalItems+=1;
			}
			return totalItems;
			
		}
		//PAGING
		public List<Donation> pagingDonation(int index,int amount) {
			List<Donation> list = new ArrayList<>();
			String query ="select * from userDonation\r\n"
					+ "LEFT JOIN MyUser\r\n"
					+ "ON userDonation.user_id = MyUser.id\r\n"
					+ "LEFT JOIN DonationDetail\r\n"
					+ "ON userDonation.donationDetail_id = DonationDetail.id\r\n"
					+ "order by userDonation.id\r\n"
					+ "offset ? rows fetch next ? rows only";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setInt(1, (index-1)*amount);
				ps.setInt(2, amount);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Donation(rs.getInt(1), rs.getFloat(2), rs.getInt(4),
							rs.getInt(5),rs.getString(7),rs.getString(16), rs.getString(3)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		//SEARCH
		public List<Donation> searchByUsername(String txtSearch) {
			List<Donation> list = new ArrayList<>();
			String query ="select * from userDonation\r\n"
					+ "LEFT JOIN MyUser\r\n"
					+ "ON userDonation.user_id = MyUser.id\r\n"
					+ "LEFT JOIN DonationDetail\r\n"
					+ "ON userDonation.donationDetail_id = DonationDetail.id\r\n"
					+ "where MyUser.username like ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, "%"+txtSearch+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Donation(rs.getInt(1), rs.getFloat(2), rs.getInt(4),
							rs.getInt(5),rs.getString(7),rs.getString(16), rs.getString(3)));				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public List<Donation> searchByFundname(String txtSearch) {
			List<Donation> list = new ArrayList<>();
			String query ="select * from userDonation\r\n"
					+ "LEFT JOIN MyUser\r\n"
					+ "ON userDonation.user_id = MyUser.id\r\n"
					+ "LEFT JOIN DonationDetail\r\n"
					+ "ON userDonation.donationDetail_id = DonationDetail.id\r\n"
					+ "where DonationDetail.fund_name like ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, "%"+txtSearch+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Donation(rs.getInt(1), rs.getFloat(2), rs.getInt(4),
							rs.getInt(5),rs.getString(7),rs.getString(16), rs.getString(3)));				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		

}
