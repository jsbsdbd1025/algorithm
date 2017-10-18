package DataStructure.heap;

/**
 *  树的形式实现最大堆 并进行排序ß
 */
public class Heap {

    Node root;

    int[] a;

    public Heap(int[] a) {

        int len = a.length;

        for (int i = 0; i < len; i++) {
            root = createTree(0, len - i);

            int t = a[0];
            a[0] = a[len - 1 - i];
            a[len - 1 - i] = t;

        }

        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private Node createTree(int pos, int size) {
        if (pos >= size)
            return null;

        Node parent = new Node();
        parent.pos = pos;

        parent.left = createTree(pos * 2 + 1, size);
        parent.right = createTree(pos * 2 + 2, size);

        maxHead(parent);
        return parent;
    }

    private void maxHead(Node parent) {

        if (parent == null)
            return;

        int maxpos = parent.pos;
        if (parent.left != null && a[parent.left.pos] > a[maxpos]) {
            maxpos = parent.left.pos;
        }

        if (parent.right != null && a[parent.right.pos] > a[maxpos]) {
            maxpos = parent.right.pos;
        }

        int t = a[parent.pos];
        a[parent.pos] = a[maxpos];
        a[maxpos] = t;

        maxHead(parent.left);
        maxHead(parent.right);
    }

    private void query(Node parent) {
//        System.out.print(parent.num + " ");

        if (parent.left != null)
            query(parent.left);
        if (parent.right != null)
            query(parent.right);
    }
}
