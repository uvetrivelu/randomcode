package example.ex1;

import org.junit.Test;

import java.util.Map;

/**
 * Unit tests for keycount.
 * User: usha
 * Date: 9/30/12
 * Time: 1:23 PM
 */
public class KeyCountTest {


    @Test
    public void test1() throws Exception {
        Map<String, Integer> values = KeyCount.countFileKeys("src/example//ex1//testsample1.txt");
        assert (values.get("Louie") == 20);
    }

    @Test
    public void test2() throws Exception {
        Map<String, Integer> values = KeyCount.countFileKeys("src/example//ex1/testsample1.txt");
        assert (values.get(",") == null);
    }

    @Test
    public void test3() throws Exception {
        Map<String, Integer> values = KeyCount.countFileKeys("src/example//ex1/testsample1.txt");
        assert (values.get("Jane") != 11);
    }
}
