import java.util.ArrayList;

public class Node {

    private boolean visited;
    private int distanceFromSource;
    private ArrayList<Integer> pathFromSource;
    private ArrayList<Edge> edges;

    public Node() {
        this.visited = false;
        this.distanceFromSource = Integer.MAX_VALUE;
        this.edges = new ArrayList<>();
        this.pathFromSource = new ArrayList<>();
        pathFromSource.add(0);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public ArrayList<Integer> getPathFromSource() {
        return pathFromSource;
    }

    public void setPathFromSource(ArrayList<Integer> pathFromSource) {
        this.pathFromSource = pathFromSource;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public void addPathEntry(int i) {
        this.pathFromSource.add(i);
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
}
