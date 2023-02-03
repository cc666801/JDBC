package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connectUtil.connectionFactory;

public class ConnFactoryTest {

	public static void main(String[] args) {
		connectionFactory connF = new connectionFactory();
		String lastname = JOptionPane.showInputDialog("LastName");
		String firstname = JOptionPane.showInputDialog("FirstName");
		// Choose the field in a table
		String sql = "SELECT [EmployeeID]\r\n"
				+ "      ,[LastName]\r\n"
				+ "      ,[FirstName]\r\n"
				// ''跟SQL 指令有關
				+ "  FROM [dbo].[Employees] where Lastname=? and FirstName = ?";
		try {
			Connection conn = connF.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lastname);
			pstmt.setString(2, firstname);
			ResultSet rs = pstmt.executeQuery();
			
			
			
			
			
			// Use connection to write statement
//			Statement stmt = conn.createStatement();
			// Save data to a Set call ResultSet
//			ResultSet rs = stmt.executeQuery(sql);
			// first is 0 -> no data, should use next to 1 
			
			while (rs.next()) {
				System.out.printf("%3s  %10s  %10s %n", rs.getString(1), 
														rs.getString(2), 
														rs.getString(3));
			}
			System.out.println("OK");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
