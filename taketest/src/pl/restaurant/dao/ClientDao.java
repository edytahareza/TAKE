package pl.restaurant.dao;

import java.util.List;

import javax.ejb.Stateless;

import pl.kurs.komis.entities.Client;

@Stateless
public class ClientDao extends AbstractDao<Client> {

	public ClientDao() {
		super(Client.class);
	}

	@Override
	public List<Client> list() {
		return null;
	}

}
