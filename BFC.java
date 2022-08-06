
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.util.*;
public class Main
{
    public static void BFS(Map<String, List<String>> graph, String statringNode)
    {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(statringNode));
        List<String> visited = new ArrayList<>();
        Map<String, Integer> levels = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        levels.put(statringNode, 0);
        while(queue.size() != 0)
        {
            String vertex = queue.pop();
            visited.add(vertex);
            for(String neighbour : graph.get(vertex))
            {
                if(!visited.contains(neighbour))
                {
                    queue.push(neighbour);
                    if(!prev.containsKey(neighbour))
                    {
                        prev.put(neighbour,vertex);
                        levels.put(neighbour,levels.get(vertex) + 1);
                    }
                }
            }
        }
        System.out.println(visited);
        System.out.println("--------------------------------------");
        System.out.println(levels);
        System.out.println("--------------------------------------");
        System.out.println(prev);
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
        BFS(cities, "Warszawa");
        
    }
}
