import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Unity ID :Abhina and Name : Abhinav Ashish on 9/5/2016.
 */

//Please note the structure of the graph is generic and hence the impelmentation in Java is similar to  the general edge vertex structure out on the web.

public class Graph {

    private HashMap<String, Vertex> vertexGroup;
    private HashMap<Integer, Edge> edgeGroup;

    public HashMap<Integer, Edge> getEdgeGroup() {
        return edgeGroup;
    }
    public void setEdgeGroup(HashMap<Integer, Edge> edgeGroup) {
        this.edgeGroup = edgeGroup;
    }



    public HashMap<String, Vertex> getVertexGroup() {
        return vertexGroup;
    }

    public void setVertexGroup(HashMap<String, Vertex> vertexGroup) {
        this.vertexGroup = vertexGroup;
    }


    Graph(ArrayList<Vertex> vertices,ArrayList<Edge> edges){
        vertexGroup = new HashMap<String, Vertex>();
        edgeGroup = new HashMap<Integer,Edge>();

        for (Vertex v: vertices) {
            if (!vertexGroup.containsKey(v.getLabelOfVertex())) {
                vertexGroup.put(v.getLabelOfVertex(), v);
            }
        }

        for (Edge E: edges){
                if (!edgeGroup.containsKey(E.getHashCode())){
                    edgeGroup.put(E.getHashCode(),E);
                    vertexGroup.get(E.getFirstVertex().getLabelOfVertex()).addEdge(E);
                    vertexGroup.get(E.getSecondVertex().getLabelOfVertex()).addEdge(E);
                }
        }

    }


}
