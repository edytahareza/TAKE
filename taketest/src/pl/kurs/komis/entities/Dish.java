package pl.kurs.komis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish implements Serializable {
	
	// Variables
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id")
	private int id;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "orderPosition")
	public Vector<OrderPosition> orderPosition = new Vector<OrderPosition>();
	
	@Column(name = "ingredient")
	public Vector<Ingredient> ingredient = new Vector<Ingredient>();

	// Functions
	
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
	
	@Override
	public String toString() {
		return getId()+" "+getPrice()+" "+getType();
	}
}