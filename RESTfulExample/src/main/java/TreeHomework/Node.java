package TreeHomework;

import java.util.List;

class Node{
    int val;
    Node left;
    Node right;

    List<Node> children;

    public Node(int val)
    {
        this.val = val;
        left = right = null;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
