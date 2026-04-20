//Assignment Task (must Submit)
// Complete the isBST method
public class Task6 {

    //===================================TASK#6======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Boolean isBST( BSTNode root ){
        //TO DO

        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // return null; // remove this line
    }

    private static Boolean isBSTHelper(BSTNode root, long min, long max) {
        
        if(root == null) {
            return true;
        }

        if(root.elem <= min || root.elem >= max) {
            return false;
        }

        return isBSTHelper(root.left, min, root.elem) && isBSTHelper(root.right, root.elem, max);
    }
    //===============================================================


}
