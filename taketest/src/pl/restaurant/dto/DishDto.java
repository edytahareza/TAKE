package pl.restaurant.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DishDto {

	private Integer id;
	
	private String name;
	
	private BigDecimal price;
	
	private String type;
	
	private List<Integer> ingredientIds = new ArrayList<Integer>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Integer> getIngredientIds() {
		return ingredientIds;
	}

	public void setIngredientIds(List<Integer> ingredientIds) {
		this.ingredientIds = ingredientIds;
	}
	
}
