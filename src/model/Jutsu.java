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

public class Jutsu implements Serializable, Comparable<Jutsu> {
	
	private String name;
	private int factor;
	private Jutsu next;
	public Jutsu(String name, int factor) {
		super();
		this.name = name;
		this.factor = factor;
		next = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFactor() {
		return factor;
	}
	public void setFactor(int factor) {
		this.factor = factor;
	}
	public Jutsu getNext() {
		return next;
	}
	public void setNext(Jutsu next) {
		this.next = next;
	}
	
	public void myNewNextIsTheNextOfMyActualNext() { // I HAVE A NOT NULL NEXT  JUTSU AND ITS NEXT IS NOT NULL AS WELL
		this.next = next.getNext();
	}
	
	
	public String toString() {
		String me = "\n";
		me += "Name: "+getName()+"\n";
		me += "Factor: "+getFactor()+"\n";
		me += "\n";
		return me;
	}
	
	
	@Override
	public int compareTo(Jutsu jutsu) {
		
		int value = 0;
		 
    	if(getFactor() > jutsu.getFactor()){
    		value = 1;
    	}else if(getFactor() < jutsu.getFactor()){
    		value = -1;
    	}
        return value;
	}
	
	
	

} //end of class
