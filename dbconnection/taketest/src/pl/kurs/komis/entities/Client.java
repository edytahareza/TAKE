package pl.kurs.komis.entities;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {
	
	// Variables
	
	@Id
	private int id;
	
	private String name;
	
	private String surname;
	
	private String phone;
	
	private String mail;
	
	public Vector<ClientOrder> clientOrder = new Vector<ClientOrder>();

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