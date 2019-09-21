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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Investor {
	
	public final static String LOCATION = "data/Gonzalo De Varona";
	
	private String name;
	private Clan firstClan;
	
	public Investor() {
		super();
		name = "Gonzalo De Varona";
		firstClan = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Clan getFirstClan() {
		return firstClan;
	}

	public void setFirstClan(Clan firstClan) {
		this.firstClan = firstClan;
	}

	public void addClan(Clan clan) {
		Clan ls = getLastClan();
		if (ls != null) {
			ls.setNextClan(clan);
		
		}else {
			setFirstClan(clan);
		}
	}
	
	public Clan getLastClan() {
		Clan last = getFirstClan();
		if(last != null) {
			while(last.getNextClan() != null) {
				last = last.getNextClan();
			}
		}
		return last;
	}
	
	public void saveChanges() throws FileNotFoundException, IOException {
		File file = null;
		file = new File(LOCATION);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(getFirstClan());
		oos.close();
			
		
	}
	
	public boolean loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean done = false;
		File file = new File(LOCATION);
		
		
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			setFirstClan((Clan) ois.readObject());
			ois.close();
			done = true;
		}
		return done;
	}

	public Clan findClan(String nameClan) {
		Clan match = getFirstClan();
		boolean stop = false;
		
		while(match != null && !stop) {
			if (match.getName().equalsIgnoreCase(nameClan)) {
				stop = true;
			} else {match = match.getNextClan();
			}
			
		}
		
		return match;
	}
	
	public void eraseClan(Clan death) {
			
		Clan prior = death.getPriorClan();
		Clan next = death.getNextClan();
			
		if (prior != null) {
			if(next != null) {
				next.setPriorClan(prior);	
			} 
			prior.setNextClan(next);
			
		} else {
			setFirstClan(next);
			
		}
	}

	

} //end of class
