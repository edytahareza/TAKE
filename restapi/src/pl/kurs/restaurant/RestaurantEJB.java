package pl.kurs.restaurant;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RestaurantEJB {
	
	@PersistenceContext(name="komis")
	EntityManager manager;

	
	public void create(Ingredient ing) {
		System.out.println("Creating car!");
		manager.persist(ing);
	}

	public void delete(int idi) {
		Ingredient ing = manager.find(Ingredient.class, idi);
		manager.remove(ing);
	}

	public List<Ingredient> findByName(String name) {
		Query q = manager.createQuery("select c from Ingredient ing where ing.name like :name");
		q.setParameter("name", name);//make
		@SuppressWarnings("unchecked")
		List<Ingredient> ing_list =q.getResultList();
		return ing_list;
	}

	public Ingredient find(int idi) {
		return manager.find(Ingredient.class, idi);
	}

	public List<Ingredient> get() {
		Query q = manager.createQuery("select * from Ingredient ing");
		@SuppressWarnings("unchecked")
		List<Ingredient> ing_list = q.getResultList();
		return ing_list;
	}

	public void update(Ingredient ingredient) {
		ingredient = manager.merge(ingredient);
	}

	
}
