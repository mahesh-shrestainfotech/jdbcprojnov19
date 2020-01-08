package com.vo;

public class Order {
	
	private int id;
	private int productId;
	private int orderedQuantity;
	private String comments;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int productId, int orderedQuantity, String comments) {
		super();
		this.id = id;
		this.productId = productId;
		this.orderedQuantity = orderedQuantity;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
