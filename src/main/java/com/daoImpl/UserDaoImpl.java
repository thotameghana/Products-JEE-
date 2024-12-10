package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.MyConnector;
import com.dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao{
	private static Connection con;
	private static String fetchOne="select * from user where email=?";
	private static final String INSERT="insert into user(username,email,password,address) values(?,?,?,?)";
	static {
		con = MyConnector.connect();
	}
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
	public User fetchSpecific(String email) {
		try {
			pstmt=con.prepareStatement(fetchOne);
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				return new User(
						resultSet.getString("userName"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getString("address")
				);
						
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public int insert(User user) {
		try {
			pstmt=con.prepareStatement(INSERT);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getAddress());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
	
}
