package MAIN;

import java.io.IOException;
import java.util.Scanner;

import MetaDataReader.MetaDataReader;

public class Driver {

	 public static MetaDataReader MDR;
	 public static Scanner scan;
	 public static String str = "";
	 
	public static void main(String[] args) 
	{
		scan = new Scanner(System.in);

		
		System.out.println("##########CROSSWORD-FINDER 1.0##########");
		System.out.println();
		System.out.println("_______Board_______");
		try{
			
			MDR = new MetaDataReader("MetaData\\Board.txt");
			MDR.readData();
			
			MDR.printBoard();
			
			System.out.println();
			System.out.print("Please enter a word (ommit spaces):");
			
			str = scan.nextLine();
			
			System.out.println("(Matched word appears in CAPS)");
			
			MDR.find(str);
			
			MDR.printBoard();
			
			System.out.println();
			System.out.println("Would you like to see the Word KEY? y/n: ");
			
			str = scan.nextLine();
			
			
			switch(str)
			{
			case "y"   :
			case "yes" : MDR.findAll();
			
			default    : System.out.println("Goodbye!");
			}
			
			
		}catch(IOException e){}
		
	}
	
	

}
