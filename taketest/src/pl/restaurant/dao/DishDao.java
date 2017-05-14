package pl.restaurant.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pl.restaurant.entities.Dish;

@Stateless
public class DishDao extends AbstractDao<Dish> {

	public DishDao() {
		super(Dish.class);
	}

	@Override
	@Transactional
	public List<Dish> list() {
		 Query query = manager.createQuery("SELECT d FROM Dish d");
		 return query.getResultList();
	}

}
