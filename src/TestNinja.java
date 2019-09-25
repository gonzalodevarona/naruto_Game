/*
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
* ID
* UNIVERSIDAD ICESI (CALI-COLOMBIA)
* DEPARTAMENTO TIC - ALGORTIMOS Y PROGRAMACIÓN II
* LAB III
* @AUTHOR: GONZALO DE VARONA <gonzalo.de1@correo.icesi.edu.co>
* @LAST UPDATE DATE: 24 SEPTEMBER 2019
* ˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜
*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import model.*;

class TestNinja {

	@Test
	void test() {
		fail("Not yet implemented");
	}

Ninja ninja;
	
	
	//SINGLE JUTSU
	public void setupStage() {
		ninja = new Ninja("Naruto", new GregorianCalendar(1997, 2, 21), "Good", 2000); 
		ninja.addJutsu(new Jutsu("Rasengan", 600));
	}

	//REGULAR
	public void setupStage1() {
		ninja = new Ninja("Naruto", new GregorianCalendar(1997, 2, 21), "Good", 2000);
		ninja.addJutsu(new Jutsu("Rasengan", 600));
		ninja.addJutsu(new Jutsu("Clones", 200));
		ninja.addJutsu(new Jutsu("Sage", 1000));
		ninja.addJutsu(new Jutsu("Frogs", 800));
		ninja.addJutsu(new Jutsu("Sexy", 50));
	}
	
	//NO JUTSUS
		public void setupStage2() {
			ninja = new Ninja("Naruto", new GregorianCalendar(1997, 2, 21), "Good", 2000); 
		}
	
	
	
	//TESTS WHEN IT IS A SINGLE JUTSU
	
	@Test
	void testGetLast() {
		setupStage();
		
			assertTrue(ninja.getLastJutsu().getName().equalsIgnoreCase("Rasengan")); 
		
	}
	
	
	
	
	//TESTS WHEN IT IS REGULAR
	
	@Test
	void testGetLast1() {
		setupStage1();
		
			assertTrue(ninja.getLastJutsu().getName().equalsIgnoreCase("Sexy")); 
		
	}
	
	
	//TESTS WHEN THERE ARE NO JUTSUS
	
	@Test
	void testGetLast2() {
		setupStage2();
		if (ninja.getLastJutsu() != null) {
			assertFalse(ninja.getLastJutsu().getName().equalsIgnoreCase("Sexy"));
		}
			 
		
	}
	

	
} //end of class