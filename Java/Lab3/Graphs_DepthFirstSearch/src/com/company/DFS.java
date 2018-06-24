package com.company;

import java.util.HashMap;

/**
 * Created by sandrapapo on 2017-11-22.
 */
public class DFS {

    private static int count = 0;
    public static void main(String[] args) {
        Node a_node = new Node('a');
        Node b_node = new Node('b');
        Node c_node = new Node('c');
        Node d_node = new Node('d');
        Node e_node = new Node('e');

        // making the graph
        a_node.neighbors.put('b', b_node);
        a_node.neighbors.put('c', c_node);
        a_node.neighbors.put('d', d_node);
        a_node.neighbors.put('e', e_node);

        b_node.neighbors.put('a', a_node);
        b_node.neighbors.put('c', c_node);

        c_node.neighbors.put('a', a_node);
        c_node.neighbors.put('b', b_node);
        c_node.neighbors.put('d', d_node);

        d_node.neighbors.put('a', a_node);
        d_node.neighbors.put('c', c_node);
        d_node.neighbors.put('e', e_node);

        e_node.neighbors.put('a', a_node);
        e_node.neighbors.put('d', d_node);

        //
        visit(c_node);
        System.out.println(a_node.visited);

        if(!b_node.visited)
            visit(b_node);
        System.out.println(b_node.visited);
        if(!a_node.visited)
            visit(a_node);
        System.out.println(c_node.visited);
        if(!d_node.visited)
            visit(d_node);
        System.out.println(d_node.visited);
        if(!e_node.visited)
            visit(e_node);
        System.out.println(e_node.visited);

       // visit(a_node);
        //notVisited(a_node,b_node,c_node,d_node,e_node);
        //visit(c_node);
        //notVisited(a_node,b_node,c_node,d_node,e_node);
        //visit(d_node);
        //notVisited(a_node,b_node,c_node,d_node,e_node);
        //visit(e_node);
        System.out.println(count);

    }
    public static void notVisited(Node a, Node b, Node c, Node d, Node e) {

    }
    private static void visit(Node node) {
        node.inProgress = true;
        for (Character key : node.neighbors.keySet()) {
            System.out.println(node.data + " is visiting " + key);
            node.visited = true;
            if(node.neighbors.get(key).inProgress && node.neighbors.get(key) != node.parent){
                count++;
                Node current = node;
                while (current.parent != null) {
                    System.out.print(current);
                    current = current.parent;

                }
                System.out.println(node.neighbors.get(key));
            }
            if (!node.neighbors.get(key).visited) {
                node.neighbors.get(key).parent = node;
                visit(node.neighbors.get(key));
                node.visited = false;
            }
        }
        node.inProgress = false;
    }
}

class Node {
    Node parent;
    char data;
    boolean visited = false;
    boolean inProgress = false;
    HashMap<Character, Node> neighbors = new HashMap<>();

    Node(char data) {
        this.data = data;
    }
    public String toString() {
        return data + "";
    }


}
