package pl.restaurant.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pl.restaurant.entities.Ingredient;

@Stateless
public class IngredientDao extends AbstractDao<Ingredient>{

	public IngredientDao(){
		super(Ingredient.class);
	}

	@Override
	@Transactional
	public List<Ingredient> list() {
		 Query query = manager.createQuery("SELECT i FROM Ingredient i");
		 return query.getResultList();
	}
}
