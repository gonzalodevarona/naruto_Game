/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB III
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 15 SEPTEMBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/

package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Ninja implements Serializable {
	
	private String name;
	private GregorianCalendar creationDate;
	private String personality;
	private int power;
	private Ninja nextNinja;
	private Jutsu firstJutsu;

	public Ninja(String name, GregorianCalendar creationDate, String personality, int power) {
		super();
		this.name = name;
		this.creationDate = creationDate;
		this.personality = personality;
		this.power = power;
		nextNinja = null;
		firstJutsu = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GregorianCalendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(GregorianCalendar creationDate) {
		this.creationDate = creationDate;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	

	public Ninja getNextNinja() {
		return nextNinja;
	}

	public void setNextNinja(Ninja nextNinja) {
		this.nextNinja = nextNinja;
	}

	public Jutsu getFirstJutsu() {
		return firstJutsu;
	}

	public void setFirstJutsu(Jutsu firstJutsu) {
		this.firstJutsu = firstJutsu;
	}
	
	public Jutsu getLastJustu() {
		Jutsu last = getFirstJutsu();
		if(last != null) {
			while(last.getNext() != null) {
				last = last.getNext();
			}
		}
		return last;
	}
	
	public Jutsu locateJutsu(String nameJutsu) {
		Jutsu match = getFirstJutsu();
		
		while(match != null && match.getName().equalsIgnoreCase(nameJutsu)) {
			match = match.getNext();
		}
		
		return match;
	}
	
	
	
	

}
