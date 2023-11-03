import java.io.*;
import java.util.*;

public class joinStrings {
    public static class Node {
        private String value;
        private Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numofStrings = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[numofStrings + 1];
        Node[] lastNodes = new Node[numofStrings + 1];

        // initialize the nodes array with N strings
        for (int i = 1; i <= numofStrings; i++) {
            nodes[i] = new Node(br.readLine());
            lastNodes[i] = nodes[i];
        }

        // N-1 operations
        for (int i = 1; i < numofStrings; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            Node Sa = nodes[a];
            Node Sb = nodes[b];

            // link Sb node next to the last node of Sa
            lastNodes[a].next = Sb;
            lastNodes[a] = lastNodes[b];

            nodes[b] = null;
            lastNodes[b] = null;
        }

        // print the last remaining string
        for (int i = 1; i <= numofStrings; i++) {
            if (nodes[i] != null) {
                Node node = nodes[i];
                while (node != null) {
                    System.out.print(node.value);
                    node = node.next;
                }
                break;
            }
        }

        br.close();
    }
}
