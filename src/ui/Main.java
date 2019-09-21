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


package ui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;

public class Main {
	
	private Scanner reader;
	private Investor investor;
	
	public Main() {
		
		investor = new Investor();
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main execute = new Main();
		execute.menu();
		
		
		
	
	}
	
	public void showMenuOptions(){
		System.out.println("");
		System.out.println("1. Register a new clan.");
		System.out.println("2. Register a new character.");
		System.out.println("3. Add a jutsu to an existing character in a clan.");
		System.out.println("4. Erase a clan.");
		System.out.println("5. Erase a character from a clan.");
		System.out.println("6. Erase a jutsu from a character.");
		System.out.println("7. Search a clan by name.");
		System.out.println("8. Search a ninja in a clan by name.");
		System.out.println("9. Search a jutsu from a ninja in a clan by name.");
		System.out.println("10.QUIT PROGRAM");
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");
	}
	
	public void menu(){
		int userInput = 0;
		
		
		try {
			investor.loadChanges();
			
			
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("");
		System.out.println("");

		//WELCOME 	
		System.out.println("M''MMM''MMM''M          dP                                         "); 
		System.out.println("M  MMM  MMM  M          88                                         ");
		System.out.println("M  MMP  MMP  M .d8888b. 88 .d8888b. .d8888b. 88d8b.d8b. .d8888b.   ");
		System.out.println("M  MM'  MM' .M 88ooood8 88 88'    ` 88'  `88 88'`88'`88 88ooood8");
		System.out.println("M  `' . '' .MM 88.  ... 88 88.  ... 88.  .88 88  88  88 88.  ...   ");
		System.out.println("M    .d  .dMMM `88888P' dP `88888P' `88888P' dP  dP  dP `88888P'   TO NARUTOsoft");
		System.out.println("MMMMMMMMMMMMMM                                                     ");
		System.out.println("                                                                   ");                                                      
	

		while (userInput != 10){

			showMenuOptions();

			System.out.println("--------------------------------------");
			System.out.print("| Type the number of your selection: ");
			try {
				userInput = reader.nextInt();
				reader.nextLine();
				System.out.println("--------------------------------------");
	
				switch (userInput) {
	
					//REGISTER A NEW CLAN
					case 1: 
						registerANewClan();
						break;
	
					//REGISTER A NEW NINJA
					case 2: 
						registerANewNinja();
						break; 
	
	
					//ADD A JUTSU TO AN EXISTING CHARACTER
					case 3: 
						addJutsu(); 
						break;
						
					//ERASE A CLAN FROM THE PROGRAM
					case 4: 
						eraseAClan(); 
						break;
						
					//ERASE A NINJA FROM THE PROGRAM
					case 5: 
						eraseANinja(); 
						break;
						
					//ERASE A JUTSU FROM THE PROGRAM
					case 6: 
						eraseAJutsu(); 
						break;
	
						
					//SEARCH A CLAN BY NAME
					case 7: 
						searchClan();
						break;
						
					//SEARCH A NINJA BY NAME
					case 8: 
						searchNinja();
						break;
						
					//SEARCH A JUTSU FROM A NINJA IN A CLAN BY NAME
					case 9: 
						searchJutsu();
						break;
						
					//QUIT PROGRAM
					case 10: 
						theGoodbye();
						break;
	
					default:
						System.out.println();
						System.out.println("Please type a number between 1 and 15");
						System.out.println();
						break;
					
				}
			} catch(InputMismatchException e){
				System.out.println();
				System.out.print("ERROR: Wrong data type.");
				reader.nextLine();
				System.out.println();
			}
			
		}
		
	}
		
	
	

	public void searchClan() {
		try {
			System.out.println("Please type the name of the clan: "); String stuff = reader.nextLine();
			
			Clan c = investor.findClan( stuff);
			if (c != null) {
				System.out.println(c.toString());
				
				System.out.println();
				
			} else {
				System.out.println("");
				System.out.println("ERROR: Clan not found");
				System.out.println("");
				}
			
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	}
	
	
	public void searchNinja() {
		try {
			System.out.println("Please type the name of the clan: "); String stuff = reader.nextLine();
			
			Clan c = investor.findClan( stuff);
			if (c != null) {
				System.out.println("Please type the name of the ninja: "); String name = reader.nextLine();
				
				Ninja n = c.findNinja(name);
				if (n != null) {
					System.out.println(n.toString());
					
					System.out.println();
					
				} else {
					System.out.println("");
					System.out.println("ERROR: Ninja not found");
					System.out.println("");
					}
				
			} else {
				System.out.println("");
				System.out.println("ERROR: Clan not found");
				System.out.println("");
				}
			
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	}
	
	public void searchJutsu() {
		try {
			System.out.println("Please type the name of the clan: "); String stuff = reader.nextLine();
			
			Clan c = investor.findClan( stuff);
			if (c != null) {
				System.out.println("Please type the name of the ninja: "); String name = reader.nextLine();
				
				Ninja n = c.findNinja(name);
				if (n != null) {
					
					System.out.println("Please type the name of the jutsu: "); String nameJutsu = reader.nextLine();
					
					Jutsu j = n.locateJutsu(nameJutsu);
					if (j != null) {
						System.out.println(j.toString());
						
						System.out.println();
						
					} else {
						System.out.println("");
						System.out.println("ERROR: Jutsu not found");
						System.out.println("");
						}
					
				} else {
					System.out.println("");
					System.out.println("ERROR: Ninja not found");
					System.out.println("");
					}
				
			} else {
				System.out.println("");
				System.out.println("ERROR: Clan not found");
				System.out.println("");
				}
			
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	}
	
	
	
	
	
	public void eraseAJutsu() {
		try {
			
			
			System.out.print("Please type the clan's name of the jutsu's user to delete: "); String id = reader.nextLine();
			System.out.println("");
			Clan myClan = investor.findClan(id);
					
					
				if (myClan != null) {
					
							System.out.print("Please type the ninja's name: "); String name = reader.nextLine();
							Ninja ninja = myClan.findNinja(name);
						
							
						if (ninja != null) {
							System.out.println("");
							
						
							Jutsu j = null;
							
					
							System.out.print("Please type the jutsu's name: "); String jutsuName = reader.nextLine();
							j = ninja.locateJutsu(jutsuName);
									
							
								if (j != null) {
									ninja.eraseJutsu(j);
									System.out.println("");
									System.out.println(j.getName()+" was deleted from ninja: "+ ninja.getName());
									System.out.println("");
								}else {
									System.out.println("");
									System.out.println("ERROR: Jutsu not found");
									System.out.println("");
									}	
							
						} else {
							System.out.println("");
							System.out.println("ERROR: Ninja not found");
							System.out.println("");
							}
					
					
				} else {
					System.out.println("");
					System.out.println("ERROR: Clan not found");
					System.out.println("");
					}
			 
			
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	
	}


		
	public void eraseANinja() {
		try {
			
			
			System.out.print("Please type the clan's name of the ninja to delete: "); String id = reader.nextLine();
			System.out.println("");
			Clan myClan = investor.findClan(id);
					
					
				if (myClan != null) {
					
							System.out.print("Please type the ninja's name: "); String name = reader.nextLine();
							Ninja ninja = myClan.findNinja(name);
						
							
						if (ninja != null) {

									myClan.eraseNinja(ninja);
									System.out.println("");
									System.out.println(ninja.getName()+" was deleted from clan: "+ myClan.getName());
									System.out.println("");
								
							
						} else {
							System.out.println("");
							System.out.println("ERROR: Ninja not found");
							System.out.println("");
							}
					
					
				} else {
					System.out.println("");
					System.out.println("ERROR: Clan not found");
					System.out.println("");
					}
			 
			
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
		}
	
	}
		
	public void eraseAClan() {
			try {
						
				Clan myClan = null;
				
				System.out.print("Please type the clan's name to delete it: "); String name = reader.nextLine();
				System.out.println("");
				myClan = investor.findClan(name);
				
					if (myClan != null) {
						System.out.println("* WARNING * Are you sure you want to delete the clan? Every ninja and jutsu contained in this clan will be deleted as well.");
						System.out.println("1. Yes.");
						System.out.println("2. No.");
						int desition = reader.nextInt(); reader.nextLine();
						if (desition == 1) {
							investor.eraseClan(myClan);
							System.out.println("");
							System.out.println("Clan successfully deleted");
							System.out.println("");
						} else {
							System.out.println("");
							System.out.println("Clan was not deleted");
							System.out.println("");
							}
						
					} else {
						System.out.println("");
						System.out.println("ERROR: Clan not found");
						System.out.println("");
						}
				
				
				
			} catch (InputMismatchException e) {
				System.out.println("");
				System.out.println("ERROR: Wrong data type.");
				System.out.println("");
			}
		
		}

	public void addJutsu() {
			try {
				System.out.println("REGISTER JUTSU");
				System.out.println("");
				
				System.out.print("Please type the clan's name where the user (ninja) of the jutsu is:");
				String idClan = reader.nextLine();
				Clan mainC = investor.findClan(idClan);
				
				if (mainC != null) {
					System.out.print("Please type the ninja's name:"); String ninja = reader.nextLine();
					Ninja n = mainC.findNinja(ninja);
					if (n != null) {

						System.out.print("Please write the jutsu's name: "); String nameJutsu = reader.nextLine();
						System.out.print("Please type the the jutsu's power: "); int power = reader.nextInt(); reader.nextLine();

						if (n.locateJutsu(nameJutsu) == null) {
							Jutsu jut = new Jutsu(nameJutsu, power);
							n.addJutsu(jut);
							System.out.println("Sucessfully added "+jut.getName()+" to "+n.getName());
						} else {
							System.out.println("");
							System.out.println("ERROR: This ninja already has a jutsu with this name.");
							System.out.println("");
						}
						
					} else {
						System.out.println("");
						System.out.println("ERROR: Ninja not found.");
						System.out.println("");
					}
				} else {
					System.out.println("");
					System.out.println("ERROR: Clan not found.");
					System.out.println("");
				}
			 
					
					
			} catch (InputMismatchException e) {
				System.out.println("");
				System.out.println("ERROR: Wrong data type.");
				System.out.println("");
			}
				
				
				
		} 
			
			
		
		

	public void registerANewNinja() {
			try {
				System.out.println("");
				System.out.print("Please type the clan's name where the new ninja will be added: "); String id = reader.nextLine();
				System.out.println("");
				Clan myClan = investor.findClan(id);
				if (myClan != null) {
					
					System.out.print("Please type the new ninja's name: "); String name = reader.nextLine();
					if(myClan.findNinja(name) == null) {
						System.out.print("Please type the new ninja's personality: "); String personality = reader.nextLine();
						System.out.print("Please type the new ninja's power: "); int power = reader.nextInt(); reader.nextLine();
						
						System.out.println("");
						System.out.print("Please type the new ninja's creation day: "); int day = reader.nextInt(); reader.nextLine();
						System.out.print("Please type the new ninja's creation month: "); int month = reader.nextInt(); reader.nextLine();
						System.out.print("Please type the new ninja's creation year: "); int year = reader.nextInt(); reader.nextLine();
						System.out.println("");
						month = month -1;
						
						GregorianCalendar now = new GregorianCalendar();
						GregorianCalendar birthDate = new GregorianCalendar(year, month, day);
						System.out.println("");
						
						if(birthDate.compareTo(now) <= 0 && year>=1970) {
							if(!(name.equals("")) && !(personality.equals("")) ){
								
								Ninja theNew = new Ninja(name, birthDate, personality, power);
								myClan.addNinja(theNew);
								
								System.out.println("******************************************\n");
								System.out.println("* New ninja has been successfully added! *\n");
								System.out.println("******************************************\n");
									
							}				
											
						} else {
							System.out.println("");
							System.out.println("ERROR: Invalid birth date.");
							System.out.println("");
							}
				
					} else {
						System.out.println("");
						System.out.println("ERROR: Ninja already exists in that clan.");
						System.out.println("");
						}
					
				} else {
					System.out.println("");
					System.out.println("ERROR: Clan not found.");
					System.out.println("");
					}
			
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Wrong data type.");
			System.out.println("");
			}
		
	}
			
		
		

	public void registerANewClan() {
			try {
			 	System.out.println("");
				System.out.print("Please type the clan's name: "); String name = reader.nextLine();
				
					
				if (!(name.equals("")) && investor.findClan(name) == null) {
					Clan theNew = new Clan( name);
					investor.addClan(theNew);
					System.out.println("*****************************************\n");
					System.out.println("* New clan has been successfully added! *\n");
				 	System.out.println("*****************************************\n");
						
					
					
				} else { System.out.println("");
				  		System.out.println("ERROR: Other clan is already using this name.");
				  		System.out.println("");
				}
	
			} catch (InputMismatchException e) {
				System.out.println("");
				System.out.println("ERROR: Wrong data type.");
				System.out.println("");
			}
		 }

		

		public void theGoodbye() {
			try {
				
				investor.saveChanges();
			} catch (FileNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("THANK YOU FOR USING NARUTOsoft");
			System.out.println("");
		}
		
		
		
	

}//end of class
