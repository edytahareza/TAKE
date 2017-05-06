package pl.kurs.komis.entities;

import javax.persistence.*;

@Entity
public class Order_position {
	private Integer orderQuantity;
	@Id
	public Order order;
	@Id
	public Dish dish;

	public Integer getOrderQuantity() {
		return this.orderQuantity;
	}

	public void setOrderQuantity(Integer aOrderQuantity) {
		this.orderQuantity = aOrderQuantity;
	}
}