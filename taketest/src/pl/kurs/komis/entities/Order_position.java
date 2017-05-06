package pl.kurs.komis.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Order_position implements Serializable {
	
	// Variables
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@ManyToOne(fetch=FetchType.EAGER)
	public Order_ order;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@ManyToOne(fetch=FetchType.EAGER)
	public Dish dish;

	// Functions
	
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer aQuantity) {
		this.quantity = aQuantity;
	}
	
	@Override
	public String toString() {
		return getQuantity()+" lubie placki";
	}
}