package TreeHomework;

import java.awt.*;

public class PrintAllPathsInTree {
    public static void main(String args[]){
        Node root = createTree();
        int[] values = new int[height(root, 0)];
        recur(root, values, 0);
    }
    private static void recur(Node root, int[] values, int index){
        if(root == null){
            return;
        }
        values[index] = root.val;
        if(root.left == null && root.right == null){
            print(values);
        }
        recur(root.left, values, index + 1);
        recur(root.right, values, index + 1);
    }
    private static Node createTree(){

        Node root = new Node();
        root.val = 1;

        /***************************/
        Node left = new Node();
        left.val = 2;
        root.left = left;

        Node left_2 = new Node();
        left_2.val = 4;
        root.left.left = left_2;

        Node right_2 = new Node();
        right_2.val = 5;
        root.left.right = right_2;

        /***************************/


        Node right = new Node();
        right.val = 3;
        root.right = right;

        Node right_31 = new Node();
        right_31.val = 6;
        root.right.left = right_31;

        Node right_3 = new Node();
        right_3.val = 7;
        root.right.right = right_3;

        /***************************/

        return root;
    }
    private static void print(int[] values){
        System.out.println();
        for(int i : values) {
            System.out.print(i + " ");
        }
    }
    private static int height(Node root, int index){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left, index + 1);
        int rightHeight = height(root.right, index + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
