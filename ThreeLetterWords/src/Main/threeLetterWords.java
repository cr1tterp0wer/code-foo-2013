package Main;

import java.io.IOException;
import java.util.Scanner;

import MetaDataReader.MetaDataReader;

public class threeLetterWords {

	public static MetaDataReader MDR;
	public static Scanner scan;
	public static String userInput;
	public static boolean isRunning = true;
	

	public static void main(String[] args) throws IOException
	{
		scan = new Scanner(System.in);

		MDR = new MetaDataReader("MetaData\\three-letter-words.txt");

		MDR.readData();	
		
		System.out.println("##########WORD COMPARE 1.0##########");
		System.out.println("____Enter a three letter word______");
		
		
		userInput = scan.nextLine();
		
		MDR.compare(userInput);
		
	}

}
