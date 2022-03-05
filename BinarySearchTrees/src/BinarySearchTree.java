import java.lang.reflect.Array;

public class BinarySearchTree {

    Node root = null;

    // This currently assumes an array of ints without duplicates
    public BinarySearchTree(int[] data) {
        for(int i = 0; i< data.length; i++) {
            Node treeNode = new Node(data[i]);
            if (i == 0) {
                this.root = treeNode;
            }
            else {
                placeNode(treeNode, this.root);
            }
        }
    }

    private void placeNode(Node treeNode, Node rootNode) {
        if (treeNode.datum < rootNode.datum) {
            if (rootNode.leftChild == null) {
                rootNode.leftChild = treeNode;
            }
            else {
                placeNode(treeNode, rootNode.leftChild);
            }
        }
        else {
            if (rootNode.rightChild == null) {
                rootNode.rightChild = treeNode;
            }
            else {
                placeNode(treeNode, rootNode.rightChild);
            }
        }
    }

    public String getPath(int val) {
        return searchTree(val, this.root);
    }

    private String searchTree(int val, Node rootNode) {
        String output = "";
        if (rootNode.datum == val) {
            output += rootNode.toString();
        }
        else {
            output += rootNode.toString() + " -> ";
            if (val < rootNode.datum) {
                output += searchTree(val, rootNode.leftChild);
            }
            else {
                output += searchTree(val, rootNode.rightChild);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("---Test 1---");
        int[] testArray1 = {6, 3, 9, 2, 10};
        BinarySearchTree tree1 = new BinarySearchTree(testArray1);
        System.out.println(tree1.getPath(2));
        System.out.println(tree1.getPath(10));

        System.out.println("---Test 2---");
        int[] testArray2 = {23, 15, 43, 14, 42, 16, 38, 10, 32, 9, 8, 7, 55, 29, 2, 1};
        BinarySearchTree tree2 = new BinarySearchTree(testArray2);
        System.out.println(tree2.getPath(2));
        System.out.println(tree2.getPath(10));
        System.out.println(tree2.getPath(55));
    }


}
