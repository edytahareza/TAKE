package pl.restaurant.mapper;

public interface Mapper<T, V> {

	public V getDto(T entity);
	
	public T getEntity(V dto);
}
