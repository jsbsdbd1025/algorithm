package DataStructure.tree.binarysearchtree;

public class Node {
    Node parent;
    Node left;
    Node right;
    int num;

    public Node(Node parent,int num) {
        this.parent = parent;
        this.num = num;
    }

}
