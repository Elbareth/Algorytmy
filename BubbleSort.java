/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*; 
public class Main
{
	public static void bubbleSort(List<Integer> list)
	{
	    Boolean isSwapped = false;
	    Integer tmp;
	    Integer size = list.size();
	    for(int i=0;i<size-1;i++)
	    {
	        for(int j=0;j<size-1-i;j++)
	        {
	            if(list.get(j)>list.get(j+1))
	            {
	                tmp = list.get(j+1);
	                list.set(j+1,list.get(j));
	                list.set(j,tmp);
	                isSwapped = true;
	            }
	        }
	        if(!isSwapped) break;
	        isSwapped = false;
	    }
	}
	public static void main(String[] args) {
		List<Integer> listeczka = Arrays.asList(3,4,2,5,1,6,12,14,11);
		bubbleSort(listeczka);
		for(int i=0; i<listeczka.size();i++)
		{
		    System.out.println(listeczka.get(i)+" ");
		}
	}
}
