package BST;

public interface IBinarySearchTree {

	 boolean insertHead(Object newEntry);
	 boolean insertTail(Object newEntry);
	 public Object deleteHead();
	 public Object deleteTail();
	 public void display();
	 public String toString();
	 public int contains(Object anEntry);
	 public boolean isEmpty();
	 public boolean isFull();
	 
	 
}
