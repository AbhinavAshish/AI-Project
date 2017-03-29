import java.io.File;
import java.util.ArrayList;

/**
 * Created by Unity ID :Abhina and Name : Abhinav Ashish on 9/5/2016.
 */

public class RoadMap{
    private Graph road;

    RoadMap(){
        FileReaderForRoadMap fileReaderForRoadMap = new FileReaderForRoadMap("roads.pl");
        ArrayList<Vertex> vertexGroup = fileReaderForRoadMap.getVertexGroup();
        ArrayList<Edge> edgeGroup = fileReaderForRoadMap.getEdgeGroup();
        road = new Graph(vertexGroup,edgeGroup);
    }

    public Graph getRoadMapGraph(){
        return road;
    }


}
