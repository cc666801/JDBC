package jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;

public class ReDriver3 {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Print Iterator
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		Iterator<Driver> driIter = drivers.asIterator();
		driIter.forEachRemaining(System.out::println);
	}
}
