package MetaDataReader;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class MetaDataReader implements IMetaDataReader {

	private int rowIndex=0, columnIndex=0, phraseIndex=0;
	private FileReader reader;
	private BufferedReader bReader;
	private File file;
	private String dummy, metaDataFilePath,  phrase="null", TempMatch="";
	private String[] splitArray;
	private String[][] board;
	private LinkedList<Point> MatchList;

	public MetaDataReader(String _metaDataFilePath) throws IOException
	{
		//Scanner streamReader = null;
		metaDataFilePath = _metaDataFilePath;
		init();
	}

	///
	// Defines the Width and Height of the Board
	///

	public void init() throws IOException
	{
		MatchList = new LinkedList();
		try{

			file = new File(metaDataFilePath);
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);

			dummy = bReader.readLine();
			rowIndex++;
			splitArray = dummy.split(" ");
			columnIndex = splitArray.length;

			while(( dummy = bReader.readLine() ) != null )
			{
				rowIndex++;
			}
		}catch(Exception e){}
		finally{bReader.close();}

		board = new String[rowIndex][columnIndex];
	}


	///<summary>
	/// Takes in the file location and parses it; 
	///<summary>
	public void readData() throws IOException
	{
		try
		{
			rowIndex = 0;
			splitArray = new String[columnIndex];
			dummy = "EMPTY_VALUE";

			file = new File(metaDataFilePath);
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);

			while(( dummy = bReader.readLine() ) != null )
			{
				splitArray = dummy.split(" ");

				for(int i = 0; i < splitArray.length; i++)
				{
					board[rowIndex][i] = splitArray[i].toLowerCase();
				}
				rowIndex++;
			}
		}catch(Exception e){}
		finally 
		{ 
			if(dummy != null)
			{
				bReader.close();
			}
		}
	}

	public void find(String _phrase)
	{
		phrase = _phrase.toLowerCase();
		phrase = phrase.replaceAll("\\s","");
		TempMatch="";

		//Row
		for(int i = 0; i < rowIndex; i++)
		{
			//Column
			for(int k = 0; k < columnIndex; k++)
			{
				if(board[i][k].charAt(0) == phrase.charAt(0))
				{
					checkHorizontal(i,k);
					checkVertical(i,k);
					checkDiagonal(i,k);
					checkHorizontalReverse(i,k);
					checkVerticalReverse(i,k);
					checkDiagonalReverse(i,k);
				}
			}
		}
	}

	public void findAll()
	{
		find("Health");
		find("Score");
		find("Zerg");
		find("Assassin");
		find("Reload");
		find("Pylon");
		find("Level");
		find("Bazooka");
		find("blunderbuss");
		find("killtacular");
		find("Heist");
		find("Duck");
		find("Halo"); 
		find("mushroom");
		find("Horde");
		find("Ganondorf");
		find("Protoman");
		find("Hydralisk");
		find("Shepard");
		find("NukaCola");
		find("Plasmid");
		find("Wouldyoukindly");
		find("Metroid");
		find("XinZhao");
        printBoard();
	}

	///
	/// Recursive Checks
	///
	private void checkHorizontal(int _x, int _y)
	{
		int x = _x;
		int y = _y;
		String str1 =  board[x][y].toLowerCase();
		String str2 = phrase.toLowerCase();

		if(y+1 < columnIndex && phraseIndex < phrase.length() && str1.charAt(0) == str2.charAt(phraseIndex) )
		{ 
			TempMatch = TempMatch.concat(board[x][y]);

			if(TempMatch.equalsIgnoreCase(phrase))
			{
				MatchList.add(new Point(x, y));
				validateMatches();
			}
			MatchList.add(new Point(x, y));
			phraseIndex++;
			checkHorizontal(x, y+1);

		}
		MatchList.clear();
		phraseIndex=0;
		TempMatch = "";
	}

	private void checkVertical(int _x, int _y)
	{
		int x = _x;
		int y = _y;
		String str1 =  board[x][y].toLowerCase();
		String str2 = phrase.toLowerCase();

		if( x+1 < rowIndex && phraseIndex < phrase.length() && str1.charAt(0) == str2.charAt(phraseIndex) )
		{
			TempMatch = TempMatch.concat(board[x][y]);

			if(TempMatch.equalsIgnoreCase(phrase))
			{
				MatchList.add(new Point(x, y));
				validateMatches();
			}
			MatchList.add(new Point(x, y));
			phraseIndex++;
			checkVertical( x+1 , y);
		}
		MatchList.clear();
		phraseIndex=0;
		TempMatch = "";
	}

	private void checkDiagonal(int _x, int _y)
	{
		int x = _x;
		int y = _y;
		String str1 =  board[x][y].toLowerCase();
		String str2 = phrase.toLowerCase();
		if( ( x+1 < rowIndex && y+1 < columnIndex)  && phraseIndex < phrase.length() && str1.charAt(0) == str2.charAt(phraseIndex))
		{
			TempMatch =TempMatch.concat(board[x][y]);
			if(TempMatch.equalsIgnoreCase(phrase))
			{
				MatchList.add(new Point(x, y));
				validateMatches();
			}
			MatchList.add(new Point(x, y));
			phraseIndex++;
			checkDiagonal( x+1 , y+1);
		}
		MatchList.clear();
		phraseIndex=0;
		TempMatch = "";
	}

	private void checkHorizontalReverse(int _x, int _y)
	{
		int x = _x;
		int y = _y;
		String str1 =  board[x][y].toLowerCase();
		String str2 = phrase.toLowerCase();

		if(  y-1 >=0 && phraseIndex < phrase.length() && str1.charAt(0) == str2.charAt(phraseIndex))
		{
			TempMatch =TempMatch.concat(board[x][y]);
			if(TempMatch.equalsIgnoreCase(phrase))
			{
				MatchList.add(new Point(x, y));
				validateMatches();
			}
			MatchList.add(new Point(x, y));
			phraseIndex++;
			checkHorizontalReverse( x, y-1);
		}
		MatchList.clear();
		phraseIndex=0;
		TempMatch = "";
	}

	private void checkVerticalReverse(int _x, int _y)
	{
		int x = _x;
		int y = _y;
		String str1 =  board[x][y].toLowerCase();
		String str2 = phrase.toLowerCase();

		if(  x-1 >=0 && phraseIndex < phrase.length() && str1.charAt(0) == str2.charAt(phraseIndex))
		{
			TempMatch =TempMatch.concat(board[x][y]);
			if(TempMatch.equalsIgnoreCase(phrase))
			{
				MatchList.add(new Point(x, y));
				validateMatches();
			}
			MatchList.add(new Point(x, y));
			phraseIndex++;
			checkVerticalReverse(x-1, y);
		}
		MatchList.clear();
		phraseIndex=0;
		TempMatch = "";
	}

	private void checkDiagonalReverse(int _x, int _y)
	{
		int x = _x;
		int y = _y;
		String str1 =  board[x][y].toLowerCase();
		String str2 = phrase.toLowerCase();

		if( ( x+1 < rowIndex && y-1 >= 0) && phraseIndex < phrase.length() && str1.charAt(0) == str2.charAt(phraseIndex))
		{
			TempMatch =TempMatch.concat(board[x][y]);
			if(TempMatch.equalsIgnoreCase(phrase))
			{
				MatchList.add(new Point(x, y));
				validateMatches();
			}
			MatchList.add(new Point(x, y));
			phraseIndex++;
			checkDiagonalReverse( x+1 , y-1);
		}
		MatchList.clear();
		phraseIndex=0;
		TempMatch = "";
	}


	public void printBoard()
	{
		System.out.println();

		for(int i = 0; i < rowIndex; i++)
		{
			for(int k = 0; k < columnIndex; k++)
			{
				System.out.print(board[i][k]);
			}
			System.out.println();
		}
	}

	private void validateMatches()
	{
		if(TempMatch.equalsIgnoreCase(phrase))
		{
			for(int i = 0; i < MatchList.size(); i++)
			{
				board[MatchList.get(i).x][ MatchList.get(i).y] = board[MatchList.get(i).x][ MatchList.get(i).y].toUpperCase();
			}
			System.out.println( phrase + " FOUND AT INDEX:   X: " + (MatchList.get(0).y + 1) + " Y: " + (MatchList.get(0).x  + 1));
		}
		MatchList.clear();
	}


	public String[][] getBoard(){return board;}

	@Override
	public void add(String type, String description, String location) {}

	@Override
	public boolean removeAt(int index) {return false;}

	@Override
	public void sort() {}

	@Override
	public void listDirectory(String _directory) {}

	@Override
	public void readDirectory(String _directory) {}

	@Override
	public void listTextureDataArray() {}

	@Override
	public void listDescriptionArray() {}

	@Override
	public void listLocationArray() {}

	@Override
	public void listTypeArray() {}

	@Override
	public void setTypeAt(int index, String type) {}

	@Override
	public void setDescriptionAt(int index, String description) {}

	@Override
	public void setLocationAt(int index, String location) {}

	@Override
	public String getTypeAt(int index) {return null;}

	@Override
	public String getDescriptionAt(int index) {return null;}

	@Override
	public String getFileLocationAt(int index) {return null;}
}

