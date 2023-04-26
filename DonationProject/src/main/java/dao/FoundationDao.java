package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Foundation;

public class FoundationDao {
	Connection conn = null;
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		FoundationDao dao = new FoundationDao();
		List<Foundation> list = dao.getAllFoundation();
		for (Foundation foundation : list) {
			System.out.println(foundation.getName());
		}
		
	}
	// GET ALL
	public List<Foundation> getAllFoundation() {
		List<Foundation> list = new ArrayList<>();
		String query ="select * from foundation";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Foundation(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//GET TOTAL ITEM
	public int getTotalItems() {
				int totalItems =0;
				FoundationDao dao = new FoundationDao();
				List<Foundation> list = dao.getAllFoundation();
				for (Foundation category : list) {
					totalItems+=1;
				}
				return totalItems;
				
			}
	// delete 
	public void deleteFoundation(String id) {
		String query = "delete from foundation\r\n"
				+ "where id =?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//SEARCH
	public List<Foundation> searchFoundation(String txtSearch) {
		List<Foundation> list = new ArrayList<>();
		String query ="select * from foundation\r\n"
				+ "where foundation_name like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%"+txtSearch+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Foundation(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//PAGING
	public List<Foundation> pagingFoundation(int index,int amount) {
			List<Foundation> list = new ArrayList<>();
			String query ="select * from foundation\r\n"
					+ "order by id\r\n"
					+ "offset ? rows fetch next ? rows only";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setInt(1, (index-1)*amount);
				ps.setInt(2, amount);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Foundation(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	//INSERT
	public void insertFoundation(String name,String description,String status,String email) {
			try {
				Foundation found = new Foundation();
				String query = 
						"INSERT INTO foundation (id, foundation_name, foundation_des, email, foundation_status) VALUES\r\n"
						+ "(?, ?, ?, ?, ?)";
				conn = new DBContext().getConnection();
				st = conn.createStatement();
				rs = st.executeQuery("SELECT TOP 1 id FROM foundation ORDER BY id DESC");
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
				ps.setString(4,email);
				ps.setString(5,status);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	//GET ID
	public Foundation getFoundationById(String idSearch) {
			Foundation foundation = new Foundation();
			String query ="select * from foundation where id = ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, idSearch);
				rs = ps.executeQuery();
				while (rs.next()) {
					foundation.setId(rs.getInt(1));
					foundation.setName(rs.getString(2));
					foundation.setDescription(rs.getString(3));
					foundation.setEmail(rs.getString(4));
					foundation.setStatus(rs.getString(5));
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return foundation;
		}
		//UPDATE
	public void updateFoundation(String id,String name,String email, String des,String status) {
			String query ="update foundation\r\n"
					+ "set foundation_name = ?,\r\n"
					+ "email = ?,\r\n"
					+ "foundation_des = ?,\r\n"
					+ "foundation_status = ?\r\n"
					+ "where id = ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, des);
				ps.setString(4, status);
				ps.setString(5, id);
				ps.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	// ACTIVE FOUNDATION
	public List<Foundation> activeFoundation() {
		String active = "Active";
		List<Foundation> list = new ArrayList<>();
		String query ="select * from foundation\r\n"
				+ "where foundation_status = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, active);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Foundation(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Foundation getIdByName(String name ) {
		Foundation foundation = new Foundation();
		String query ="select * from foundation\r\n"
				+ "where foundation_name =?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				foundation.setId(rs.getInt(1));
				foundation.setName(rs.getString(2));
				foundation.setDescription(rs.getString(3));
				foundation.setEmail(rs.getString(4));
				foundation.setStatus(rs.getString(5));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundation;
	}
	
}
