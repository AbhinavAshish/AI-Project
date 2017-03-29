import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Unity ID :Abhina and Name : Abhinav Ashish on 9/5/2016.
 */

public class SearchRomania {


    public static void main(String args[]) {

        String searchType= args[0];
        String srccityName=args[1];
        String destcityName=args[2];




        RoadMap roadMap = new RoadMap();
        Graph road = roadMap.getRoadMapGraph();
        Searches S = new Searches();
        LinkedList<String> answer;

        if (searchType.equals("DFS")){
            System.out.println(" DFS for "+ srccityName + " "+ destcityName );
            answer= S.depthFirstSearchPath(srccityName, destcityName, road);
        }else if (searchType.equals("BFS")){
            System.out.println(" BFS for "+ srccityName + " "+ destcityName );
            answer = S.breadthFirstSearchPath(srccityName, destcityName, road);
        }else {
            answer = new LinkedList<String>();
            answer.add("Wrong search Type");
        }

        for (String i : answer) {
            System.out.print(i + ",");
        }

    }
}
