package DataStructure.tree.binarysearchtree;

public class Main {


    public static void main(String[] args) {

        int[] a = new int[]{8, 7, 15, 11, 9, 10, 16};

        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

//        System.out.println(String.valueOf(tree.search(2)));
//
//        System.out.println(String.valueOf(tree.search(1)));

        tree.inOrder(tree.root);

        tree.delete(8);
        System.out.println();
        tree.inOrder(tree.root);


//        System.out.println(String.valueOf(tree.min(tree.root).num));
//
//        System.out.println(String.valueOf(tree.max(tree.root).num));

    }

}
