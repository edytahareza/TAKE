package pl.restaurant.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientOrderDto {

	private Integer id;
	
	private List<OrderPositionDto> orderPositions = new ArrayList<OrderPositionDto>();

	private BigDecimal price;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrderPositionDto> getOrderPositions() {
		return orderPositions;
	}

	public void setOrderPositions(List<OrderPositionDto> orderPositions) {
		this.orderPositions = orderPositions;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
