package GraphHomework;

import java.util.List;

class Vertex{
    int label;
    List<Vertex> neighbours;

    public Vertex(int label) {
        this.label = label;
    }

    public Vertex(int label, List<Vertex> neighbours) {
        this.label = label;
        this.neighbours = neighbours;
    }

    public void addNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public int getLabel() {
        return label;
    }
}
