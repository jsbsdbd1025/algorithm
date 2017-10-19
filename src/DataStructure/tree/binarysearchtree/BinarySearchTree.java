package DataStructure.tree.binarysearchtree;

import DataStructure.tree.Node;

/**
 *
 * 删除结点示例
 * <p>
 * -------8                     9
 * -----/  \                   / \
 * --- 7   15                 7  15
 * ------ /  \                  /  \
 * -----11   16     -->       11   16
 * ----/                     /
 * ---9                     10
 * ----\
 * ----10
 */
public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
    }


    public void insert(int num) {
        if (root == null) {
            root = new Node(null, num);
        } else {
            insert(root, num);
        }
    }

    private Node insert(Node node, int num) {
        if (node == null) {
            node = new Node(node, num);
            return node;
        }

        if (num < node.num) {
            node.left = insert(node.left, num);
            node.left.parent = node;
        } else {
            node.right = insert(node.right, num);
            node.right.parent = node;
        }
        return node;
    }

    public boolean search(int num) {

        return query(root, num) != null;
    }

    private Node query(Node node, int num) {

        if (node == null || node.num == num)
            return node;


        if (num < node.num) {
            return query(node.left, num);
        } else {
            return query(node.right, num);
        }
    }

    public void delete(int num) {

        Node node = query(root, num);
        if (node == null) {//不存在
        } else if (node.left == null && node.right == null) {//无子结点
            node = null;
        } else if (node.left == null) {//只有右结点
            node = node.right;
        } else if (node.right == null) {//只有左结点
            node = node.left;
        } else {
            /*
            z的后继y  是 z的右孩子  将z的左孩子并到y的左子树（因为y是后继，所以不存在左子树）
            z的后继y不是 z的右孩子﻿﻿ 在这种情况下我们先用y的右孩子x代替y，然后再用y代替z:﻿
             */
            Node min = min(node.right);
            if (node.right == min) {
                node = node.right;
            } else {
                node.num = min.num;

                min.parent.left = min.right;
//                min.right = null;
            }

        }
    }

    public Node min(Node n) {
        if (n == null)
            return null;

        if (n.left != null) {
            return min(n.left);
        }

        return n;
    }

    public Node max(Node n) {
        if (n == null)
            return null;

        if (n.right != null) {
            return max(n.right);
        }

        return n;
    }


    public void inOrder(Node n) {
        if (n.left == null && n.right == null) {
            System.out.print(n.num + "");
            return;
        }

        if (n.left != null) {
            inOrder(n.left);
        }

        System.out.print(n.num + "");

        if (n.right != null) {
            inOrder(n.right);
        }

    }

}
