package example.ex5.test;

import example.ex5.src.SuperSweetStackImpl;
import example.ex5.src.SweetStack;
import example.ex5.src.SweetStackImpl;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SweetStackImplTest {

    @Test
    public void testSuperSweetStackCurrentMax() {
        SuperSweetStackImpl mySweetStack = new SuperSweetStackImpl(1);
        mySweetStack.push(2);
        mySweetStack.push(4);
        mySweetStack.pop();
        mySweetStack.push(1);
        mySweetStack.push(3);
        String result = mySweetStack.max() == 3 ? "PASSED" : String.format("FAILED (expected %s, got %s)", 3, mySweetStack.max());
        System.out.println(String.format("testSuperSweetStackCurrentMax() %s", result));
        assert (mySweetStack.max() == 3);
    }


    @Test
    public void testSuperSweetStackPush() {
        SuperSweetStackImpl mySweetStack = new SuperSweetStackImpl(1);
        mySweetStack.push(2);
        mySweetStack.push(3);
        String result = mySweetStack.size() == 3 ? "PASSED" : "FAILED";
        System.out.println(String.format("testSuperSweetStackPush() %s", result));
        assert (mySweetStack.size() == 3);
    }

    @Test
    public void testSuperSweetStackPopBeyondSize() {
        SuperSweetStackImpl mySweetStack = new SuperSweetStackImpl(1);
        mySweetStack.push(2);
        mySweetStack.push(3);
        mySweetStack.pop();
        mySweetStack.pop();
        mySweetStack.pop();
        String result = "FAILED";
        try {
            mySweetStack.pop();
        } catch (NoSuchElementException e) {
            result = "PASSED";
        }
        System.out.println(String.format("testSuperSweetStackPopBeyondSize() %s", result));
    }

    @Test
    public void testSuperSweetStackMaxAndSize() {
        SuperSweetStackImpl mySweetStack = new SuperSweetStackImpl(1);
        mySweetStack.push(9);
        mySweetStack.push(3);
        mySweetStack.push(8);
        String result = mySweetStack.max() == 9 && mySweetStack.size() == 4 ? "PASSED" : "FAILED";
        System.out.println(String.format("testSuperSweetStackMaxAndSize() %s", result));
        assert (mySweetStack.max() == 9 && mySweetStack.size() == 4);
    }

    @Test
    public void testPush() {
        SweetStackImpl mySweetStack = new SweetStackImpl();
        mySweetStack.push(1);
        mySweetStack.push(2);
        mySweetStack.push(3);
        String result = mySweetStack.size() == 3 ? "PASSED" : "FAILED";
        System.out.println(String.format("testPush() %s", result));
        assert (mySweetStack.size() == 3);
    }

    @Test
    public void testPopBeyondSize() {
        SweetStackImpl mySweetStack = new SweetStackImpl();
        mySweetStack.push(1);
        mySweetStack.push(2);
        mySweetStack.push(3);
        mySweetStack.pop();
        mySweetStack.pop();
        mySweetStack.pop();
        String result = "FAILED";
        try {
            mySweetStack.pop();
        } catch (NoSuchElementException e) {
            result = "PASSED";
        }
        System.out.println(String.format("testPopBeyondSize() %s", result));
    }

    @Test
    public void testMaxAndSize() {
        SweetStack mySweetStack = new SweetStackImpl();
        mySweetStack.push(1);
        mySweetStack.push(9);
        mySweetStack.push(3);
        mySweetStack.push(8);
        String result = mySweetStack.max() == 9 && mySweetStack.size() == 4 ? "PASSED" : "FAILED";
        System.out.println(String.format("testMaxAndSize() %s", result));
        assert (mySweetStack.max() == 9 && mySweetStack.size() == 4);
    }
}
