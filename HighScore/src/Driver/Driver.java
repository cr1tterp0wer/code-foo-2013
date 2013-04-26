package Driver;

import HEAP.Heap;

public class Driver {

	public static Heap heap;
	
	public static void main(String[] arvs)
	{
		heap = new Heap("henrik", 100f);
		heap.add("whitney", 50f);
		heap.add("agge", 450f);
		heap.add("sheik", 214f);
		heap.add("johan", 12f);
	    heap.add("gabe", 16f);
	    heap.add("Mario", 82f);
	    heap.add("Hanna", 9109f);
	    heap.add("Vanessa", 74f);
	    heap.add("Jake", 462f);
	    heap.add("Dallas", 304f);
	    heap.add("Jude", 845f);
	    heap.add("Gerp", 1243f);
	    heap.add("Luigi", 6482f);
	    heap.add("Cloud", 74f);
	    heap.add("BuzzLightyear", 9312f);
	    heap.add("James", 354f);
	    heap.add("Power", 12839f);
	    heap.add("Steve", 123f);
	    heap.add("Casey", 6478f);
	    
	    heap.display();
	    
	}
}
