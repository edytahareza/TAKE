package pl.kurs.komis.entities;

import java.math.BigDecimal;
import java.util.Vector;
import javax.persistence.*;

@Entity
public class Dish {
	@Id
	private int id;
	private BigDecimal price;
	private String type;
	public Vector<Order_position> order_position = new Vector<Order_position>();
	public Vector<Ingredient> ingredient = new Vector<Ingredient>();

	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal aPrice) {
		this.price = aPrice;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String aType) {
		this.type = aType;
	}
}