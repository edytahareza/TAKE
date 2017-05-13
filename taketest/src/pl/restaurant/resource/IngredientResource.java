package pl.restaurant.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pl.restaurant.dao.IngredientDao;
import pl.restaurant.entities.Client;
import pl.restaurant.entities.Ingredient;

@Path("/ingredient")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class IngredientResource {

	@EJB
	private IngredientDao ingredientDao;
	
    @GET
    @Path("/createIngredient")
    public String createIngredient() {
		Ingredient ingredient = new Ingredient ();
		ingredient.setName("testIngredient");
		ingredient.setType(1);
		ingredientDao.save(ingredient);
		
		return "Added ingredient";
    }
    
    @GET
    @Path("/removeIngredient/{id}")
    public String removeIngredient(@PathParam("id") int ingredientId) {
    	Ingredient ingredientToRemove = ingredientDao.getById(ingredientId);
    	ingredientDao.delete(ingredientToRemove);
		return "Removed ingredient by id";
    }
    
    @GET
    @Path("/Ingredients")
    public List<Ingredient> getAll() {
    	return ingredientDao.list();
    }
    
}
