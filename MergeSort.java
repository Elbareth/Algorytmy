/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*; 
public class Main
{
	public static List<Integer> merge(List<Integer> left, List<Integer> rigth)
	{
	    Integer leftIndex = 0;
	    Integer rigthIndex = 0;
	    List<Integer> finalList = new ArrayList<>();
	    while(leftIndex < left.size() && rigthIndex < rigth.size())
	    {
	        if(left.get(leftIndex) < rigth.get(rigthIndex)){
	            finalList.add(left.get(leftIndex));
	            leftIndex++;
	        } 
	        else{
	            finalList.add(rigth.get(rigthIndex));
	            rigthIndex++;
	        } 
	    }
	    while(leftIndex < left.size())
	    {
	        finalList.add(left.get(leftIndex));   
	        leftIndex++;
	    }
	    while(rigthIndex < rigth.size())
	    {
	        finalList.add(rigth.get(rigthIndex));
	        rigthIndex++;
	    }
	    return finalList;
	}
	public static List<Integer> mergeSort(List<Integer> list)
	{
	    if(list.size() < 2) return list;
	    Integer midIndex = list.size() / 2;
	    List<Integer> tmpLeft = mergeSort(list.subList(0,midIndex));
	    List<Integer> tmpRigth = mergeSort(list.subList(midIndex, list.size()));
	    return merge(tmpLeft, tmpRigth);
	}
	public static void main(String[] args) {
		List<Integer> listeczka = Arrays.asList(3,4,2,5,1,6,12,14,11);
		listeczka = mergeSort(listeczka);
		for(int i=0; i<listeczka.size();i++)
		{
		    System.out.println(listeczka.get(i)+" ");
		}
	}
}
