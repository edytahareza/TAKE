package pl.restaurant.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		
		return "Added client";
    }
    
    @GET
    @Path("/removeClient/{id}")
    public String removeClient(@PathParam("id") int clientId) {
		Client clientToRemove = clientDao.getById(clientId);
		clientDao.delete(clientToRemove);
		return "Removed client by id";
    }
    
   
    @GET
    @Path("/Clients")
    public List<Client> getAll() {
    	return clientDao.list();
    }
}
