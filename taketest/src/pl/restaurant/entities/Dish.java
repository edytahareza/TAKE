package pl.restaurant.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Dish implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "price")
	BigDecimal price;
	
	@Column(name = "type")
	String type;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Dish_Ingredient", 
		joinColumns = @JoinColumn(name = "dish_id"), 
		inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	List<Ingredient> ingredients = new ArrayList<Ingredient>();

	
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
	
	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return getId()+" "+getPrice()+" "+getType();
	}
	
	
}