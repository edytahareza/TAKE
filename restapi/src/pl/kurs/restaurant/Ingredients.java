package pl.kurs.restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ingredients {
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	public Ingredients(List<Ingredient> ingredients) {
		super();
		this.ingredients = ingredients;
	}

	public Ingredients() {	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	@Override
	public String toString() {
		 String tmp = "";
		 for ( Ingredient ing : ingredients) {
			 tmp += ing.toString() + "\n";
		 }
		 return tmp;
	}
	
}
