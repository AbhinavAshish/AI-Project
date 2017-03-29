import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Unity ID :Abhina and Name : Abhinav Ashish on 9/5/2016.
 */
public class FileReaderForRoadMap {
    private ArrayList<Edge> edgeGroup;
    private ArrayList<Vertex> vertexGroup;

    FileReaderForRoadMap(String fileName){
        edgeGroup = new ArrayList<Edge>();
        vertexGroup= new ArrayList<Vertex>();
        String line =null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            HashSet<String> cities= new HashSet<String>();

            while((line = bufferedReader.readLine()) != null) {
                if (line.contains("road(")&&!line.contains("road(City")){
                    String modifiedLine = line.replaceAll("\\s","");
                    String alpha = modifiedLine.substring(modifiedLine.indexOf('(')+1,modifiedLine.indexOf(')'));
                    String vertexOne = alpha.substring(0,alpha.indexOf(','));
                    cities.add(vertexOne);
                    Vertex vOne = new Vertex(vertexOne);
                    String vertexTwo= alpha.substring(alpha.indexOf(',')+1,alpha.indexOf(',',alpha.indexOf(',')+1));
                    cities.add(vertexTwo);
                    Vertex vTwo = new Vertex(vertexTwo);
                    String wieght= alpha.substring(alpha.indexOf(',',alpha.indexOf(',')+1)+1,alpha.length());
                    Edge E = new Edge(vOne,vTwo,Integer.valueOf(wieght));
                    edgeGroup.add(E);
                    String modLine= modifiedLine.substring(modifiedLine.indexOf('.')+1,modifiedLine.length());
                    if (modLine.contains("road(")&&!modLine.contains("road(City")){
                        String gamma = modLine.substring(modLine.indexOf('(')+1,modLine.indexOf(')'));


                        String vertexOneNew = gamma.substring(0,gamma.indexOf(','));
                        cities.add(vertexOneNew);
                        Vertex vOneNew = new Vertex(vertexOneNew);

                        String vertexTwoNew= gamma.substring(gamma.indexOf(',')+1,gamma.indexOf(',',gamma.indexOf(',')+1));
                        cities.add(vertexTwoNew);
                        Vertex vTwoNew = new Vertex(vertexTwoNew);

                        String wieghtNew = gamma.substring(gamma.indexOf(',',gamma.indexOf(',')+1)+1,gamma.length());
                        Edge ENew = new Edge(vOneNew,vTwoNew,Integer.valueOf(wieghtNew));
                        edgeGroup.add(ENew);
                    }
                }

            }
            for(String s : cities){
                Vertex v= new Vertex(s);
                vertexGroup.add(v);
            }
            bufferedReader.close();
        }     catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"
                    + fileName + "'");
        }


    }
    public ArrayList<Edge> getEdgeGroup(){
        return edgeGroup;
    }

    public ArrayList<Vertex> getVertexGroup() {
        return vertexGroup;
    }
}
