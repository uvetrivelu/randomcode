package example.ex5.src;

/**
 * Another implementation of SweetStack interface. Uses Linkedlist-like private data structure for manipulating
 * values in stack like fashion.
 */
public class SuperSweetStackImpl implements SweetStack {

    private class Node {
        Node next;
        int value;
    }

    int numberOfNodes;
    Node head;

    @Override
    public void push(int val) {
        Node node = new Node();
        node.value = val;
        node.next = head;
        head = node;
        numberOfNodes++;
        return;
    }

    @Override
    public int pop() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        int currentValue = head.value;
        head = head.next;
        numberOfNodes--;
        return currentValue;
    }

    @Override
    public int size() {
        return numberOfNodes;
    }

    @Override
    public int max() {
        return getMax(head, head.value);
    }

    private int getMax(Node listNode, int maxValue) {
        if (listNode.next == null) {
            return maxValue;
        } else {
            if (listNode.value > maxValue) {
                return getMax(listNode.next, listNode.value);
            } else {
                return getMax(listNode.next, maxValue);
            }
        }

    }
}
