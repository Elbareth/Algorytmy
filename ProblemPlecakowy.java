
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.util.*;
import static java.lang.Math.max;
public class Main
{
    private static Integer[][] memo;
    public static Integer kapsack_classic(Integer thing, Integer capacity, List<Integer> values, List<Integer> weigths)
    {
        if(thing < 0 || capacity == 0) return 0;
        if(weigths.get(thing) > capacity) return kapsack_classic(thing - 1, capacity, values, weigths);
        else
        {
            Integer valuesIfNotTaken = kapsack_classic(thing - 1, capacity, values, weigths);
            Integer valuesIfTaken = values.get(thing) + kapsack_classic(thing -1, capacity - weigths.get(thing), values, weigths);
            return Math.max(valuesIfTaken, valuesIfNotTaken);
        }
    }
    public static Integer kapsack_top_down(Integer thing, Integer capacity, List<Integer> values, List<Integer> weigths)
    {
        Integer result;
        if(thing < 0 || capacity == 0) return 0;
        if(memo[thing][capacity] != null) return memo[thing][capacity];
        else if(weigths.get(thing) > capacity) result = kapsack_top_down(thing -1, capacity, values, weigths);
        else
        {
            Integer valuesIfNotTaken = kapsack_classic(thing - 1, capacity, values, weigths);
            Integer valuesIfTaken = values.get(thing) + kapsack_classic(thing -1, capacity - weigths.get(thing), values, weigths);
            result = Math.max(valuesIfTaken, valuesIfNotTaken);
        }
        memo[thing][capacity] = result;
        return result;
    }
    public static Integer kapsack_bottom_up(Integer thing, Integer capacity, List<Integer> values, List<Integer> weights)
    {
       Integer [][] table = new Integer[values.size()][capacity + 1];
       for(int row = 0;row<=thing;row++)
       {
           for(int column = 0;column<=capacity;column++)
           {
               if(row == 0 && column - weights.get(row) >= 0) table[row][column] = values.get(row);
               else if(row > 0 && column - weights.get(row) >= 0) table[row][column] = Math.max(table[row -1][column], table[row -1][column - weights.get(row)] + values.get(row));
           }
       }
       return table[thing][capacity];
    }
    public static void main(String[] args) {
        memo = new Integer[5][14];
        List<Integer> values = new ArrayList<>(Arrays.asList(3,5,2,4,3));
        List<Integer> weights = new ArrayList<>(Arrays.asList(2,3,1,5,3));
        System.out.println("Problem plecakowy - classic");
        System.out.println(kapsack_classic(0,13, values, weights));
        System.out.println("Problem plecakowy - top - down");
        System.out.println(kapsack_top_down(0,13, values, weights));
        System.out.println("Problem plecakowy - bottom - up");
        System.out.println(kapsack_bottom_up(0,13, values, weights));
        
    }
}
