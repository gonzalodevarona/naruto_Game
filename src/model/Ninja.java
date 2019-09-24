/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB III
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 22 SEPTEMBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/

package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ninja implements Serializable, Comparable<Ninja> {
	
	private String name;
	private GregorianCalendar creationDate;
	private String personality;
	private int power;
	private Ninja nextNinja;
	private Ninja priorNinja;
	private Jutsu firstJutsu;

	public Ninja(String name, GregorianCalendar creationDate, String personality, int power) {
		super();
		this.name = name;
		this.creationDate = creationDate;
		this.personality = personality;
		this.power = power;
		nextNinja = null;
		priorNinja = null;
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
	
	public Ninja getPriorNinja() {
		return priorNinja;
	}

	public void setPriorNinja(Ninja priorNinja) {
		this.priorNinja = priorNinja;
	}

	public Jutsu getLastJutsu() {
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
		boolean stop = false;
		
		while(match != null && !stop) {
			if (match.getName().equalsIgnoreCase(nameJutsu)) {
				stop = true;
			} else {match = match.getNext();
			}
			
		}
		
		return match;
	}
	
	public String date2String() {
		Calendar date = getCreationDate();
		int month = date.get(Calendar.MONTH) +1;
		int day = date.get(Calendar.DATE);
		int year = date.get(Calendar.YEAR);
		String dates = day+"/"+month+"/"+year;
		
		return dates;
	}
	
	public String toString() {
		String me = "\n";
		me += "Name: "+getName()+"\n";
		me += "Personality: "+getPersonality()+"\n";
		me += "Power: "+getPower()+"\n";
		me += "Creation date: "+date2String()+"\n";
		me += "\n";
		return me;
	}
	
	public void myNewNextIsTheNextOfMyActualNext() { // I HAVE A NOT NULL NEXT  NINJA AND ITS NEXT IS NOT NULL AS WELL
		this.nextNinja = nextNinja.getNextNinja();
	}
	
	public void myNewPriorIsPriorOfMyActualPrior() { // I HAVE A NOT NULL PRIOR  NINJA AND ITS PRIOR IS NOT NULL AS WELL
		this.priorNinja = priorNinja.getPriorNinja();
	}

	@Override
	public int compareTo(Ninja nin) {
		int value = 0;
		if (getName().compareTo(nin.getName()) > 0) {
			value = 1;
		} else if (getName().compareTo(nin.getName()) < 0) {
			value = -1;
		}
		return value;
	}
	
	public Jutsu findPrior(Jutsu actual) {
		Jutsu j = getFirstJutsu();
		Jutsu prior = null;
		boolean stop = false;
		
		while (j != null && !stop) {
			if (actual.getName().equalsIgnoreCase(j.getName())) {
				stop = true;
			} else{
				prior = j;
				j = j.getNext();
						
			}
			
		}
		return prior;
	}
	
	public void eraseJutsu(Jutsu j) {
		Jutsu prior = findPrior(j);
		if (prior != null) {
			prior.myNewNextIsTheNextOfMyActualNext();
		} else {
			if(j.getNext() != null) {
				setFirstJutsu(j.getNext());
			} else {
				setFirstJutsu(null);
			}
			
		}
	}
	
	public void addJutsu(Jutsu newJutsu) {
		if(getLastJutsu() == null) {
			setFirstJutsu(newJutsu);
		} else {getLastJutsu().setNext(newJutsu);}
		
	}

//	public String printJutsusOrganized() {
//		
//		jutsusSortedInsertion();
//		String everything = "";
//		
//		Jutsu match = getFirstJutsu();
//		
//		if (match == null) {
//			everything = "ERROR: There are 0 jutsus";
//		}
//		
//		while(match != null ) {
//			everything += match.toString();
//			
//			match = match.getNext();
//			
//			
//		}
//		
//		return everything;
//	}

//	public void jutsusSortedInsertion() {
//		
//		
//	}
	
	
	public Ninja clone() {
		Ninja other = new Ninja("", null, "", 0);
		
		other.setName(getName());
		other.setCreationDate(getCreationDate());
		other.setPersonality(getPersonality());
		other.setPower(getPower());
		other.setNextNinja(getNextNinja());
		other.setPriorNinja(getPriorNinja());
		other.setFirstJutsu(getFirstJutsu());
		
		
		
		return other;
	}
	
	
	

	
	
	
	

} //end of class
