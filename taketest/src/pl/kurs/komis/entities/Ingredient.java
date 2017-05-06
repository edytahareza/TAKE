package pl.kurs.komis.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient implements Serializable {
	
	// Variables
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private int type;	//czemu tu byl int? nie ma byc string?
	
	@ManyToOne(fetch=FetchType.EAGER)
	public Dish _dish;

	// Functions
	
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
	
	@Override
	public String toString() {
		return getId()+" "+getName()+" "+getType();
	}
}