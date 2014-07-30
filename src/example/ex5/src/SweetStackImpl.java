package example.ex5.src;

import java.util.LinkedList;

/**
 * Class implements SweetStack using java.util.LinkedList as
 * the datastructure to maintain O(1) execution time on all the operations.
 * User: usha
 */
public class SweetStackImpl implements SweetStack {

    private int size;
    private int currentMax;

    private LinkedList<Integer> node = new LinkedList<Integer>();

    @Override
    public void push(int val) {
        if (size == 0) {
            currentMax = val;
            node.addFirst(val);
        } else if (val > currentMax) {
            currentMax = val;
        }
        node.addLast(val);
        size++;
    }

    @Override
    public int pop() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        --size;
        return node.removeLast();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int max() {
        return currentMax;
    }

}