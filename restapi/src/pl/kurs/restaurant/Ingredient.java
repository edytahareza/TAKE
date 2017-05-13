package pl.kurs.restaurant;

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
	
	/*
	 * Eclipse marudzil zeby dodac to dodalem
	 */
	private static final long serialVersionUID = -4691354668841859142L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id")
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "type")
	int type;	

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