/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB III
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 17 SEPTEMBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/

package model;

import java.io.Serializable;

public class Clan implements Serializable {
	
	private String name;
	private Ninja first;
	
	public Clan(String name) {
		super();
		this.name = name;
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
		Ninja ninInMatter = getFirst();
		boolean stop = false;
		
		while(!stop && ninInMatter != null) {
			if (ninInMatter.getNextNinja() != null && ninInMatter.compareTo(newNinja) <0 && ninInMatter.getNextNinja().compareTo(newNinja) >0) {
				newNinja.setNextNinja(ninInMatter.getNextNinja());
				newNinja.setPriorNinja(ninInMatter);
				ninInMatter.setNextNinja(newNinja);
				ninInMatter.getNextNinja().setPriorNinja(newNinja);
				stop = true;
			} else if (ninInMatter.getNextNinja() == null && ninInMatter.compareTo(newNinja) <0 ) {
				getLastNinja().setNextNinja(newNinja);
				stop = true;
			} else if (ninInMatter.getNextNinja() == null && ninInMatter.compareTo(newNinja) >0 ) {
				getLastNinja().setPriorNinja(newNinja);
				setFirst(newNinja);
				stop = true;
			} else {
				ninInMatter = ninInMatter.getNextNinja();
				
			}
			
		}
		
		if(ninInMatter == null) {
			setFirst(newNinja);
		} 
		
		
	}
	
	public String toString() {
		String me = "\n";
		me += "Name: "+getName()+"\n";
		me += "\n";
		return me;
	}
	
	public void eraseNinja(Ninja death) {
		death.getNextNinja().myNewPriorIsPriorOfMyActualPrior();
		death.getPriorNinja().myNewNextIsTheNextOfMyActualNext();
	}
	
	
	
	
	
	
	
	
	

} // end of class
