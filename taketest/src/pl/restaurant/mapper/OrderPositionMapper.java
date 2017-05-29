package pl.restaurant.mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.restaurant.dao.DishDao;
import pl.restaurant.dto.OrderPositionDto;
import pl.restaurant.entities.Dish;
import pl.restaurant.entities.OrderPosition;

@Stateless
public class OrderPositionMapper implements Mapper<OrderPosition, OrderPositionDto> {

	@EJB
	private DishDao dishDao;
	
	@Override
	public OrderPositionDto getDto(OrderPosition entity) {
		OrderPositionDto dto = new OrderPositionDto();
		dto.setId(entity.getId());
		dto.setDishId(entity.getDish().getId());
		dto.setQuantity(entity.getQuantity());
		
		return dto;
	}

	@Override
	public OrderPosition getEntity(OrderPositionDto dto) {
		OrderPosition entity = new OrderPosition();
		entity.setId(dto.getId());
		entity.setQuantity(dto.getQuantity());
		
		Dish dish = dishDao.getById(dto.getDishId());
		entity.setDish(dish);
		
		return entity;
	}

}
