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

import pl.restaurant.dao.DishDao;
import pl.restaurant.dto.DishDto;
import pl.restaurant.entities.Dish;
import pl.restaurant.mapper.DishMapper;

@Path("/dish")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class DishResource {
	
	@EJB
	private DishMapper dishMapper;

	@EJB
	private DishDao dishDao;
	
    @POST
    @Path("/")
    public Dish createDish(DishDto dishDto) {
    	Dish dish = dishMapper.getEntity(dishDto);
    	dishDao.update(dish);
		return dish;
    }
    
    @DELETE
    @Path("/{id}")
    public String removeDish(@PathParam("id") int dishId) {
    	Dish dishToRemove = dishDao.getById(dishId);
		dishDao.delete(dishToRemove);
		return "Removed dish by id";
    }
    
    @GET
    public List<Dish> getAll() {
    	return dishDao.list();
    }
}
