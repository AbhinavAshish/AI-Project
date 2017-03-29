
/**
 * Created by Unity ID :Abhina and Name : Abhinav Ashish on 9/5/2016.
 */

import java.util.ArrayList;

public class Vertex {

     private String label;
     private ArrayList<Edge> attachedVertex;

     Vertex( String label) {
         this.label= label;
         this.attachedVertex= new ArrayList<Edge> ();
     }

    public void setLabel(String label){
        this.label= label;
    }

    public String getLabelOfVertex(){
         return this.label;
     }

    public ArrayList<Edge> getEdgesOfTheVertex(){
         return this.attachedVertex;
     }

    public boolean addEdge(Edge E){
        if (attachedVertex.contains(E)){
            return false;
        }
        if (E.getFirstVertex().getLabelOfVertex().equals(this.label) ||E.getSecondVertex().getLabelOfVertex().equals(this.label)) {
            attachedVertex.add(E);
            return true;
        }else {
            return false;
        }

    }


}
