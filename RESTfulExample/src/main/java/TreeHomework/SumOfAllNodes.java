package TreeHomework;

public class SumOfAllNodes {
    public static void main(String args[]){
        Node root = new Node(5);
        //root.val = 5;

        Node left = new Node(1);
        //left.val = 1;
        root.left = left;

        Node right = new Node(5);
        //right.val = 5;
        root.right = right;

        Node left_2 = new Node(5);
        //left_2.val = 5;
        root.left.left = left_2;

        Node right_2 = new Node(5);
        //right_2.val = 5;
        root.left.right = right_2;

        Node right_3 = new Node(5);
        //right_3.val = 5;
        root.right.right = right_3;

        //List<Integer> count = new ArrayList<Integer>();
        System.out.print(checkSingleSubtree(root));
    }
    public static int checkSingleSubtree(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            //leaf node
            return 1;
        }
        int leftCount = checkSingleSubtree(root.left);
        int rightCount = checkSingleSubtree(root.right);

        /*if(leftCount == 0 || rightCount == 0){
            //subtree is not unival
            return 0;
        }*/
        if(root.left != null && root.right != null){
            //unival
            if(root.left.val == root.val && root.right.val == root.val){
                return leftCount + rightCount + 1;
            }
        }
        if(root.left != null && root.left.val == root.val){
            //unival
            return leftCount + rightCount + 1;
        }
        if(root.right != null && (root.right.val == root.val)){
            //unival
            return leftCount + rightCount + 1;
        }
        return leftCount + rightCount;
    }









    public static int recurSum(Node root){
        if(root == null){
            return 0;
        }
        int left = recurSum(root.left);
        int right = recurSum(root.right);
        return left + right + root.val;
    }
}
