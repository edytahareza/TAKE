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

import pl.restaurant.dao.IngredientDao;
import pl.restaurant.entities.Ingredient;

@Path("/ingredient")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class IngredientResource {

	@EJB
	private IngredientDao ingredientDao;
	
    @GET
    @Path("/{id}")
    public Ingredient getIngredientById(@PathParam("id") int ingredientId) {
    	return ingredientDao.getById(ingredientId);
    }
   
    @GET
    @Path("/")
    public List<Ingredient> getAll() {
    	return ingredientDao.list();
    }
    
    @POST
    @Path("/")
    public Ingredient createIngredient(Ingredient ingredient) {
		ingredientDao.save(ingredient);
		return ingredient;
    }
      
    @DELETE
    @Path("/{id}")
    public void removeIngredient(@PathParam("id") int ingredientId) {
		Ingredient ingredientToRemove = ingredientDao.getById(ingredientId);
		ingredientDao.delete(ingredientToRemove);
    }
}
