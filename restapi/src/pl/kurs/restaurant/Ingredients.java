package pl.kurs.restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ingredients {
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	public Ingredients(List<Ingredient> cars) {
		super();
		this.ingredients = cars;
	}

	public Ingredients() {	}
	
	public List<Ingredient> getCars() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
}
