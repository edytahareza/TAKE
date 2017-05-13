package pl.restaurant.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pl.restaurant.entities.Client;

@Stateless
public class ClientDao extends AbstractDao<Client> {

	public ClientDao() {
		super(Client.class);
	}

	@Override
	@Transactional
	public List<Client> list() {
		 Query query = manager.createQuery("SELECT c FROM Client c");
		 return query.getResultList();
	}

}
