package com.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static final String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
	                                                                                                            //1,2,3,4,5
	
	public static final String selectQuery = "select * from test.product where id = ?";
	                                                                              //1
	
	public static final String selectAllQuery = "select * from test.product";
	
	public static List<Product> findAll(){
		
		ArrayList<Product> productsList = new ArrayList<Product>();
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectAllQuery);
			
			while (resultSet.next()) {
				
				Product product = new Product();
				
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setDescription(resultSet.getString("description"));
				product.setQuantity(resultSet.getInt("quantity"));
				
				productsList.add(product);
				
			}
			
			connection.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return productsList;
		
	}
	
	public static Product findById(int id) {
		
		Product product = null;
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				product = new Product();
				
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setDescription(resultSet.getString("description"));
				product.setQuantity(resultSet.getInt("quantity"));
			}
			
			connection.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return product;
		
	}
	
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

		//add(new Product(65,"Celtos", 1000, 30, "Car"));
		
//		Product product = findById(2);
//		
//		System.out.println(product);
		
		List<Product> products = findAll();
		
		for (Product product : products) {
			System.out.println(product);
		}
		
	}

}
