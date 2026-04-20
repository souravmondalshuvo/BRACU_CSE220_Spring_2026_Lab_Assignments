// Complete the levelSum method
//ASSIGNMENT TASK MUST SUBMIT
public class Task7 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){
        //TO DO

        return levelSumHelper(root, 1);
        // return null; //remove this line once ready
    }

    private static Integer levelSumHelper(BTNode root, int level) {
        
        if(root == null) {
            return 0;
        }

        int value = (Integer) root.elem;

        if(level % 2 == 1) {
            return -value + levelSumHelper(root.left, level + 1) + levelSumHelper(root.right, level + 1);
        } else {
            return value + levelSumHelper(root.left, level + 1) + levelSumHelper(root.right, level + 1);
        }
    }
    //============================================================================

}
