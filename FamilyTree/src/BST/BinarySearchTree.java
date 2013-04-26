package BST;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree  {

	private TreeNode root;
	private int generation=1;

	public BinarySearchTree(String _data)
	{
		root = new TreeNode(_data);
		root.generation = generation++;
	}

	public void add(String _data)
	{
		int childIndex = 0;

		TreeNode newNode = new TreeNode(_data );
		TreeNode current = root, parent = null;

		generation = 1;

		//use current to hit the first appropriate null leaf

		while(current != null)
		{
			generation++;
			//if -1 current is greater than newNode
			childIndex = newNode.data.compareTo(current.data);

			if(childIndex == 0) //they are equal, do nothing
				return;
			else if( childIndex < 0)
			{
				parent = current;
				current = current.left;
				if(current == null)
				{
					parent.left = newNode;
					parent.left.generation = generation;
				}
			}
			else if( childIndex > 0 )
			{
				parent = current;
				current = current.right;
				if(current == null)
				{
					parent.right = newNode;
					parent.right.generation = generation;
				}
			}
		}
	}

	public void display()
	{
		//System.out.println(root.left.left.data);
		traverseDisplay(root);
	}

	public void traverseDisplay(TreeNode _root)
	{
		if(_root != null)
		{
			traverseDisplay(_root.left);
			System.out.print(_root.data + _root.generation + " ");
			traverseDisplay(_root.right);
		}
	}

	public void find(String _data)
	{
		traverseFindName(root, _data);

	}

	public void find(int _generation)
	{
		traverseFindGeneration( root, _generation);

	}
	
	private void traverseFindGeneration(TreeNode _root, int _generation)
	{
		
		if(_root != null )
		{
		     if( _root.generation == _generation)
			{
				System.out.println(_root.data);
			}

		     if(_root.generation != generation && _root.left != null)
			{
				
				traverseFindGeneration(_root.left, _generation);
			}
		      if(_root.generation != generation && _root.right != null)
		     {
		     traverseFindGeneration(_root.right, _generation);
		     }
			
		}
	}
	

	private void traverseFindName(TreeNode _root, String _data)
	{
		if(_root != null)
		{
			int childIndex = _data.compareTo(_root.data);

			if( childIndex > 0 )
			{
				traverseFindName(_root.right, _data);
			}
			else if( childIndex < 0 )
			{
				traverseFindName(_root.left, _data);
			}
			else if(childIndex == 0)
			{
				System.out.println(_root.data + " exists within the Tree: Generation number " + _root.generation);
			}
		}
		else if(_root == null)
		{
			System.out.println("Cannot Find That name :(");
		}
		

	}



	private class TreeNode
	{
		private String data;
		private TreeNode left, right;
		private int generation;

		//Setups a single node.
		public TreeNode (String _data)
		{
			this.data = _data;
		}


	}
}
