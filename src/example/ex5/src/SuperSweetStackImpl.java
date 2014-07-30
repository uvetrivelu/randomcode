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
    Node maxHead;

    public SuperSweetStackImpl(int value) {
        this.head = new Node();
        this.head.value = value;
        this.head.next = null;
        this.maxHead = new Node();
        this.maxHead.value = value;
        this.maxHead.next = null;
        ++numberOfNodes;
    }

    @Override
    public void push(int val) {
        Node node = new Node();
        node.value = val;
        node.next = head;
        head = node;

        if (maxHead.value < val) {
            Node newMaxNode = new Node();
            newMaxNode.value = val;
            newMaxNode.next = maxHead;
            maxHead = newMaxNode;
        }

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
        if (maxHead != null && maxHead.value == currentValue) {
            maxHead = maxHead.next;
        }
        return currentValue;
    }

    @Override
    public int size() {
        return numberOfNodes;
    }

    @Override
    /*
    Returns max element if present, if not present, returns -1.
     */
    public int max() {
        if (maxHead != null) {
            return maxHead.value;
        } else {
            return -1;
        }
    }

}
