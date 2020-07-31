package com.aia.mvc.order.model;

import java.util.List;

public class OrderCommand {
	private List<OrderItem> orderItem;
	private Address address;
	
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OrderCommand [orderItem=" + orderItem + "]";
	}

}
