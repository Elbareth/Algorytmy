/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*; 
public class Main
{
	public static void insertionSort(List<Integer> list)
	{
	    Integer size = list.size();
	    for(int i=1;i<size;i++)
	    {
	        Integer rigthPointer = i;
	        Integer leftPointer = rigthPointer - 1;
	        Integer inMemory = list.get(rigthPointer);
	        while(leftPointer >=0 && list.get(leftPointer) > inMemory)
	        {
	            list.set(rigthPointer, list.get(leftPointer));
	            leftPointer--;
	            rigthPointer--;
	        }
	        list.set(rigthPointer, inMemory);
	    }
	}
	public static void main(String[] args) {
		List<Integer> listeczka = Arrays.asList(3,4,2,5,1,6,12,14,11);
		insertionSort(listeczka);
		for(int i=0; i<listeczka.size();i++)
		{
		    System.out.println(listeczka.get(i)+" ");
		}
	}
}
