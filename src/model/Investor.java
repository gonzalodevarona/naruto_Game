/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB III
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 13 SEPTEMBER 2019
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
	
	private String name;
	private ArrayList<Clan> clans;
	
	public Investor() {
		super();
		name = "Gonzalo De Varona";
		clans = new ArrayList<Clan>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Clan> getClans() {
		return clans;
	}

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	
	public void addClan(Clan clan) {
		clans.add(clan);
	}
	
	public void saveChanges() throws FileNotFoundException, IOException {
		File file = null;
		file = new File(getName());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(getClans());
		oos.close();
			
		
	}
	
	public boolean loadChanges() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean done = false;
		File file = new File(getName());
		
		
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			setClans((ArrayList<Clan>) ois.readObject());
			ois.close();
			done = true;
		}
		return done;
	}

	public Clan findClan(String name1) {
		Clan clann = null;
		boolean stop = false;
		for (int i = 0; i < clans.size() && !stop; i++) {
			if(name1.equalsIgnoreCase(clans.get(i).getName())){
				clann = clans.get(i);
				stop = true;
			}
		}
		return clann;
	}

}
