package UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.User;
import connectionUtil.ConnectionFactory;

public class UserDataAccessObject implements InterfaceUserDAO {

	//C
	@Override
	public boolean createUser(User user) {
		String sql = "insert into [UserAccount] (id, account, pwd) "
				+ "values (?, ?, ?)";
		ConnectionFactory connFactory = new ConnectionFactory();
		try {
			Connection conn = connFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getAccount());
			pstmt.setString(3, user.getPwd());
			int updateCount = pstmt.executeUpdate();
			if (updateCount <1) {
				return false;
			}
			else {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//R
	@Override
	public User findUserById(int id) {
		String sql = "select id, account, pwd from [UserAccount] where id=?";
		ConnectionFactory connFactory = new ConnectionFactory();
		try(Connection conn = connFactory.getConnection();) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			// 移動到cursor1
			rs.next();
			// Put cursor1 data to new a User
			User user = new User();
			user.setId(rs.getInt(1));
			user.setAccount(rs.getString(2));
			user.setPwd(rs.getString(3));
			return user;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<User> findAllUser() {
		return null;
	}
	
	//U
	@Override
	public boolean updateUser(User user) {
		return false;
	}
	
	//D
	@Override
	public boolean deleteUserById(int id) {
		return false;
	}
}
