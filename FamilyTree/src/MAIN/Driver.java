package MAIN;

import java.util.Scanner;

import BST.BinarySearchTree;

public class Driver {

	public static BinarySearchTree BST;
	public static Scanner scan;
	public static String str;
	public static boolean isRunning = true;
	
	public static void main(String[] args)
	{
		scan = new Scanner(System.in);
		BST = new BinarySearchTree("henrik");
		BST.add("whitney");
		BST.add("joseph");
		BST.add("agge");
		BST.add("sheik");
		BST.add("johan");
	    BST.add("gabe");
	    BST.add("Nathan");
		//BST.display();
	    
	    System.out.println("A DEFAULT TREE HAS BEEN CONSTRUCTED ~ ");
	    
	    while(isRunning)
	    {
	    	
	    	System.out.println("Please enter a name to add: ");
	    	str = scan.next();

	    	
	    	BST.add(str);
	    	
	    	System.out.println("Would you like to enter another? y/n");
	
	    	str = scan.next();
	    	if(!str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes")){
	    		isRunning = false;
	    	}
	    }
	    
	    System.out.println("Type in the name of a word you would like to find: ");
	    str = scan.next();
		
		BST.find(str);
		
		System.out.println();
		System.out.println("Please Type in the Generation you would like to list(must be a number): ");
		
		int input = scan.nextInt();
	
		BST.find(input);
		
		
	}

}
