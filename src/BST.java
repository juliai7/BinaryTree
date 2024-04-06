import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return treeSearch(val, root);
    }

    public boolean treeSearch(int val, BSTNode newRoot) {
        // If the value isn't in the tree
        if (newRoot == null) {
            return false;
        }
        // Once found the value in the tree
        else if (val == newRoot.getVal()) {
            return true;
        }
        // Traverse down the right of the tree if it's greater than the root
        else if (val > newRoot.getVal()) {
            newRoot = newRoot.getRight();
        }
        // Traverse down the left of the tree if it's less than the root
        else if (val < newRoot.getVal()) {
            newRoot = newRoot.getLeft();
        }
        // Recursive call until you've either reached the end or found the value
        return treeSearch(val, newRoot);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        return inOrder(root, arr);
    }
    public ArrayList<BSTNode> inOrder(BSTNode val, ArrayList<BSTNode> arr) {
        // If reached the leaf
        if (val == null) {
            return arr;
        }
        // Recursively call left hand side first until reach the leaf
        inOrder(val.getLeft(), arr);
        // Gets the root
        arr.add(val);
        // Gets the right hand side
        inOrder(val.getRight(), arr);
        return arr;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        return preOrder(root, arr);
    }
    public ArrayList<BSTNode> preOrder(BSTNode val, ArrayList<BSTNode> arr) {
        // Same as inOrder but flips the order it's checking to root, left, right
        if (val == null) {
            return arr;
        }
        arr.add(val);
        preOrder(val.getLeft(), arr);
        preOrder(val.getRight(), arr);
        return arr;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        return postOrder(root, arr);
    }
    public ArrayList<BSTNode> postOrder(BSTNode val, ArrayList<BSTNode> arr) {
        // Same as inOrder but flips the order its checking to left, right, root
        if (val == null) {
            return arr;
        }
        postOrder(val.getLeft(), arr);
        postOrder(val.getRight(), arr);
        arr.add(val);
        return arr;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // Set current tree to a tree with an inserted node
        root = inserts(val, root);
    }
    // Recursively returns the tree with the node inserted
    public BSTNode inserts(int val, BSTNode curr) {
        // Checks if current one is a leaf and creates new value to put into the tree
        if (curr == null) {
            return new BSTNode(val);
        }
        if (val < curr.getVal()) {
            // Set curr's left child equal to the value of what insert returns
            curr.setLeft(inserts(val, curr.getLeft()));
        }
        else if (val > curr.getVal()) {
            // Set curr's right child equal to the value of what insert returns
            curr.setRight(inserts(val, curr.getRight()));
        }
        return curr;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
