public class SimpleTree {

    Node root = null;

    // This currently assumes an array of ints without duplicates
    public SimpleTree(int[] data) {
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
        else if (rootNode == null) {
            reportNotFound();
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

    public void insertNode(int val) {
        Node treeNode = new Node(val);
        addNode(treeNode,this.root);
    }

    private void addNode(Node treeNode, Node rootNode) {
        if (treeNode.datum < rootNode.datum) {
            if (rootNode.leftChild == null) {
                rootNode.setLeftChild(treeNode);
            }
            else {
                addNode(treeNode, rootNode.leftChild);
            }
        }
        else {
            if (rootNode.rightChild == null) {
                rootNode.setRightChild(treeNode);
            }
            else {
                addNode(treeNode, rootNode.rightChild);
            }
        }
    }

    private void reportNotFound() {
        System.out.println("NODE NOT FOUND");
    }

    public static void main(String[] args) {
        System.out.println("---Test 1---");
        int[] testArray1 = {6, 3, 9, 2, 10};
        SimpleTree tree1 = new SimpleTree(testArray1);
        System.out.println(tree1.getPath(2));
        System.out.println(tree1.getPath(10));

        System.out.println("---Test 2---");
        int[] testArray2 = {23, 15, 43, 14, 42, 16, 38, 10, 32, 9, 8, 7, 55, 29, 2, 1};
        SimpleTree tree2 = new SimpleTree(testArray2);
        System.out.println(tree2.getPath(2));
        System.out.println(tree2.getPath(10));
        System.out.println(tree2.getPath(55));

        System.out.println("---Test 3---");
        System.out.println("Adding 56...");
        tree2.insertNode(56);
        System.out.println(tree2.getPath(56));
        System.out.println("Adding 14...");
        tree2.insertNode(13);
        System.out.println(tree2.getPath(13));
        System.out.println(tree2.getPath(14));

    }


}
