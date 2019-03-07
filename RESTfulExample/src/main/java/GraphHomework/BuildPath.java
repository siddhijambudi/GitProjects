package GraphHomework;

import java.util.*;

public class BuildPath {
    public static void main(String args[]){
        Vertex V_1 = new Vertex(1);

        Vertex V_2 = new Vertex(2);
        Vertex V_3 = new Vertex(3);

        Vertex V_4 = new Vertex(4);
        Vertex V_5 = new Vertex(5);

        Vertex V_6 = new Vertex(6);

        List<Vertex> neighbours = new ArrayList<>();
        neighbours.add(V_2);
        neighbours.add(V_3);
        V_1.addNeighbours(neighbours);

        List<Vertex> neighbours1 = new ArrayList<>();
        neighbours1.add(V_1);
        neighbours1.add(V_4);
        V_2.addNeighbours(neighbours1);

        List<Vertex> neighbours2 = new ArrayList<>();
        neighbours2.add(V_1);
        neighbours2.add(V_5);
        V_3.addNeighbours(neighbours2);

        List<Vertex> neighbours3 = new ArrayList<>();
        neighbours3.add(V_2);
        neighbours3.add(V_6);
        V_4.addNeighbours(neighbours3);

        List<Vertex> neighbours4 = new ArrayList<>();
        neighbours4.add(V_3);
        neighbours4.add(V_6);
        V_5.addNeighbours(neighbours4);

        List<Vertex> neighbours5 = new ArrayList<>();
        neighbours5.add(V_4);
        neighbours5.add(V_5);
        V_6.addNeighbours(neighbours5);

        List<Vertex> listOfAdjacency = new ArrayList<>();
        listOfAdjacency.add(V_1);
        listOfAdjacency.add(V_2);
        listOfAdjacency.add(V_3);
        listOfAdjacency.add(V_4);
        listOfAdjacency.add(V_5);
        listOfAdjacency.add(V_6);

        for(Integer value : buildPath(V_1, V_6)){
            System.out.print(value + " ");
        }
    }
    static List<Integer> buildPath(Vertex start, Vertex target){
       Map<Integer, Integer> seenToPrevMap = new HashMap();
       seenToPrevMap.put(start.label, null);

       List<Integer> result = new ArrayList<>();

       Queue<Vertex> q = new LinkedList<>();
       q.add(start);

       while(!q.isEmpty()){
           Vertex curr = q.poll();
           if(curr.label == target.label){
               result.add(curr.label);
               buildPath(seenToPrevMap, curr.label, result);
               Collections.reverse(result);
               return result;
           }
           else{
               for(Vertex next : curr.neighbours){
                   if(!seenToPrevMap.containsKey(next.label)){
                       seenToPrevMap.put(next.label, curr.label);
                       q.add(next);
                   }
               }
           }
       }
       return null;
    }
    static void buildPath(Map<Integer, Integer> seenToPrevMap, int curr, List<Integer> result){
        Integer prev = seenToPrevMap.get(curr);
        if(prev != null){
            result.add(prev);
            buildPath(seenToPrevMap, prev, result);
        }
    }
}

