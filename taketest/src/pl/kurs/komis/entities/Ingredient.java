package pl.kurs.komis.entities;

import javax.persistence.*;

@Entity
public class Ingredient {
	@Id
	private int id;
	private String name;
	private int type;
	public Dish dish;

	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int aType) {
		this.type = aType;
	}
}