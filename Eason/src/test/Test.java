package test;

import Bean.User;
import UserDAO.UserDataAccessObject;

public class Test {

	public static void main(String[] args) {
		// 單元測試
		UserDataAccessObject userDAO = new UserDataAccessObject();
		
		User user = new User();
		user.setId(3);
		user.setAccount("a323");
		user.setPwd("456");
		userDAO.createUser(user);
		
		System.out.printf("%3s %8s %8s %n", 
				userDAO.findUserById(3).getId(), 
				userDAO.findUserById(3).getAccount(), 
				userDAO.findUserById(3).getPwd());

	}

}
