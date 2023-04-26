package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import bean.User;
import context.DBContext;
import model.Category;
import util.Email;
import util.Encrypt;

public class UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;
	public static void main(String[] args) throws SQLException {
		UserDao dao = new UserDao();
		dao.changePassword("johnsmith", "user");
		System.out.println("a".equals("b"));
		
		
		
		
		
		
	
	}
	// GET LIST USER
	public List<User> getAllUser() {
		List<User> list = new ArrayList<>();
		String query ="select * from MyUser";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(7),
						rs.getString(8),rs.getString(6),rs.getString(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//GET TOTAL ITEM
		public int getTotalItems() {
			int totalItems =0;
			UserDao dao = new UserDao();
			List<User> list = dao.getAllUser();
			for (User category : list) {
				totalItems+=1;
			}
			return totalItems;
			
		}
	//PAGING
		public List<User> pagingUser(int index,int amount) {
			List<User> list = new ArrayList<>();
			String query ="select * from MyUser\r\n"
					+ "order by id\r\n"
					+ "offset ? rows fetch next ? rows only";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setInt(1, (index-1)*amount);
				ps.setInt(2, amount);
				rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(7),
							rs.getString(8),rs.getString(6),rs.getString(9)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	// SEARCH USER
	public List<User> searchUser(String txtSearch) {
		List<User> list = new ArrayList<>();
		String query ="select * from MyUser\r\n"
				+ "where username like ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%"+txtSearch+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(7),
						rs.getString(8),rs.getString(6),rs.getString(9)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void deleteUser(String id) {
		String query = "delete from MyUser\r\n"
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
	//UPDATE
		public void updateInforUser(String id,String role, String fullname,String phone, String address,String status) {
			String query ="update MyUser\r\n"
					+ "set role = ?,\r\n"
					+ "fullname = ?,\r\n"
					+ "phone = ?,\r\n"
					+ "address = ?,\r\n"
					+ "status  = ?\r\n"
					+ "where id = ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, role);
				ps.setString(2, fullname);
				ps.setString(3, phone);
				ps.setString(4, address);
				ps.setString(5, status);
				ps.setString(6, id);
				ps.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	//CHECK LOGIN
	public boolean checkLogin(String username,String password) {
		boolean result = false;
		// encrypt
		password = new Encrypt().encryptPassword(password);
		try {
			String query ="select COUNT(*) from MyUser\r\n"
					+ "where username = ? and password = ?\r\n"
					+ "and status ='Active'";
			try {
				conn = new DBContext().getConnection();
			} catch (Exception e) {
				System.out.println("cant not database 2");
				e.printStackTrace();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count>0) {
				result = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
				
			}
	
	public void signUp(String username,String password,String email,String fullname,String phone,String address) {
		// ENCRYPT PASSWORD
		Encrypt encrypt = new Encrypt();
		 password = encrypt.encryptPassword(password);
		try {
			String query ="INSERT INTO MyUser (id, username, password, role, fullname, phone, email, address, status) VALUES\r\n"
					+ "(?, ?, ?, 'user', ?, ?, ?, ?, 'NonActive')";
			conn = new DBContext().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT TOP 1 id FROM MyUser ORDER BY id DESC");
			int id = 0;
			while (rs.next()) {
				id = rs.getInt("id");
				
			}
			id+=1;
			try {
				conn = new DBContext().getConnection();
			} catch (Exception e) {
				System.out.println("cant not database 2");
				e.printStackTrace();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, id+"");
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, fullname);
			ps.setString(5, phone);
			ps.setString(6, email);
			ps.setString(7, address);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ADD USER FROM ADMIN
	public void addUserFromAdmin(String username,String password,String role,
			String email,String fullname,String phone,String address,String status) {
		// ENCRYPT PASSWORD
		Encrypt encrypt = new Encrypt();
		 password = encrypt.encryptPassword(password);
		try {
			String query ="INSERT INTO MyUser (id, username, password, role, fullname, phone, email, address, status) VALUES\r\n"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = new DBContext().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT TOP 1 id FROM MyUser ORDER BY id DESC");
			int id = 0;
			while (rs.next()) {
				id = rs.getInt("id");
				
			}
			id+=1;
			try {
				conn = new DBContext().getConnection();
			} catch (Exception e) {
				System.out.println("cant not database 2");
				e.printStackTrace();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, id+"");
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, role);
			ps.setString(5, fullname);
			ps.setString(6, phone);
			ps.setString(7, email);
			ps.setString(8, address);
			ps.setString(9, status);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// GET INFOR USER 
	public User getInfor(String username) {
		User user = new User();
		String query ="select * from MyUser\r\n"
				+ "where username =?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setName(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setStatus(rs.getString(9));
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	public User getInforById(String id) {
		User user = new User();
		String query ="select * from MyUser\r\n"
				+ "where id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setName(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setStatus(rs.getString(9));
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
	// CHECK EMAIL
	public boolean checkEmailExits(String email) {
		boolean exists = false;
		try {
			String query ="SELECT COUNT(*) FROM MyUser\r\n"
					+ "WHERE email = ?";
			try {
				conn = new DBContext().getConnection();
			} catch (Exception e) {
				System.out.println("cant not database 2");
				e.printStackTrace();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs=ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count>0) {
				exists = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
	// CHECK USERNAME
	public boolean checkUserNameExits(String userName) {
		boolean exists = false;
		try {
			String query ="SELECT COUNT(*) FROM MyUser\r\n"
					+ "WHERE username = ?";
			try {
				conn = new DBContext().getConnection();
			} catch (Exception e) {
				System.out.println("cant not database 2");
				e.printStackTrace();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count>0) {
				exists = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	
	}
	// VERIFY ACCOUNT
	public void verifyAccount(String username) {
		String query ="update MyUser\r\n"
				+ "set status = 'Active'\r\n"
				+ "where username =?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// FORGET PASSWORD
	public String forgetPassword(String email) {
		String query ="update MyUser\r\n"
				+ "set password = ?\r\n"
				+ "where email= ?";
		// Ccreat random string
		String newPassword = UUID.randomUUID().toString().substring(0, 8);
		// ENCRYPT RANDOM STRING
		Encrypt encrypt = new Encrypt();
		 String enCryptPassword = encrypt.encryptPassword(newPassword);
		 try {
			 conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, enCryptPassword);
				ps.setString(2, email);
				ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPassword;
	}
	//CHANGE PASSWORD
	public void changePassword(String username,String newPassword) {
				String query ="update MyUser\r\n"
						+ "set password = ?\r\n"
						+ "where username = ?";
				Encrypt encrypt = new Encrypt();
				newPassword = encrypt.encryptPassword(newPassword);
				try {
					conn = new DBContext().getConnection();
					ps = conn.prepareStatement(query);
					ps.setString(1, newPassword);
					ps.setString(2, username);
					ps.executeUpdate();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
	}

		

	
	
	
}
