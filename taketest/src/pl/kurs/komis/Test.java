package pl.kurs.komis;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pl.kurs.komis.entities.*;

public class Test {
public static void main(String[] args) {
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("restauracja");
	EntityManager manager = managerFactory.createEntityManager(); 
	EntityTransaction transaction = manager.getTransaction();
	
	transaction.begin();

	
	// tworzenie klienta
	Client czeslaw = new Client();
	czeslaw.setName(new String("mynewname"));
	czeslaw.setMail(new String("heheheniewiem@rofl.rofl"));
	czeslaw.setSurname(new String("nowitam"));
	manager.persist(czeslaw);
	
	Client malgorzata = new Client();
	malgorzata.setName(new String("Ma³gorzata"));
	malgorzata.setMail(new String("nowakMalgorzata@wp.pl"));
	malgorzata.setSurname(new String("Nowak"));
	malgorzata.setPhone("581258400");
	manager.persist(malgorzata);
	
	// tworzenie zamowienia
	ClientOrder order = new ClientOrder();
	order.setPrice(100);
	
	manager.persist(order);

	// tworzenie skladnikow
	Ingredient tomato = new Ingredient();
	tomato.setName(new String("Pomidor"));
	tomato.setType(3);
	manager.persist(tomato);
	
	Ingredient pasta = new Ingredient();
	pasta.setName(new String("Makaron"));
	pasta.setType(1);
	manager.persist(pasta);
	
	Ingredient strawberry = new Ingredient();
	strawberry.setName(new String("Truskawka"));
	strawberry.setType(2);
	manager.persist(strawberry);
	
	// tworzenie dania
	Dish tomatoSoup = new Dish();
	tomatoSoup.setName("Zupa pomidorowa");
	tomatoSoup.setType("Zupa");
	tomatoSoup.setPrice(new BigDecimal(3));
	tomatoSoup.getIngredients().add(tomato);
	manager.persist(tomatoSoup);
	
	Dish carbonara = new Dish();
	carbonara.setName("Spaghetti carbonara");
	carbonara.setType("Makaron");
	carbonara.setPrice(new BigDecimal(10));
	carbonara.getIngredients().add(pasta);
	manager.persist(carbonara);


	
	// tworzenie pozycji zamowienia
	//OrderPosition orderPosition = new OrderPosition();
	//orderPosition.setQuantity(new Integer(1));
	//orderPosition.dish(pomidorowa)
	
	
	
	// dodawanie tego wszystkiego do siebie
	
	//pomidor.dish = pomidorowa;
	
	
	//pomidorowa.ingredient.addElement(kapusta);
	//pozycjaZamowienia.dish = pomidorowa;
	//pozycjaZamowienia.clientOrder = zamowienie;
	//czeslaw.clientOrder.addElement(zamowienie);
	
	// Zapis w bazie

	
	//manager.persist(ziemniaczki);
	//manager.persist(pomidorowa);
	
	//manager.persist(pozycjaZamowienia);

	
	
	
	transaction.commit();
	manager.close();
	managerFactory.close();
	
}
}
