package pl.kurs.komis.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ClientOrder implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	int id;
	@Column(name="price")
	int price;
	@ManyToOne(fetch=FetchType.EAGER)
	Client client;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	List<OrderPosition> orderPosition = new ArrayList<OrderPosition>();

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