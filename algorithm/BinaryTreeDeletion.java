package algorithm;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeDeletion {


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if ( root.left != null ) {
            root.left = removeLeafNodes(root.left, target);
        }

        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        } else {
            return root;
        }


    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3, node5, node6);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, node3);

        BinaryTreeDeletion b = new BinaryTreeDeletion();
        TreeNode current = b.removeLeafNodes(node1, 2);
        System.out.println(current.val);
    }
}
