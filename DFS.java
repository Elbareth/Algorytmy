
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.util.*;
public class Main
{
    public static void DFS(Map<String, List<String>> graph, String statringNode)
    {
        Stack<String> stack = new Stack<>();
        stack.push(statringNode);
        List<String> visited = new ArrayList<>();
        while(!stack.empty())
        {
            String vertex = stack.pop();
            visited.add(vertex);
            System.out.println(vertex);
            for(String neighbour : graph.get(vertex))
            {
                if(!visited.contains(neighbour))
                {
                    stack.push(neighbour);
                }
            }
        }
        //System.out.println(visited);
    }
    public static void main(String[] args) {
        Map<String, List<String>> cities = new HashMap<>();
        cities.put("Warszawa", Arrays.asList("Berlin", "Kolonia"));
        cities.put("Berlin", Arrays.asList("Warszawa", "Chicago"));
        cities.put("Chicago", Arrays.asList("Berlin"));
        cities.put("Kolonia", Arrays.asList("Warszawa", "Madryt", "Londyn"));
        cities.put("Madryt", Arrays.asList("Kolonia", "Nowy Jork", "Londyn"));
        cities.put("Nowy Jork", Arrays.asList("Madryt", "Londyn", "Tokio"));
        cities.put("Londyn", Arrays.asList("Kolonia", "Nowy Jork", "Madryt", "Tokio"));
        cities.put("Tokio", Arrays.asList("Nowy Jork", "Londyn"));
        DFS(cities, "Warszawa");
        
    }
}
