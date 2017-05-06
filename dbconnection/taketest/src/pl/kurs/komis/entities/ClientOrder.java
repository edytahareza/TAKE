package pl.kurs.komis.entities;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClientOrder implements Serializable {
	
	// Variables
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	@Column(name="price")
	private int price;

	@ManyToOne(fetch=FetchType.EAGER)
	public Client client;
	
	public Vector<OrderPosition> orderPosition = new Vector<OrderPosition>();

	// Functions
	
	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int aPrice) {
		this.price = aPrice;
	}
	
	@Override
	public String toString() {
		return getId()+" "+getPrice()+" Client no: "+client.getId();
	}
}