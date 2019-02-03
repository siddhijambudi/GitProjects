package TreeHomework;

public class KthSmallestInSortedArray {
    public static void main(String args[]){

        TreeNode treeNode = new TreeNode(10);

        treeNode.left_ptr = new TreeNode(2);
        treeNode.right_ptr = new TreeNode(20);

        treeNode.left_ptr.left_ptr = new TreeNode(1);
        treeNode.left_ptr.right_ptr = new TreeNode(3);

        treeNode.right_ptr.left_ptr = new TreeNode(12);
        treeNode.right_ptr.right_ptr = new TreeNode(25);

        System.out.println(kth_smallest_element(treeNode, 5));
    }
    static int kth_smallest_element(TreeNode root, int k) {
        TreeNode ultimateRoot = recur(root);

        //go to head
        TreeNode head;
        while(ultimateRoot.left_ptr != null){
            ultimateRoot = ultimateRoot.left_ptr;
        }
        head = ultimateRoot;

        //traverse through new linkedlist and put values in array
        int index = 0;
        while(head != null){
            if((index + 1) == k){
                return head.val;
            }
            head = head.right_ptr;
            index ++;
        }
        return -999;
    }

    //linklist is done
    static TreeNode recur(TreeNode root){

        if (root == null) {
            return root;
        }

        //left subtree and check inorder predessor and create int array
        if(root.left_ptr != null){
            //start from extreme left as head
            TreeNode left = recur(root.left_ptr);

            //find predessor
            for(;left.right_ptr != null; left = left.right_ptr);

            //if found use it not then just use left node as predessessor
            left.right_ptr = root;
            //root.left_ptr = left;
        }
        //right subtree
        if(root.right_ptr != null){
            TreeNode right = recur(root.right_ptr);

            //find sucssessor - left most child of right subtree
            for(;right.left_ptr != null; right = right.left_ptr);

            right.left_ptr = root;
            //root.right_ptr = right;
        }
        return root;
    }
    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };
}

