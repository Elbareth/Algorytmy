
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.util.*;
public class Main
{
    private static List<Integer> mementoTopDown = new ArrayList<>();
    public static Integer fibonacci_bottom_up(Integer n)
    {
        List<Integer> mementoBottomUp = new ArrayList<>();
        for(int i = 0;i<=n;i++)
        {
            if(i==0) mementoBottomUp.add(i, 0);
            else if(i==1) mementoBottomUp.add(i, 1);
            else{
                mementoBottomUp.add(i, mementoBottomUp.get(i-1) + mementoBottomUp.get(i-2));
            }
        }
        return mementoBottomUp.get(n);
    }
    public static Integer fibonacci_top_down(Integer n)
    {
        if(mementoTopDown.size() > n) return mementoTopDown.get(n);
        if(n==0) return 0;  
        else if(n<=2) return 1;
        else{
            mementoTopDown.add(n, fibonacci_top_down(n-1) + fibonacci_top_down(n-2));
        }
        return mementoTopDown.get(n);
    }
    public static Integer fibonacci_classic(Integer n)
    {
        if(n==0) return 0;
        if(n<=2) return 1;
        return fibonacci_classic(n-1) + fibonacci_classic(n-2);
    }
    public static void main(String[] args) {
        mementoTopDown.add(0,0);
        mementoTopDown.add(1,1);
        mementoTopDown.add(2,1);
        System.out.println("Fibonacci Classic");
        System.out.println(fibonacci_classic(7));
        System.out.println("Fibonacci Top - down");
        System.out.println(fibonacci_top_down(7));
        System.out.println("Fibonacci Bottom - Up");
        System.out.println(fibonacci_bottom_up(7));
        
    }
}
