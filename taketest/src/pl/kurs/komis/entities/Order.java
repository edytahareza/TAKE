package pl.kurs.komis.entities;

import java.util.Vector;
import javax.persistence.*;

@Entity
public class Order {
	@Id
	private int id;
	private int totalCost;
	public Client client;
	public Vector<Order_position> order_position = new Vector<Order_position>();

	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	public int getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(int aTotalCost) {
		this.totalCost = aTotalCost;
	}
}