public class BinaryTree<type> {

    protected type value;

    protected BinaryTree<type> lhs;
    protected BinaryTree<type> rhs;

    public BinaryTree(type val) {
        this.value = val;
        this.lhs = null;
        this.rhs = null;
    }

    public BinaryTree(type val, BinaryTree<type> lhs) {
        this.value = val;
        this.lhs = lhs;
        this.rhs = null;
    }

    public BinaryTree(type val, BinaryTree<type> lhs, BinaryTree<type> rhs) {
        this.value = val;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    boolean isLeaf() {
        return lhs == null && rhs == null;
    }

    boolean hasLhs() {
        return lhs != null;
    }

    boolean hasRhs() {
        return rhs != null;
    }

    public type getValue() {
        return value;
    }

    public BinaryTree<type> getLhs() {
        return lhs;
    }

    public BinaryTree<type> getRhs() {
        return rhs;
    }

    public void setValue(type value) {
        this.value = value;
    }

    public void setLhs(BinaryTree<type> lhs) {
        this.lhs = lhs;
    }

    public void setRhs(BinaryTree<type> rhs) {
        this.rhs = rhs;
    }

    public boolean isInTree(type value) {
        if (value == this.value){
            return true;
        }

        if (hasLhs()) {
            if (lhs.isInTree(value)){
                return true;
            }
        }
        if (hasRhs()) {
            if (rhs.isInTree(value)){
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String str = recInOrder(this);
        return str.substring(0, str.length() - 2);
    }

    public String recInOrder(BinaryTree<type> tree) {
        String str = "";

        if (tree.hasLhs()) {
            str = str + recInOrder(tree.getLhs());
        }
        str = str + tree.getValue() + ", ";
        if (tree.hasRhs()) {
            str = str + recInOrder(tree.getRhs());
        }

        return str;
    }
}
