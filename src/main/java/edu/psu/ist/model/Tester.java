package edu.psu.ist.model;

public class Tester {
    public static void main(String[] args) {
        ISplittableList<Integer> b =
                new UtilListImpl<>();
        System.out.println(b);                // should print: <><>

        b.addToRightAtFront(3);
        System.out.println(b);                // should print: <><3>

        b.addToRightAtFront(2);
        System.out.println(b);                // <><2, 3>

        b.addToRightAtFront(1);
        System.out.println(b);                // <><1, 2, 3>

        b.moveForward();
        System.out.println(b);                // <1><2, 3>

        b.moveForward();
        System.out.println(b);                // <1, 2><3>

        b.moveForward();
        System.out.println(b);                // <1, 2, 3><>

        b.moveToVeryBeginning();
        System.out.println(b);                // <><1, 2, 3>

        int x = b.removeFromRightAtFront();   // x now holds val. 1
        System.out.println(b);                // <><2, 3>

        b.clear();
        System.out.println(b);                // <><>
    }
}
