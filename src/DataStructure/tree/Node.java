package DataStructure.tree;

public class Node {
    public Node parent;
    public Node left;
    public Node right;
    public int num;
    public int height = -1;

    public Node(Node parent, int num) {
        this.parent = parent;
        this.num = num;
        height = parent.height + 1;
    }

}
