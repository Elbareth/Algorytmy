/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*; 
public class Main
{
	public static List<Integer> quickSort(List<Integer> list, Integer leftEdge, Integer rigthEdge)
	{
	    if(leftEdge >= rigthEdge) return list;
	    Integer pivot = list.get(rigthEdge -1);
	    Integer bluePoint = leftEdge - 1;
	    for(int yellowPoint = leftEdge;yellowPoint < rigthEdge;yellowPoint++)
	    {
	        if(list.get(yellowPoint) <= pivot)
	        {
	            bluePoint++;
	            Integer tmp = list.get(yellowPoint);
	            list.set(yellowPoint, list.get(bluePoint));
	            list.set(bluePoint, tmp);
	        }
	    }
	    quickSort(list,leftEdge,bluePoint);
	    quickSort(list,bluePoint+1,rigthEdge);
	    return list;
	}
	public static void main(String[] args) {
		List<Integer> listeczka = Arrays.asList(3,4,2,5,1,6,12,14,11);
		listeczka = quickSort(listeczka, 0, listeczka.size());
		for(int i=0; i<listeczka.size();i++)
		{
		    System.out.println(listeczka.get(i)+" ");
		}
	}
}
