package pl.restaurant.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.restaurant.dao.IngredientDao;
import pl.restaurant.dto.DishDto;
import pl.restaurant.entities.Dish;
import pl.restaurant.entities.Ingredient;

@Stateless
public class DishMapper implements Mapper<Dish, DishDto> {

	@EJB
	private IngredientDao ingredientDao;
	
	@Override
	public DishDto getDto(Dish entity) {
		DishDto dto = new DishDto();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setType(entity.getType());
		
		List<Integer> ingredientsIds = getIngredientIds(entity.getIngredients());
		dto.setIngredientIds(ingredientsIds);
		
		return dto;
	}

	@Override
	public Dish getEntity(DishDto dto) {
		Dish dish = new Dish();
		
		dish.setId(dto.getId());
		dish.setName(dto.getName());
		dish.setPrice(dto.getPrice());
		dish.setType(dto.getType());
		
		List<Ingredient> ingredients = getIngredients(dto.getIngredientIds());
		dish.setIngredients(ingredients);
		
		return dish;
	}
	
	private List<Integer> getIngredientIds(List<Ingredient> ingredients) {
		List<Integer> ids = new ArrayList<Integer>();
		
		for (Ingredient ingredient : ingredients) {
			ids.add(ingredient.getId());
		}	
		return ids;
	}
	
	private List<Ingredient> getIngredients(List<Integer> ingredientIds) {
		return ingredientDao.getByIds(new HashSet<Integer>(ingredientIds));
	}
}
