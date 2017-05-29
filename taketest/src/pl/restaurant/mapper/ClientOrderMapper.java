package pl.restaurant.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.restaurant.dto.ClientOrderDto;
import pl.restaurant.dto.OrderPositionDto;
import pl.restaurant.entities.ClientOrder;
import pl.restaurant.entities.OrderPosition;

@Stateless
public class ClientOrderMapper implements Mapper<ClientOrder, ClientOrderDto> {

	@EJB
	private OrderPositionMapper orderPositionMapper;
	
	@Override
	public ClientOrderDto getDto(ClientOrder entity) {
		ClientOrderDto dto = new ClientOrderDto();
		dto.setId(entity.getId());
		
		List<OrderPositionDto> orderPositionDtos = new ArrayList<>();
		
		entity.getOrderPosition().forEach(orderPosition -> {
			OrderPositionDto orderPositionDto = orderPositionMapper.getDto(orderPosition);
			orderPositionDtos.add(orderPositionDto);
		});
		dto.setOrderPositions(orderPositionDtos);	
		dto.setPrice(entity.getPrice());
		
		return dto;
	}

	@Override
	public ClientOrder getEntity(ClientOrderDto dto) {
		ClientOrder entity = new ClientOrder();
		entity.setId(dto.getId());
		
		List<OrderPosition> orderPositions = new ArrayList<>();
		
		dto.getOrderPositions().forEach(orderPositionDto -> {
			OrderPosition orderPosition = orderPositionMapper.getEntity(orderPositionDto);
			orderPositions.add(orderPosition);
		});
		entity.setOrderPosition(orderPositions);
		
		return entity;
	}

}
