package TreeHomework;

import java.util.NoSuchElementException;
import java.util.Stack;

public class PostOrderBinaryTreeIteratorImpl implements PostOrderTraversalIterator {

    Stack<Node> s = new Stack();

    public PostOrderBinaryTreeIteratorImpl(Node root) {
        findNextLeaf(root);
    }

    private void findNextLeaf(Node root){
        while(root != null){
            s.push(root);

            if(root.left != null){
                root = root.left;
            }else{
                root = root.right;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !s.isEmpty(); //true if stack is not empty.
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException("stack is empty");
        }
        Node res = s.pop();
        if(!s.isEmpty()){
            Node top = s.peek();
            if(res == top.left){
                findNextLeaf(top.right);
            }
        }
        return res.val;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported.");
    }
}
