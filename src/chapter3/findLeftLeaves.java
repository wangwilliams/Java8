package chapter3;

/**
 * @author wangyunpeng
 * @date 2020/5/31
 */
public class findLeftLeaves {
    static Integer ans = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode one = new TreeNode(9);
        TreeNode two = new TreeNode(20);
        TreeNode three = new TreeNode(15);
        TreeNode four = new TreeNode(7);
        root.left = one;
        root.right = two;
        two.left = three;
        two.right = four;
        System.out.println(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        findTheLeft(root,false,true);
        return ans;
    }

    private static void findTheLeft(TreeNode root,boolean isTheLeft,boolean isRoot) {
        if (isRoot && root.left == null && root.right == null) {
            ans = ans + root.val;
        }
        if (root.left == null && root.right == null && isTheLeft) {
            ans = ans + root.val;
        }else {
            if (root.left != null) {
                findTheLeft(root.left, true,false);
            }
            if (root.right != null) {
                findTheLeft(root.right,false,false);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
