package hust.shop.params;

import java.util.List;

import hust.shop.pojo.Orders;

public class OrderParam {

	private java.util.List<Orders> orders;
	private String orderNumber;
	private List<Integer> productIds;
	private List<Integer> productNumbers;
	private Integer shopId;
	private String address;
	private String telephone;
	private String recipient;
	private java.util.List<Integer> propertyValueIds;
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

//	public Orders getOrders() {
////		orders = new Orders();
////			orders.setProductId(2);
////			orders.setAddress("华中科技大学");
////			orders.setTelephone("13006106187");
//		return orders;
//	}
//
//	public void setOrders(Orders orders) {
//		this.orders = orders;
//	}

	public java.util.List<Integer> getPropertyValueIds() {
//		propertyValueIds = new java.util.ArrayList<Integer>();
//		propertyValueIds.add(3);
//		propertyValueIds.add(5);
		return propertyValueIds;
	}

	public void setPropertyValueIds(java.util.List<Integer> propertyValueIds) {
		this.propertyValueIds = propertyValueIds;
	}

	public java.util.List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(java.util.List<Orders> orders) {
		this.orders = orders;
	}

	public List<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}

	public List<Integer> getProductNumbers() {
		return productNumbers;
	}

	public void setProductNumbers(List<Integer> productNumbers) {
		this.productNumbers = productNumbers;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}
