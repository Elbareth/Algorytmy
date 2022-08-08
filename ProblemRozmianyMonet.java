
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.util.*;
import static java.lang.Math.min;
public class Main
{
    private static Map<Integer, Integer> memo = new HashMap<>();
    public static Integer minCoinTopDown(List<Integer> coins, Integer value)
    {
        Integer shortestPath = null;
        for(Integer coin : coins)
        {
            Integer currentPath = 0;
            if(memo.containsKey(value - coin)) currentPath = memo.get(value - coin);
            else if(value - coin == 0) currentPath++;
            else if(value - coin > 0) currentPath += minCoinTopDown(coins, value - coin) + 1;
            else currentPath = Integer.MAX_VALUE;
            memo.put(value - coin, currentPath);
            if(shortestPath == null || shortestPath > currentPath) shortestPath = currentPath;
        }
        return shortestPath;
    }
    public static Integer minCoinBottomUp(List<Integer> coins, Integer value)
    {
        Map<Integer, Integer> memoBottomUp = new HashMap<>();
        for(int i=0;i<=value;i++)
        {
            memoBottomUp.put(i,Integer.MAX_VALUE);
        }
        memoBottomUp.replace(0,0);
        for(int i=0;i<=value;i++)
        {
            for(Integer coin : coins)
            {
                if(i-coin >= 0)
                {
                    memoBottomUp.replace(i, Math.min(memoBottomUp.get(i), memoBottomUp.get(i - coin) + 1));
                }
            }
        }
        return memoBottomUp.get(value);
    }
    public static Integer minCoinClassic(List<Integer> coins, Integer value)
    {
        Integer shortestPath = null;
        for(Integer coin : coins)
        {
            Integer currentPath = 0;
            if(value - coin == 0) currentPath++;
            else if(value - coin > 0) currentPath += minCoinClassic(coins, value - coin) + 1;
            else currentPath = Integer.MAX_VALUE;
            if(shortestPath == null || shortestPath > currentPath) shortestPath = currentPath;
        }
        return shortestPath;
    }
    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(5);
        coins.add(6);
        coins.add(9);
        System.out.println("Problem rozmiany monet  - classic");
        System.out.println(minCoinClassic(coins, 11));
        System.out.println("Problem rozmiany monet  - Bottom - Up");
        System.out.println(minCoinBottomUp(coins, 11));
        System.out.println("Problem rozmiany monet  - Top - Down");
        System.out.println(minCoinTopDown(coins, 11));
        
    }
}
