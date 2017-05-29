package pl.restaurant.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pl.restaurant.dao.ClientOrderDao;
import pl.restaurant.dto.ClientOrderDto;
import pl.restaurant.entities.ClientOrder;
import pl.restaurant.mapper.ClientOrderMapper;

@Path("/order")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ClientOrderResource {
	
	@EJB
	private ClientOrderMapper orderMapper;
	
	@EJB
	private ClientOrderDao orderDao;
	
    @GET
    @Path("/{id}")
    public ClientOrderDto getOrderById(@PathParam("id") int orderId) {
    	ClientOrder order = orderDao.getById(orderId);
    	return orderMapper.getDto(order);
    }
   
    @GET
    @Path("/")
    public List<ClientOrder> getAll() {
    	return orderDao.list();
    }
    
    @POST
    @Path("/")
    public ClientOrderDto createOrder(ClientOrderDto orderDto) {
    	ClientOrder order = orderMapper.getEntity(orderDto);
		orderDao.save(order);
		return orderMapper.getDto(order);
    }
      
    @DELETE
    @Path("/{id}")
    public void removeOrder(@PathParam("id") int orderId) {
		ClientOrder orderToRemove = orderDao.getById(orderId);
		orderDao.delete(orderToRemove);
    }

}
