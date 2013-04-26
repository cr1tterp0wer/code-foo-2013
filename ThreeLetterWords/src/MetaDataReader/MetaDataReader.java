package MetaDataReader;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class MetaDataReader implements IMetaDataReader {

	private FileReader reader;
	private BufferedReader bReader;
	private File file;
	private String input, metaDataFilePath;
	private LinkedList<String> inputData;

	public MetaDataReader(String _metaDataFilePath) throws IOException
	{
		inputData = new LinkedList();
		metaDataFilePath = _metaDataFilePath;
	}


	///<summary>
	/// Takes in the file location and parses it; 
	///<summary>
	public void readData() throws IOException
	{
		try
		{

			file = new File(metaDataFilePath);
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);

			while(( input = bReader.readLine() ) != null )
			{
				inputData.add(input);
			}
		}catch(Exception e){}
		finally 
		{ 
			if(input != null)
			{
				bReader.close();
			}
		}
	}

	public void compare(String _userInput)
	{
		String userInput = _userInput.toUpperCase();
		int iteration = 0;

		if(inputData.size() > 0 && userInput.length() == 3)
		{

			for(int i = 0; i < inputData.size(); i++)
			{
				iteration = 0;
				if(!userInput.equalsIgnoreCase(inputData.get(i)))
				{
					for(int k = 0; k < userInput.length(); k++)
					{
						if(userInput.charAt(k) != inputData.get(i).charAt(k))
						{
							iteration++;
						}
					}
					System.out.println("It will take " + iteration + " moves to change " + userInput + " to " + inputData.get(i));
				}
			}
		}
		else System.out.println("No Data to compare!");
	}


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

