package pl.kurs.komis.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	
	// Variables
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	int id;
	String name;
	String surname;
	String phone;
	String mail;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	List<ClientOrder> eqs = new ArrayList<ClientOrder>();
	
	//public Vector<ClientOrder> clientOrder = new Vector<ClientOrder>();

	// Functions
	
	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String aSurname) {
		this.surname = aSurname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String aPhone) {
		this.phone = aPhone;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String aMail) {
		this.mail = aMail;
	}
	
	@Override
	public String toString() {
		return getId()+" "+getName()+" "+getSurname();
	}
}