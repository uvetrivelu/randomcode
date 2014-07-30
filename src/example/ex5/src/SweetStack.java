package example.ex5.src;

/**
 * Implement a Stack data structure for primitive int values with the following requirements:
 * a.  There should be no limit to the amount of nodes that are placed into the stack.
 * b.  The Stack should implement the following interface all with O(1) complexity.
 */

public interface SweetStack {
    /**
     * Push operation that would add integer elements to the stack implementation. Every push
     * adds the values to the end of the stack.
     *
     * @param val element to be added to the stack
     */
    public void push(int val);

    /**
     * Pop operation should follow LIFO principle meaning every call to the pop
     * operation should return the last element in the stack and also the last element
     * is deleted from the stack before return.
     *
     * @return last element in the stack
     */
    public int pop();

    /**
     * Returns size of the stack or 0 if stack is empty.
     *
     * @return size of the stack
     */
    public int size();

    /**
     * Returns maximum value of the elements placed in the stack or returns 0 if stack is empty.
     *
     * @return maximum value of the elements
     */
    public int max();

}
