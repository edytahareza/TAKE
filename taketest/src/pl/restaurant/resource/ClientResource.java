package pl.restaurant.resource;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import pl.restaurant.dao.ClientDao;
import pl.restaurant.entities.Client;

@Path("/client")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ClientResource {
	

	@EJB
	private ClientDao clientDao;
	
    @GET
    @Path("/createClient")
    public String createClient() {
		Client czeslaw = new Client();
		czeslaw.setName(new String("REST"));
		czeslaw.setMail(new String("test@rofl.rofl"));
		czeslaw.setSurname(new String("restdziala"));
		
		clientDao.save(czeslaw);
		
		return "REST dziala";
    }

}
