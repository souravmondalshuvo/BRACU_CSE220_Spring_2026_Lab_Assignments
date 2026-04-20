//Assignment Task (must Submit)
// Complete the sumOfLeaves method
public class Task5 {

    //===================================TASK#5======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){
        //TO DO

        if(root == null) {
            return 0;
        }

        return mirrorSumHelper(root.left, root.right);
        // return null; // remove this line
    }

    private static Integer mirrorSumHelper(BSTNode left_node, BSTNode right_node) {
        
        if(left_node == null || right_node == null) {
            return 0;
        }

        return left_node.elem + right_node.elem + mirrorSumHelper(left_node.left, right_node.right) + mirrorSumHelper(left_node.right, right_node.left);
    }
    //===============================================================


}
