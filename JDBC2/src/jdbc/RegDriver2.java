package jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Iterator;

public class RegDriver2 {

	public static void main(String[] args) {
		// 手動註冊
		System.setProperty("jdbc.drivers", "com.microsoft.sqlserver."
								+ "jdbc.SQLServerDriver");
		// Print Iterator
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		Iterator<Driver> driIter = drivers.asIterator();
		driIter.forEachRemaining(System.out::println);
		
		
		
		// 自動註冊
//		Enumeration<Driver> drivers = DriverManager.getDrivers();
//		Iterator<Driver> driIter = drivers.asIterator();
//		driIter.forEachRemaining(System.out::println);
		
		
		
	}

}
