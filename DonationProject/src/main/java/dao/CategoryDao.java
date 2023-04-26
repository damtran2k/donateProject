package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import context.DBContext;
import model.Category;




public class CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		CategoryDao dao = new CategoryDao();
		dao.deleteCategory("61");
	}
	// GET ALL CATEGORY
	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String query ="select * from category";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//GET TOTAL ITEM
	public int getTotalItems() {
		int totalItems =0;
		CategoryDao dao = new CategoryDao();
		List<Category> list = dao.getAllCategory();
		for (Category category : list) {
			totalItems+=1;
		}
		return totalItems;
		
	}
	//PAGING
	public List<Category> pagingCategory(int index,int amount) {
		List<Category> list = new ArrayList<>();
		String query ="select * from category\r\n"
				+ "order by id\r\n"
				+ "offset ? rows fetch next ? rows only";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*amount);
			ps.setInt(2, amount);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//SEARCH
	public List<Category> searchCategory(String txtSearch) {
		List<Category> list = new ArrayList<>();
		String query ="select * from category\r\n"
				+ "where category_name like ?\r\n"
				+ "or category_status like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%"+txtSearch+"%");
			ps.setString(2,"%"+txtSearch+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//DELETE
	public void deleteCategory(String id) {
		String query = "delete from category\r\n"
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
	public void insertCategory(String name,String description,String status) {
		try {
			Category category = new Category();
			String query = "INSERT INTO category (id, category_name, category_des, category_status) VALUES\r\n"
					+ "(?, ?, ?, ?)";
			conn = new DBContext().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT TOP 1 id FROM category ORDER BY id DESC");
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
			ps.setString(4,status);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	// GET ID
	public Category getCategoryById(String idSearch) {
		Category category = new Category();
		String query ="select * from category where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idSearch);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setDescription(rs.getString(3));
				category.setStatus(rs.getString(4));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	//UPDATE
	public void updateCategory(String id,String name, String des,String status) {
		String query ="update category\r\n"
				+ "set category_name = ?,\r\n"
				+ " category_des = ?,\r\n"
				+ " category_status = ?\r\n"
				+ "where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, des);
			ps.setString(3, status);
			ps.setString(4, id);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// ACTIVE CATEGORY
	public List<Category> activeCategory() {
		String active = "Active";
		List<Category> list = new ArrayList<>();
		String query ="select * from category\r\n"
				+ "where category_status = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, active);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Category getIdByName(String name ) {
		Category category = new Category();
		String query ="select * from category\r\n"
				+ "where category_name =?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setDescription(rs.getString(3));
				category.setStatus(rs.getString(4));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	
	
}
