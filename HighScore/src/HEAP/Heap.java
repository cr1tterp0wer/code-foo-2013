package HEAP;



public class Heap {

	private Score[] bubbleSort;
	private int EndIndex;

	public Heap( String _name, float _score)
	{
		bubbleSort = new Score[100];
		bubbleSort[0] = new Score(_name, _score);
		EndIndex = 0;
	}


	public void add(String _name, float _score)
	{
		bubbleSort[EndIndex] = new Score(_name, _score);
		EndIndex++;
		sort();
	}

	public void sort()
	{
		Score temp;
		for(int i = 0 ; i < EndIndex; i++)
		{
			for(int k=0; k < EndIndex; k++)
			{
				if( bubbleSort[i].score > bubbleSort[k].score )
				{
					temp = bubbleSort[i];
					bubbleSort[i] = bubbleSort[k];
					bubbleSort[k] = temp;
				}
			}
		}
	}



	public void display()
	{
		for(int i = 0; i < EndIndex; i++)
		{

			System.out.println(bubbleSort[i].name + " " + bubbleSort[i].score);
			//System.out.println(MergeSort[i].name + " " + MergeSort[i].score);
		}
	}

	private class Score
	{
		private String name;
		private float score;

		public Score(String _name, float _score)
		{
			name = _name;
			score = _score;
		}
	}


}
