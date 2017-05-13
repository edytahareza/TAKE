package pl.kurs.komis.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class OrderPosition implements Serializable {

	@Column(name="quantity")
	private Integer quantity;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ManyToOne(fetch=FetchType.EAGER)
	public ClientOrder clientOrder;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ManyToOne(fetch=FetchType.EAGER)
	public Dish dish;

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