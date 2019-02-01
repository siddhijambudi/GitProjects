package TreeHomework;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversalDriver {
    public static void main(String[] args){
        Node tree = createTree();
        PostOrderTraversalIterator iterator = new PostOrderBinaryTreeIteratorImpl(tree);
        List<Integer> listOfPostOrderValues = new ArrayList<>();
        while(iterator.hasNext()){
            listOfPostOrderValues.add(iterator.next());
        }
        for(Integer i : listOfPostOrderValues){
            System.out.print(i + " ");
        }
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
}
