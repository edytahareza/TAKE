package pl.kurs.restaurant;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/komis")
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
	public String create(Car car) {
		bean.create(car);
		return "car created!";
	}

	@Override
	@GET
	@Path("/find/{idc}")
	public Car find(@PathParam("idc") int idc) {
		Car car = bean.find(idc);
		return car;
	}

	@Override
	@GET
	@Path("/get")
	public Cars get() {
		List<Car> lcars = bean.get();
		Cars cars = new Cars(lcars);
		return cars;
	}

	@Override
	@POST
	@Path("/update")
	public String update(Car car) {
		try {
			bean.update(car);
			return "car updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "car not updated :(";
		}
	}


	@Override
	@GET
	@Path("/delete/{idc}")
	public void delete(@PathParam("idc") int idc) {
		bean.delete(idc);
	}


}
