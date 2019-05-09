package GraphHomework;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String args[]){

        Vertex root = new Vertex(1);
        Vertex left = new Vertex(2);
        Vertex right = new Vertex(3);

        List<Vertex> neighbours = new ArrayList<>();
        neighbours.add(left);
        neighbours.add(right);
        root.addNeighbours(neighbours);

        List<Vertex> neighbours1 = new ArrayList<>();
        neighbours1.add(root);
        neighbours1.add(right);
        left.addNeighbours(neighbours1);

        List<Vertex> neighbours2 = new ArrayList<>();
        neighbours1.add(root);
        neighbours1.add(left);
        right.addNeighbours(neighbours2);

        List<Vertex> listOfAdjacency = new ArrayList<>();
        listOfAdjacency.add(root);
        listOfAdjacency.add(left);
        listOfAdjacency.add(right);

        dfs(listOfAdjacency);

    }
    static void dfs(List<Vertex> adjecencyList){
        List<Integer> seen = new ArrayList();
        for(Vertex curr : adjecencyList){
            if(!seen.contains(curr.getLabel())){
                List<Integer> comp = new ArrayList<>();
                explore(curr, seen, comp);
                print(comp);
            }
        }
    }
    static void explore(Vertex curr, List<Integer> seen, List<Integer> comp){
        seen.add(curr.getLabel());
        comp.add(curr.getLabel());

        for(Vertex next : curr.getNeighbours()){
            if(!seen.contains(next.getLabel())){
                explore(next, seen, comp);
            }
        }
    }
    static void print(List<Integer> comp){
        for(Integer i : comp){
            System.out.print(i + " ");
        }
    }
}
