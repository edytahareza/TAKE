package pl.restaurant.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClientOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<OrderPosition> orderPosition = new ArrayList<OrderPosition>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrderPosition> getOrderPosition() {
		return orderPosition;
	}

	public void setOrderPosition(List<OrderPosition> orderPosition) {
		this.orderPosition = orderPosition;
	}
	
	public BigDecimal getPrice() {
		BigDecimal price = new BigDecimal(0);
		
		getOrderPosition().forEach(orderPosition -> {
			BigDecimal quantity = new BigDecimal(orderPosition.getQuantity());
			price.add(orderPosition.getDish().getPrice().multiply(quantity));
		});
		return price;
	}
}