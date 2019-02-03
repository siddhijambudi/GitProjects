package TreeHomework;

public class ConvertBSTIntoCircularDoublyLinkList {
    public static void main(String args[]) {
        BinaryTree BinaryTree = new BinaryTree();
        BinaryTree.root = new Node(10);

        BinaryTree.root.left = new Node(2);
        BinaryTree.root.right = new Node(20);

        BinaryTree.root.left.left = new Node(1);
        BinaryTree.root.left.right = new Node(3);

        BinaryTree.root.right.left = new Node(12);
        BinaryTree.root.right.right = new Node(25);

        Node head = BinaryTree.bintree2list(BinaryTree.root);
        BinaryTree.printListMoveRight(head); System.out.print(" ==> "); BinaryTree.printListMoveLeft(head);
    }
}