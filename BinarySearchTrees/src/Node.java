public class Node {

    int datum;
    Node leftChild;
    Node rightChild;

    public Node(int datum) {
        this.datum = datum;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return Integer.toString(this.datum);
    }

}
