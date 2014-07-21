package example.ex2;

import org.junit.Test;

/**
 * Unit tests for Palindrome checking util method.
 * User: usha
 * Date: 9/30/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeTest {
    @Test
    public void testCheck1() throws Exception {
        assert (Palindrome.checkPalindrome("pip"));

    }

    @Test
    public void testCheck2() throws Exception {
        assert (Palindrome.checkPalindrome("Ah,Satan sees Natasha"));
    }

    @Test
    public void testCheck3() throws Exception {
        assert (!Palindrome.checkPalindrome(" Natasha"));
    }
}
