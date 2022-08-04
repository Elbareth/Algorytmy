/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*; 
public class Main
{
    public static Integer maxValue(List<Integer> list)
    {
        Integer maxValue = -100;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i) > maxValue) maxValue = list.get(i);
        }
        return maxValue;
    }
	public static List<Integer> countingSort(List<Integer> list)
	{
	    Integer max = maxValue(list);
	    Integer[] counter = new Integer[max+1];
	    for(int i=0;i<max + 1;i++)
	    {
	        counter[i] = 0;
	    }
	    for(Integer element : list)
	    {
	        counter[element] = counter[element] + 1;
	    }
	    Integer currentMainArrayIndex = 0;
	    for(int i = 0;i<counter.length;i++)
	    {
	        while(counter[i] > 0)
	        {
	            list.set(currentMainArrayIndex, i);
	            counter[i] = counter[i] - 1;
	            currentMainArrayIndex++;
	        }
	    }
	    return list;
	}
	public static void main(String[] args) {
		List<Integer> listeczka = Arrays.asList(3,4,2,5,1,6,12,14,11);
		listeczka = countingSort(listeczka);
		for(int i=0; i<listeczka.size();i++)
		{
		    System.out.println(listeczka.get(i)+" ");
		}
	}
}
