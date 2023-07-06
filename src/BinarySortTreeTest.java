import static org.junit.jupiter.api.Assertions.*;

class BinarySortTreeTest {
    
    @org.junit.jupiter.api.Test
    void isLeaf() {
        //New Empty Tree should be a leaf
        BinarySortTree bt = new BinarySortTree(5);
        assertTrue(bt.isLeaf());

        //New Tree with lhs element should not be a leaf
        BinarySortTree bt2 = new BinarySortTree(5, bt);
        assertFalse(bt2.isLeaf());
        assertFalse(bt2.hasRhs());
        assertTrue(bt2.hasLhs());
    }

    @org.junit.jupiter.api.Test
    void testGetters() {
        final int val = 5;

        //Tree should return its value
        BinarySortTree bt = new BinarySortTree(val);
        assertEquals(bt.getValue(), val);

        final int lhsVal = 6;
        final int rhsVal = 7;

        //lhs and rhs trees should be readable
        bt = new BinarySortTree(val, new BinarySortTree(lhsVal), new BinarySortTree(rhsVal));

        assertEquals(bt.getValue(), val);
        assertEquals(bt.getLhs().getValue(), lhsVal);
        assertEquals(bt.getRhs().getValue(), rhsVal);
    }

    @org.junit.jupiter.api.Test
    void testSettersWithGetters() {
        final int initVal = 0;
        final int val = 5;

        //Tree should return its value
        BinarySortTree bt = new BinarySortTree(initVal);

        //Test if init value is set
        assertEquals(bt.getValue(), initVal);

        //Set new Value with Setter
        bt.setValue(val);
        assertEquals(bt.getValue(), val);

        final int lhsVal = 6;
        final int rhsVal = 7;

        //lhs and rhs trees should be setable
        bt = new BinarySortTree(val);

        //test if value in root is set and if isLeaf
        assertEquals(bt.getValue(), val);
        assertTrue(bt.isLeaf());
        assertFalse(bt.hasRhs());
        assertFalse(bt.hasLhs());

        //Set Lhs and Rhs
        bt.setLhs(new BinarySortTree(lhsVal));
        bt.setRhs(new BinarySortTree(rhsVal));

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
        BinarySortTree bt = new BinarySortTree(randVal);
        bt.setLhs(new BinarySortTree(randVal));
        bt.setRhs(new BinarySortTree(randVal));

        bt.getLhs().setLhs(new BinarySortTree(randVal));
        bt.getRhs().setRhs(new BinarySortTree(randVal));

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

    @org.junit.jupiter.api.Test
    void testInsert() {
        int val2Insert = 3;

        BinarySortTree bst = new BinarySortTree(5);

        bst.insertValue(val2Insert);

        assertEquals(bst.getLhs().getValue(), val2Insert);
    }

    @org.junit.jupiter.api.Test
    void testMulitpleInserts() {
        int val2Insert = 3;

        BinarySortTree bst = new BinarySortTree(5);

        //Insert 3
        bst.insertValue(val2Insert);

        assertEquals(bst.getLhs().getValue(), val2Insert);
        assertTrue(bst.isInTree(3));


        //Insert 7
        val2Insert = 7;

        bst.insertValue(val2Insert);

        assertEquals(bst.getRhs().getValue(), val2Insert);
        assertTrue(bst.isInTree(3));
        assertTrue(bst.isInTree(7));

        //Insert 9
        val2Insert = 9;

        bst.insertValue(val2Insert);

        assertEquals(bst.getRhs().getRhs().getValue(), val2Insert);
        assertTrue(bst.isInTree(3));
        assertTrue(bst.isInTree(7));
        assertTrue(bst.isInTree(9));

        //Insert 2
        val2Insert = 2;

        bst.insertValue(val2Insert);

        assertEquals(bst.getLhs().getLhs().getValue(), val2Insert);
        assertTrue(bst.isInTree(3));
        assertTrue(bst.isInTree(7));
        assertTrue(bst.isInTree(9));
        assertTrue(bst.isInTree(2));

        //Insert 8
        val2Insert = 8;

        bst.insertValue(val2Insert);

        assertEquals(bst.getRhs().getRhs().getLhs().getValue(), val2Insert);
        assertTrue(bst.isInTree(3));
        assertTrue(bst.isInTree(7));
        assertTrue(bst.isInTree(9));
        assertTrue(bst.isInTree(2));

        String str = bst.toString();

        System.out.println(str);

        assertEquals(str, "2, 3, 5, 7, 8, 9");
    }
}