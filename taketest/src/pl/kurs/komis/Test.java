package pl.kurs.komis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.kurs.komis.entities.*;

public class Test {
public static void main(String[] args) {
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("komis");
	EntityManager manager = managerFactory.createEntityManager(); 
	manager.getTransaction().begin();
	
	//Car car = new Car();
	//car.setMake("roflcopter");
	//manager.persist(car);
	
	// tworzenie klienta
	
	Client czeslaw = new Client();
	//czeslaw.setName(new String("mynewname"));
	//czeslaw.setMail(new String("heheheniewiem@rofl.rofl"));
	//czeslaw.setSurname(new String("nowitam"));
	
	// tworzenie zamowienia
	
	ClientOrder zamowienie = new ClientOrder();
	zamowienie.setPrice(100);
	//zamowienie.client = czeslaw;
	
	// tworzenie pozycji zamowienia
	
	OrderPosition pozycjaZamowienia = new OrderPosition();
	pozycjaZamowienia.setQuantity(new Integer(1));
	
	// tworzenie dania
	
	Dish pomidorowa = new Dish();
	Dish ziemniaczki = new Dish();
	//pomidorowa.setId(12);
	pomidorowa.setType(new String("Pomidorowa zupa"));
	
	// tworzenie skladnika
	
	Ingredient pomidor = new Ingredient();
	//pomidor.setId(13);
	pomidor.setName(new String("Pomidor"));
	pomidor.setType(new Integer(3));
	
	Ingredient kapusta = new Ingredient();
	kapusta.setName(new String("kapusta"));
	
	// dodawanie tego wszystkiego do siebie
	
	pomidor.dish = pomidorowa;
	
	
	pomidorowa.ingredient.addElement(kapusta);
	pozycjaZamowienia.dish = pomidorowa;
	pozycjaZamowienia.clientOrder = zamowienie;
	czeslaw.clientOrder.addElement(zamowienie);
	
	// Zapis w bazie

	manager.persist(pomidor);
	manager.persist(ziemniaczki);
	manager.persist(pomidorowa);
	manager.persist(zamowienie);
	manager.persist(pozycjaZamowienia);
	//manager.persist(czeslaw);
	
	
	
	manager.getTransaction().commit();
	manager.close();
	managerFactory.close();
	
}
}
