/**
 * Created by ashvinlohiya on 04-01-2017.
 */
public class Node implements Comparable<Node> {

    char character;
    int frequency;
    Node left;
    Node right;


    public Node(char character, int frequency, Node left, Node right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.frequency - o.frequency;
    }
}


