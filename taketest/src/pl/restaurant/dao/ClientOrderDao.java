package pl.restaurant.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import pl.restaurant.entities.ClientOrder;

public class ClientOrderDao extends AbstractDao<ClientOrder> {

	public ClientOrderDao() {
		super(ClientOrder.class);
	}

	@Transactional
	@Override
	public List<ClientOrder> list() {
		 Query query = manager.createQuery("SELECT o FROM ClientOrder o");
		 return query.getResultList();
	}

}
