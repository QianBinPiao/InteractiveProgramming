package algorithm;



public class ValidBinaryTree {

    public boolean isValidBST(TreeNode root) {

        boolean leftValidation;
        boolean rightValidation;

        if (root == null) {
            return true;
        }

        if ( root.left != null) {
            if (root.left.val < root.val) {
                leftValidation = isValidBST(root.left);
            }
            else {
                return false;
            }
        } else {
            leftValidation = false;
        }

        if (root.right != null) {
            if (root.val < root.right.val) {
                rightValidation = isValidBST(root.right);
            } else {
                return false;
            }
        } else {
            rightValidation = true;
        }



        if (root.left == null && root.right == null) {
            return true;
        }

        return leftValidation && rightValidation;

    }

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2, node2, node3);

        ValidBinaryTree v = new ValidBinaryTree();
        System.out.println(v.isValidBST(node1));

        TreeNode node5 = new TreeNode(-1);
        TreeNode node4 = new TreeNode(0, node5, null);


        System.out.println(v.isValidBST(node4));

    }
}
