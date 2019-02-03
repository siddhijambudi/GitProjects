package TreeHomework;

public class BinaryTree {
    Node root;
    Node bintree2listUtil(Node node) {

        //base condition
        if (node == null) {
            return node;
        }

        //put left subtree in stack
        if (node.left != null) {
            Node left = bintree2listUtil(node.left);

            //find right most child of left subtree
            for (; left.right != null; left = left.right) ;

            //create a link between either inorder predecessor and root or
            //create a link between left and root
            left.right = node;
            node.left = left;
        }

        //put right subtree in stack
        if (node.right != null) {

            Node right = bintree2listUtil(node.right);

            //find left most child of right subtree
            for (; right.left != null; right = right.left) ;

            right.left = node;
            node.right = right;
        }

        return node;
    }

    Node bintree2list(Node node)
    {
        //base condition
        if (node == null) {
            return node;
        }

        //start with root
        node = bintree2listUtil(node);

        Node ultimateRoot = node;
        Node leftMostNode = null;
        Node rightMostNode = null;

        //go to the head which is left most node of tree to print
        while (ultimateRoot.left != null) {
            ultimateRoot = ultimateRoot.left;
        }
        leftMostNode = ultimateRoot;

        //go to the tail
        while (ultimateRoot.right != null) {
            ultimateRoot = ultimateRoot.right;
        }
        rightMostNode = ultimateRoot;


        Node temp = leftMostNode;

        leftMostNode.left = rightMostNode;
        rightMostNode.right = temp;

        return leftMostNode;
    }

    void printListMoveRight(Node node)
    {
        //move to the right
        Node tempHead = node;
        do
        {
            System.out.print(node.val + " ");
            node = node.right;

        }while(node != tempHead);

    }
    void printListMoveLeft(Node node)
    {
        //move to the right
        Node tempHead = node;
        do
        {
            node = node.left;
            System.out.print(node.val + " ");
        }while (node != tempHead);
    }
}