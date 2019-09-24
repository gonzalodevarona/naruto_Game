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
import java.util.GregorianCalendar;

public class Clan implements Serializable, Comparable<Clan> {
	
	private String name;
	private Ninja first;
	private Clan nextClan;
	private Clan priorClan;
	
	public Clan(String name) {
		super();
		this.name = name;
		nextClan = null;
		priorClan = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ninja getFirst() {
		return first;
	}

	public void setFirst(Ninja first) {
		this.first = first;
	}
	

	
	
	public Clan getNextClan() {
		return nextClan;
	}

	public void setNextClan(Clan nextClan) {
		this.nextClan = nextClan;
	}

	public Clan getPriorClan() {
		return priorClan;
	}

	public void setPriorClan(Clan priorClan) {
		this.priorClan = priorClan;
	}

	public Ninja getLastNinja() {
		Ninja last = getFirst();
		if(last != null) {
			while(last.getNextNinja() != null) {
				last = last.getNextNinja();
			}
		}
		return last;
	}
	
	public Ninja findNinja(String nameNinja) {
		Ninja match = getFirst();
		boolean stop = false;
		
		while(match != null && !stop) {
			if (match.getName().equalsIgnoreCase(nameNinja)) {
				stop = true;
			} else {match = match.getNextNinja();
			}
			
		}
		
		return match;
	}
	
	public void addNinja(Ninja newNinja) {
		if(getLastNinja() == null) {
			setFirst(newNinja);
		} else {getLastNinja().setNextNinja(newNinja);}
		
	}
	
	
	
	public String toString() {
		String me = "\n";
		me += "Name: "+getName()+"\n";
		me += "\n";
		return me;
	}
	
	
	public void eraseNinja(Ninja death) {
		
		Ninja prior = death.getPriorNinja();
		Ninja next = death.getNextNinja();
		
		if (prior != null) {
			if(next != null) {
				next.setPriorNinja(prior);	
			} 
			prior.setNextNinja(next);
			
		} else {
			setFirst(next);
			
		}
	}

	@Override
	public int compareTo(Clan cl) {
		int value = 0;
		if (getName().compareTo(cl.getName()) > 0) {
			value = 1;
		} else if (getName().compareTo(cl.getName()) < 0) {
			value = -1;
		}
		return value;
	}
	
	public Clan clone() {
		Clan other = new Clan("");
		
		other.setName(getName());
		other.setNextClan(getNextClan());
		other.setPriorClan(getPriorClan());
		other.setFirst(getFirst());
		
		
		return other;
	}
	
	
	public Clan smallerThan() {
		Clan smaller = null;
		Clan following = getNextClan();
		
		while(following != null) {
		
			if (compareTo(following) >0) {
				smaller = following;
			}
			following = following.getNextClan();
		}
		
		
		return smaller;
	}
	
	
	public String printNinjasOrganized() {
		ninjasSortedSelection();
		String everything = "";
		
		Ninja match = getFirst();
		
		if (match == null) {
			everything = "ERROR: There are 0 ninjas in this clan";
		}
		
		while(match != null ) {
			everything += match.toString();	
			match = match.getNextNinja();
		}
		
		return everything;
	}

	public void ninjasSortedSelection() {
		Ninja match = getLastNinja();
		Ninja firstN = getFirst();
		
		while(match != null ) {
			
			while(firstN != null) {
				if(firstN.getNextNinja() != null && firstN.compareTo(firstN.getNextNinja()) > 0) {
					switchPositions(firstN, firstN.getNextNinja());
				}
				
				firstN = firstN.getNextNinja();
			}
			
					
			match = match.getPriorNinja();
		}
			
			
	}
	
	public void switchPositions(Ninja match, Ninja smaller) {
		
		Ninja tempM = match.clone();
		Ninja tempS = smaller.clone();
		
		match.setName(tempS.getName());
		match.setCreationDate(tempS.getCreationDate());
		match.setPersonality(tempS.getPersonality());
		match.setPower(tempS.getPower());
		
		smaller.setName(tempM.getName());
		smaller.setCreationDate(tempM.getCreationDate());
		smaller.setPersonality(tempM.getPersonality());
		smaller.setPower(tempM.getPower());
		
		
	}
	
	
		

} // end of class
