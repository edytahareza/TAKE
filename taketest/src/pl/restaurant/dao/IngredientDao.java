package pl.restaurant.dao;

import java.util.List;
import java.util.Set;

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
	
	@Transactional
	public List<Ingredient> getByIds(Set<Integer> ingredientIds) {
		 Query query = manager.createQuery("SELECT i FROM Ingredient i WHERE i.id IN :ids");
		 
		 query.setParameter("ids", ingredientIds);
		 
		 return query.getResultList();
	}
}
