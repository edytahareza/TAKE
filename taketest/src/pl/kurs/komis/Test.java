package pl.kurs.komis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.kurs.komis.entities.Car;
import pl.kurs.komis.entities.*;

public class Test {
public static void main(String[] args) {
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("restauracja");
	EntityManager manager = managerFactory.createEntityManager(); 
	manager.getTransaction().begin();
	
	//Car car = new Car();
	//car.setMake("Fiat");
	//manager.persist(car);
	
	//Clients client = new Clients();
	//client.setName(new String("mynewname"));
	//manager.persist(client);
	
	
	manager.getTransaction().commit();
	manager.close();
	managerFactory.close();
	
}
}
