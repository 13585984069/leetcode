package leetcode.zuo.day4.Tree;

/**
 * @author JJChen
 * @version 1.0
 */
public class Travel {
    public static void main(String[] args) {
        TreeNode head = TreeUtility.createTree();
//        System.out.println("=========preorder01===========");
//        TreeUtility.preOrder01(head);
//        System.out.println("\n=========preorder02===========");
//        TreeUtility.preOrder02(head);
//        System.out.println("\n=========Inorder01===========");
//        TreeUtility.InOrder01(head);
//        System.out.println("\n=========Inorder02===========");
//        TreeUtility.Inorder02(head);
//        System.out.println("\n=========postorder01===========");
//        TreeUtility.postOrder01(head);
//        System.out.println("\n=========postorder02===========");
//        TreeUtility.postOrder02(head);
//        System.out.println("\n=========广度优先===========");
//        TreeUtility.BreadthTravel(head);
        int max =  TreeUtility.getMaxWidth02(head);
        System.out.println(max);
        System.out.println(Long.MIN_VALUE);



    }
}
