package TreeHomework;

public class ConstructBSTFromSortedArray {
    public static void main(String args[]){
        int[] array = new int[] {1,2,3,10,12,20,25};

        Node tree = BST(array, 0, array.length - 1);

        //print
        preOrder(tree);

    }
    static void preOrder(Node tree){
        if(tree == null){
            return;
        }
        preOrder(tree.left);
        System.out.print(tree.val + " ");
        preOrder(tree.right);
    }
    static Node BST(int[] array, int start, int end){

        if(start > end){
            return null;
        }
        int mid = (end + start) / 2;
        Node node = new Node(array[mid]);

        node.left = BST(array, start, mid  - 1);
        node.right = BST(array, mid + 1, end);

        return node;
    }
}
