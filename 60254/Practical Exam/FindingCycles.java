import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

class Vertex {
    char data;
    Vertex parent;
    boolean inProgress;

    public Vertex(char data) {
        this.data = data;
        inProgress = false;
    }
    public String toString() {
        return data + "";
    }

}


class Graph {
    private HashMap<Character, LinkedList<Character>> adjacencyList;
    private HashMap<Character, Character> parent = new HashMap<Character,Character>();
    private HashMap<Character, Boolean> inProgress = new HashMap<Character,Boolean>();
    private Vertex[] arrVertex;
    private HashSet<HashSet<Character>> cycles;

    public Graph(HashMap adjacencyList) {

        this.adjacencyList = adjacencyList;
        arrVertex = new Vertex[adjacencyList.keySet().size()];
        cycles = new HashSet<>();

    }

    public void initializeVertex() {

        int index = 0;

        for (char i : adjacencyList.keySet()){
            arrVertex[index] = new Vertex(i);
            index++;
        }

    }

    public void DFSVisit(char s) {
        inProgress.put(s,true);
        //System.out.print(s + " ");
        for(char v: adjacencyList.get(s)) {
            //System.out.println(s + " --> " + v);
            if(inProgress.containsKey(v) && inProgress.get(v)){
                HashSet<Character> currentCycle = new HashSet<>();
                Vertex current = arrVertex[(int)(v -'a')];
                //currentCycle.add(current.data);
                int parents = 0;
                while (current.parent != null) {
                    currentCycle.add(current.data);
                    //System.out.print(current + " ");
                    current = current.parent;
                    parents++;
                }
                currentCycle.add(current.data);
                //System.out.println(current + " " + parents);
                if(parents > 1){
                    cycles.add(currentCycle);
                }

            }
            if(!parent.containsKey(v)) {
                //System.out.print(s + " ");
                parent.put(v,s);
                arrVertex[(int)(s - 'a')].parent = arrVertex[(int)(v - 'a')];
                DFSVisit(v);
            }
        }
        inProgress.put(s,false);
    }
    public void dfs() {
        //parent.clear();
        //for (char i: adjacencyList.keySet()) {
        for (int j = 0; j < adjacencyList.keySet().size(); j++) {
            parent.clear();
            initializeVertex();
            for (int i = 0; i < adjacencyList.keySet().size(); i++) {
                i = (i + j) % adjacencyList.keySet().size();
                if (!parent.containsKey((char) ((int) 'a' + i))) {
                    parent.put((char) ((int) 'a' + i), null);
                    DFSVisit((char) ((int) 'a' + i));
                }
            }
        }

        /*
        for (char s: adjacencyList.keySet()) {
            if (!parent.containsKey(s)) {
                parent.put(s, null);
                DFSVisit(s);
            }
        }*/
       // }
        //System.out.println(count);
        System.out.println(cycles);
        System.out.println(cycles.size());

    }
}
public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{0,1,1,1,1},{1,0,1,0,0},{1,1,0,1,0},{1,0,1,0,1},{1,0,0,1,1}};
        //int[][] matrix = {{1,1,0,1},{0,1,0,0},{1,0,1,0},{0,1,0,1}};

        /*Scanner sc = new Scanner(System.in);
        String currentLine = sc.nextLine();
        int size = currentLine.length();
        int[][] matrix = new int[size][size];
        String[] splitLine = currentLine.replaceAll("\\s","").split(",");
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                matrix[i][j] = Integer.parseInt(splitLine[i]);
            splitLine = sc.nextLine().replaceAll("\\s","").split(",");
        }*/

        HashMap<Character, LinkedList<Character>> adjacencyList = new HashMap<Character, LinkedList<Character>>();

        for (int i = 0; i < matrix.length ; i++) {
            char key = (char)((int)'a' + i);
            LinkedList<Character> adjacentVertecies = new LinkedList<>();
            for (int j = 0; j < matrix.length ; j++) {
                if (matrix[i][j] == 1) {
                    adjacentVertecies.add((char)((int)'a' + j));
                }
            }
            adjacencyList.put(key, adjacentVertecies);
        }

        //System.out.println(adjacencyList.entrySet());
        Graph test = new Graph(adjacencyList);
        test.dfs();

    }
}