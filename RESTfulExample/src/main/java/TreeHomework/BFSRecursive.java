package TreeHomework;

public class BFSRecursive {
    public static void main(String args[]){
        Node root = createTree();
        bfs(root);
    }
    public static void bfs(Node root){
        int height = height(root);
        for(int i = 1; i <= height; i ++){
            bfs(root, i);
        }
    }
    public static void bfs(Node root, int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.val + " ");
        }
        bfs(root.left, level - 1);
        bfs(root.right, level - 1);
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public static Node createTree(){
        Node root = new Node(10);
        //root.val = 5;

        Node left = new Node(20);
        //left.val = 1;
        root.left = left;

        Node right = new Node(50);
        //right.val = 5;
        root.right = right;

        Node left_2 = new Node(30);
        //left_2.val = 5;
        root.left.left = left_2;

        Node right_2 = new Node(40);
        //right_2.val = 5;
        root.left.right = right_2;

        return root;
    }
}
