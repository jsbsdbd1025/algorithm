package DataStructure.tree.AVL;

import DataStructure.tree.Node;

/**
 * 各结点左右子树高度差不能大于2
 * 插入情况
 * 1.左结点的左子树插入
 * <p>
 * *       8                    8
 * *      / \     插入4        / \
 * *     6  15   ----->      6  15
 * *    /                   /
 * *   5                   5
 * *                      /
 * *                     4
 * 6的左子树高2  右子树高0   需要对结点6进行右旋调整
 * 调整后
 * *          8                       8
 * *         / \     结点6右旋        / \
 * *        6  15   --------->      5  15
 * *       /                       / \
 * *      5                       4  6
 * *     /
 * *    4
 * ******************************************************
 * <p>
 * *       8                    8
 * *      / \     插入3        / \
 * *     5  15   ----->      5  15
 * *    / \                 / \
 * *   4  6                4   6
 * *                      /
 * *                     3
 * 8 的 左结点5 上提 到 8 的位置 进行右旋
 * 将 5 的右孩子作为 8 的左孩子
 * <p>
 * *          8                       5 - 8                               5
 * *         / \     结点5右旋        / \  \     5的右孩子作为8的左孩子      / \
 * *        5  15   --------->      4  6  15   -------------------->    4  8
 * *       / \                     /                                   /  / \
 * *      4   6                   3                                   3  6  15
 * *     /
 * *    3
 * <p>
 * <p>
 * <p>
 * 2.左结点的右子树插入
 * <p>
 * *       8                    8
 * *      / \     插入7        / \
 * *     5  15   ----->      5  15
 * *    / \                 / \
 * *   4  6                4   6
 * *                            \
 * *                             7
 * <p>
 * 5的右子树高2  左子树高0   需要对结点5进行左旋调整    再将结点
 * 调整后
 * *          8                       8                       6
 * *         / \     结点6左旋        / \       结点6右旋      / \
 * *        5  15   --------->      6  15     --------->    5  8
 * *       / \                     / \                     /  / \
 * *      4   6                   5   7                   4  7  15
 * *           \                 /
 * *            7               4
 * <p>
 * 3.右结点的左子树插入
 * <p>
 * *       8                    8
 * *      / \     插入13        / \
 * *     5  15   ------>      5  15
 * *       /                    /
 * *     12                   12
 * *                            \
 * *                            13
 * <p>
 * <p>
 * 调整后
 * *          8                        8                        12
 * *         / \     结点12右旋        / \       结点12左旋       / \
 * *        5  15   ---------->      6  12     ---------->     8  15
 * *          /                          \                    /  /
 * *         12                          15                  6  13
 * *          \                          /
 * *          13                        13
 */

public class AVLTree {

    Node root;


    public AVLTree() {

    }

    public void insert(int num) {

        if (root == null) {
            root.num = num;
            return;
        }

        if (num < root.num) {

            root.left = insert(root.left, num);

        } else {

            root.right = insert(root.right, num);

        }

        root.height = Math.max(root.left.height, root.right.height) + 1;
    }

    private Node insert(Node node, int num) {
        if (node == null) {
            node = new Node(node, num);
            return node;
        }

        if (num < node.num) {
            node.left = insert(node.left, num);

            if (Math.abs(node.left.height - node.right.height) >= 2) {
                if (num < node.left.num) {
                    node = LL(node);
                } else {
                    node = LR(node);
                }
            }


        } else {
            node.right = insert(node.right, num);

            if (Math.abs(node.left.height - node.right.height) >= 2) {
                if (num > node.right.num) {
                    node = RR(node);
                } else {
                    node = RL(node);
                }
            }
        }

        node.height = Math.max(node.left.height, node.right.height) + 1;
        return node;
    }


    private Node LL(Node y) {


        Node x = y.left;
        y.left = x.right;
        x.right = y;


        x.height = Math.max(x.left.height, x.right.height) + 1;

        return x;
    }


    private Node RR(Node y) {

        Node x = y.right;
        y.right = x.left;
        x.left = y;


        x.height = Math.max(x.left.height, x.right.height) + 1;

        return x;

    }

    private Node LR(Node y) {

        y.left = LL(y.left);

        return RR(y);

    }

    private Node RL(Node y) {

        y.right = RR(y.right);

        return LL(y);

    }

    /**
     *
     * @param node
     * @param num
     *
     * 左右子树都存在时，
     * 当左子树较高时，找左子树的最大值替换根结点，删除最大值
     * 当右子树较高时，找右子树当最小值替换根结点，删除最小值
     */

    public void delete(Node node, int num) {

//        if (node == null) {//不存在
//        } else if (node.left == null && node.right == null) {//无子结点
//            node = null;
//        } else if (node.left == null) {//只有右结点
//            node = node.right;
//        } else if (node.right == null) {//只有左结点
//            node = node.left;
//        } else {
//
//            if (node.left.height > node.right.height) {
//
//            } else {
//
//            }
//
//        }
    }

    public Node max(Node n) {
        if (n == null)
            return null;

        if (n.right != null) {
            return max(n.right);
        }

        return n;
    }


    public Node min(Node n) {
        if (n == null)
            return null;

        if (n.left != null) {
            return min(n.left);
        }

        return n;
    }

}
