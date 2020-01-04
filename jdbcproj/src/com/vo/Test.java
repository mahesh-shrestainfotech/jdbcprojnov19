package com.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	public static final String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
	                                                                                                            //1,2,3,4,5
	
	public static void add(Product product) {
		try {
		
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1,product.getId());
			preparedStatement.setString(2,product.getName());
			preparedStatement.setFloat(3,product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setInt(5,product.getQuantity());
			
			int noOfRows = preparedStatement.executeUpdate();
			
			if(noOfRows == 1) {
				System.out.println("Record added successfully");
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		add(new Product(65,"Celtos", 1000, 30, "Car"));
		
	}

}
