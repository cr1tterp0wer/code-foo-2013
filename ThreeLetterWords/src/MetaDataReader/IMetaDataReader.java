package MetaDataReader;

 import java.io.IOException;


public interface IMetaDataReader {

	public void readData() throws IOException;
	public void add(String type, String description, String location);
	public boolean removeAt(int index);
	public void sort();
	public void listDirectory(String _directory);
	public void readDirectory(String _directory);
	
	public void listTextureDataArray();
	public void listDescriptionArray();
	public void listLocationArray();
	public void listTypeArray();
	
	public void setTypeAt(int index, String type);
	public void setDescriptionAt(int index, String description);
	public void setLocationAt(int index, String location);
		
	public String getTypeAt(int index);
	public String getDescriptionAt(int index);
	public String getFileLocationAt(int index);
	
}