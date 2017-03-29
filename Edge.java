
/**
 * Created by Unity ID :Abhina and Name : Abhinav Ashish on 9/5/2016.
 */

import java.util.ArrayList;
public class Edge{
    private Vertex firstVertex;
    private Vertex secondVertex;
    int weight;
    int hashCode;

    Edge (Vertex firstVertex,Vertex secondVertex, int weight){
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.weight = weight;
        this.hashCode = ((firstVertex.getLabelOfVertex()+ secondVertex.getLabelOfVertex()).hashCode());
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }
    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(Vertex secondVertex) {
        this.secondVertex = secondVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
