package pl.restaurant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class AbstractDao<T> {

    private final Class<T> classType;
    
	@PersistenceContext(name="restauracja")
	protected EntityManager manager;
	
	protected AbstractDao (Class<T> classType) {
		this.classType = classType;
	}

	@Transactional
    public void save(T t) {
		manager.persist(t);
    }

	@Transactional
    public void update(T t) {
		manager.merge(t);
    }

	@Transactional
    public void delete(T t) {
       manager.remove(t);
    }

	@Transactional
    public abstract List<T> list();

	@Transactional
    public T getById(Integer id) {
		return manager.find(classType, id);
    }
}