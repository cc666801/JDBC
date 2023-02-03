package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectUtil.connectionFactory;

public class ExecuteUpdateDemo {

	public static void main(String[] args) {
		// SQL 指令insert
		String sql = "insert into [t2].dbo.student values "
					+ "(?, ?, ?, ?, ?, ?)";
		// SQL 指令create
		String sql1 = "Create table Errrr "
				+ "(id int primary key not null, "
				+ "username nvarchar(30) not null, "
				+ "pwd nvarchar(30) not null)";
		// SQL 指令select
		String sql2 = "Select [EmployeeID], [LastName], [FirstName]"
				+ " From [dbo].[Employees] ";
		
		// New a connectionFactory
		connectionFactory connectionFactory = new connectionFactory();
		// Use getConnection() to save values conn 
		try(Connection conn = connectionFactory.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "s181");
			pstmt.setString(2, "ㄟ");
			pstmt.setString(3, "EE");
			pstmt.setString(4, "m");
			pstmt.setString(5, "0912123123");
			pstmt.setString(6, "1987-6-5");
//			ResultSet rs = pstmt.executeQuery();
			int updateCount = pstmt.executeUpdate();
			System.out.println("新增了" + updateCount + "筆資料");
		}catch (SQLException e) {
		e.printStackTrace();
		}
	}
}

		
			
//			// 向SQL Server 下 sql 這個指令
//			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			ResultSet rs = stmt.executeQuery(sql2);
//			// 是否有ResultSet
//			boolean execute = stmt.execute(sql2);
//			System.out.println("是否有ResultSet" + execute);
//			// 有的話把ResultSet印出來
//			if(true) {
//				while (rs.next()) {
//					System.out.printf("%3s  %10s  %10s %n", rs.getString(1), rs.getString(2), rs.getString(3));
//				}
//			}
//			else {
//				// 新增了 updateCount 筆資料
//				int updateCount = stmt.executeUpdate(sql);
//				System.out.println("新增了" + updateCount + "筆資料");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
