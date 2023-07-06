import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    @org.junit.jupiter.api.Test
    void alwaysTrue() {
        assertTrue(true);
    }
    @org.junit.jupiter.api.Test
    void isLeaf() {
        //New Empty Tree should be a leaf
        BinaryTree<Integer> bt = new BinaryTree<Integer>(5);
        assertTrue(bt.isLeaf());

        //New Tree with lhs element should not be a leaf
        BinaryTree<Integer> bt2 = new BinaryTree<Integer>(5, bt);
        assertFalse(bt2.isLeaf());
        assertFalse(bt2.hasRhs());
        assertTrue(bt2.hasLhs());
    }

    @org.junit.jupiter.api.Test
    void testGetters() {
        final int val = 5;

        //Tree should return its value
        BinaryTree<Integer> bt = new BinaryTree<Integer>(val);
        assertEquals(bt.getValue(), val);

        final int lhsVal = 6;
        final int rhsVal = 7;

        //lhs and rhs trees should be readable
        bt = new BinaryTree<Integer>(val, new BinaryTree<Integer>(lhsVal), new BinaryTree<Integer>(rhsVal));

        assertEquals(bt.getValue(), val);
        assertEquals(bt.getLhs().getValue(), lhsVal);
        assertEquals(bt.getRhs().getValue(), rhsVal);
    }

    @org.junit.jupiter.api.Test
    void testSettersWithGetters() {
        final int initVal = 0;
        final int val = 5;

        //Tree should return its value
        BinaryTree<Integer> bt = new BinaryTree<Integer>(initVal);

        //Test if init value is set
        assertEquals(bt.getValue(), initVal);

        //Set new Value with Setter
        bt.setValue(val);
        assertEquals(bt.getValue(), val);

        final int lhsVal = 6;
        final int rhsVal = 7;

        //lhs and rhs trees should be setable
        bt = new BinaryTree<Integer>(val);

        //test if value in root is set and if isLeaf
        assertEquals(bt.getValue(), val);
        assertTrue(bt.isLeaf());
        assertFalse(bt.hasRhs());
        assertFalse(bt.hasLhs());

        //Set Lhs and Rhs
        bt.setLhs(new BinaryTree<Integer>(lhsVal));
        bt.setRhs(new BinaryTree<Integer>(rhsVal));

        //Test values
        assertFalse(bt.isLeaf());
        assertTrue(bt.hasLhs());
        assertTrue(bt.hasRhs());
        assertEquals(bt.getValue(), val);
        assertEquals(bt.getLhs().getValue(), lhsVal);
        assertEquals(bt.getRhs().getValue(), rhsVal);
    }

    @org.junit.jupiter.api.Test
    void testIsInTree() {
        final int randVal = 1;
        final int valToSearch = 2;

        //generate big tree
        BinaryTree<Integer> bt = new BinaryTree<Integer>(randVal);
        bt.setLhs(new BinaryTree<Integer>(randVal));
        bt.setRhs(new BinaryTree<Integer>(randVal));

        bt.getLhs().setLhs(new BinaryTree<Integer>(randVal));
        bt.getRhs().setRhs(new BinaryTree<Integer>(randVal));

        bt.getLhs().setValue(valToSearch);

        assertFalse(bt.isInTree(3));
        assertTrue(bt.isInTree(valToSearch));
        assertTrue(bt.isInTree(randVal));

        //Test if RHS also works
        bt.getRhs().setValue(valToSearch);
        bt.getLhs().setValue(randVal);

        assertFalse(bt.isInTree(3));
        assertTrue(bt.isInTree(valToSearch));
        assertTrue(bt.isInTree(randVal));
    }
}