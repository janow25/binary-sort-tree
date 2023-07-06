public class BinarySortTree extends BinaryTree<Integer> {

    public BinarySortTree(Integer val) {
        super(val);
    }

    public BinarySortTree(Integer val, BinaryTree<Integer> lhs) {
        super(val, lhs);
    }

    public BinarySortTree(Integer val, BinaryTree<Integer> lhs, BinaryTree<Integer> rhs) {
        super(val, lhs, rhs);
    }

    ///Inserts a new Value into the Sorted Tree with the insertRecursive method.
    public void insertValue(Integer value) {

        insertRecursive(value, this);
    }

    private void insertRecursive(int value, BinaryTree<Integer> tree) {
        if (value < tree.value) {
            if (!tree.hasLhs()) {
                tree.setLhs(new BinarySortTree(value));
            }
            else {
                insertRecursive(value, tree.getLhs());
            }
        }
        else {
            if (!tree.hasRhs()) {
                tree.setRhs(new BinarySortTree(value));
            }
            else {
                insertRecursive(value, tree.getRhs());
            }
        }
    }
}
