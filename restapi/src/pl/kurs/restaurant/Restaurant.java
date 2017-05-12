package pl.kurs.restaurant;

import javax.ejb.Local;

@Local
public interface Restaurant {

	public abstract String create(Ingredient ingredient);

	public abstract Ingredient find(int idi);

	public abstract Ingredients get();

	public abstract String update(Ingredient ingredient);

	public abstract void delete(int idi);

}