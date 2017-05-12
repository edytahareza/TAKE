package pl.kurs.restaurant;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/restaurant")
//@Consumes({ "application/json" })
//@Produces({ "application/json" })

@Consumes({ "application/xml" })
@Produces({ "application/xml" })

public class RestaurantREST implements Restaurant {

	@EJB
	RestaurantEJB bean;

	@Override
	@POST
	@Path("/create")
	public String create(Ingredient ingredient) {
		bean.create(ingredient);
		return "ingredient created!";
	}

	@Override
	@GET
	@Path("/find/{idi}")
	public Ingredient find(@PathParam("idi") int idi) {
		Ingredient ingredient = bean.find(idi);
		return ingredient;
	}

	@Override
	@GET
	@Path("/get")
	public Ingredients get() {
		List<Ingredient> allIngList = bean.get();
		Ingredients ings = new Ingredients(allIngList);
		return ings;
	}

	@Override
	@POST
	@Path("/update")
	public String update(Ingredient ing) {
		try {
			bean.update(ing);
			return "Ingredient updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Ingredient not updated :(";
		}
	}


	@Override
	@GET
	@Path("/delete/{idi}")
	public void delete(@PathParam("idi") int idi) {
		bean.delete(idi);
	}


}
