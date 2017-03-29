    import java.util.*;


    /**
     * Created by Unity ID :Abhina and Name : Abhinav Ashish on 9/5/2016.
     */
    public class Searches {

        public LinkedList<String> breadthFirstSearchPath(String vertexOne,String vertexTwo, Graph road){

            Vertex vertOne = road.getVertexGroup().get(vertexOne);
            Vertex vertTwo =road.getVertexGroup().get(vertexTwo);
            Vertex vertCurrent = vertOne;

            LinkedList<LinkedList<String>> path= new LinkedList<LinkedList<String>>();

            LinkedList<String> samplePath = new LinkedList<String>();
            samplePath.add(vertOne.getLabelOfVertex());
            path.add(samplePath);

            ArrayList<Edge> lastNodes= new ArrayList<Edge>();

            while (!path.isEmpty()){
                samplePath=path.pop();
                String val= samplePath.getLast();
                vertCurrent= road.getVertexGroup().get(val);
                lastNodes=vertCurrent.getEdgesOfTheVertex();
                lastNodes= getOrderedEdges(lastNodes,vertCurrent);

                for(Edge E: lastNodes) {
                    Vertex vertTemp;
                    if (vertCurrent.getLabelOfVertex().equals(E.getFirstVertex().getLabelOfVertex())) {
                        vertTemp = E.getSecondVertex();
                    } else {
                        vertTemp = E.getFirstVertex();
                    }
                    if(samplePath.contains(vertTemp.getLabelOfVertex())){
                      continue;
                    }

                    LinkedList<String> newSamplePath = new LinkedList<String>();
                    for(String i: samplePath){
                        newSamplePath.add(i);
                    }
                    newSamplePath.add(vertTemp.getLabelOfVertex());
                    if (vertTemp.getLabelOfVertex().equals(vertTwo.getLabelOfVertex())) {
                        return newSamplePath;
                    }
                    path.add(newSamplePath);


                }
            }
            LinkedList<String>noPath= new LinkedList<String>();
            noPath.add("No Path Found");
            return noPath;
        }


        public  LinkedList<String> depthFirstSearchPath(String vertexOne,String vertexTwo, Graph road){

            Vertex vertOne = road.getVertexGroup().get(vertexOne);
            Vertex vertTwo =road.getVertexGroup().get(vertexTwo);
            Vertex vertCurrent = vertOne;

            LinkedList<LinkedList<String>> path= new LinkedList<LinkedList<String>>();
            LinkedList<String> samplePath = new LinkedList<String>();
            samplePath.add(vertOne.getLabelOfVertex());
            path.add(samplePath);
            ArrayList<Edge> lastNodes= new ArrayList<Edge>();


            while (!path.isEmpty()){
                samplePath=path.pop();

                String val= samplePath.getLast();
                vertCurrent= road.getVertexGroup().get(val);
                lastNodes=vertCurrent.getEdgesOfTheVertex();
                lastNodes= getReverseOrderedEdges(lastNodes, vertCurrent);
                Vertex vertTemp= null;

                if (vertCurrent.getLabelOfVertex().equals(vertTwo.getLabelOfVertex())) {
                    return samplePath;
                }

                for(Edge E: lastNodes) {

                    LinkedList<String> newSamplePath = new LinkedList<String>();

                    if (vertCurrent.getLabelOfVertex().equals(E.getFirstVertex().getLabelOfVertex())) {
                        vertTemp = E.getSecondVertex();
                    } else {
                        vertTemp = E.getFirstVertex();
                    }

                    if(samplePath.contains(vertTemp.getLabelOfVertex())){
                        continue;
                    }


                    for(String i: samplePath){
                        newSamplePath.add(i);
                    }

                    newSamplePath.add(vertTemp.getLabelOfVertex());

                    path.push(newSamplePath);

                }


            }
            LinkedList<String>noPath= new LinkedList<String>();
            noPath.add("No Path Found");
            return noPath;

        }


        public ArrayList<Edge> getOrderedEdges(ArrayList<Edge> edgeArray,Vertex vertCurrent){

            ArrayList<Edge> orderedEdgesForUse = new ArrayList<Edge>();
            ArrayList<String> arrayList = new ArrayList<String>();
            HashMap<String, Edge>  temp = new HashMap<String,Edge>();

            for (Edge E:edgeArray){
                Vertex vertTemp;
                if (vertCurrent.getLabelOfVertex().equals(E.getFirstVertex().getLabelOfVertex())){
                    vertTemp= E.getSecondVertex();
                }
                else {
                    vertTemp= E.getFirstVertex();
                }
                temp.put(vertTemp.getLabelOfVertex(),E);
                arrayList.add(vertTemp.getLabelOfVertex());
            }
            Collections.sort(arrayList);
            for (String a : arrayList){
                orderedEdgesForUse.add(temp.get(a));
            }

            return orderedEdgesForUse;
        }

        public ArrayList<Edge> getReverseOrderedEdges(ArrayList<Edge> edgeArray,Vertex vertCurrent){

            ArrayList<Edge> orderedEdgesForUse = new ArrayList<Edge>();
            ArrayList<String> arrayList = new ArrayList<String>();
            HashMap<String, Edge>  temp = new HashMap<String,Edge>();

            for (Edge E:edgeArray){
                Vertex vertTemp;
                if (vertCurrent.getLabelOfVertex().equals(E.getFirstVertex().getLabelOfVertex())){
                    vertTemp= E.getSecondVertex();
                }
                else {
                    vertTemp= E.getFirstVertex();
                }
                temp.put(vertTemp.getLabelOfVertex(),E);
                arrayList.add(vertTemp.getLabelOfVertex());
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            for (String a : arrayList){
                orderedEdgesForUse.add(temp.get(a));
            }

            return orderedEdgesForUse;
        }
    }
