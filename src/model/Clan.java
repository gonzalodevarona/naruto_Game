/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB III
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 19 SEPTEMBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/

package model;

import java.io.Serializable;

public class Clan implements Serializable {
	
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
	
	
	
	
	
	
	
	
	

} // end of class
