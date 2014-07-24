package example.ex4;

import java.util.HashMap;
import java.util.Map;

/*

String message = "...";
String magazine = ".....";

abc / abc => true
abc / cba => true
abc / asocabchjabjhabcjahbcab => true
abcc / abc => false
abcc / abcd => false
abcc / abcccdd => true

*/

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String message = "abc";
        String magazine = "asocabchjabjhabcjahbcab";
        boolean value = sol.isMatching(message, magazine);
        System.out.println("Value: " + value);

        sol.testcase1();
    }

    public void testcase1() {
        Solution sol = new Solution();
        String message = "abcc";
        String magazine = "abc";
        boolean value = sol.isMatching(message, magazine);
        System.out.println("Value: " + value);

    }

    public boolean isMatching(String message, String magazine) {
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        char[] message_arr = message.toCharArray();
        //build map of counts for message
        for (int i = 0; i < message_arr.length; i++) {
            if (charCountMap.get(message_arr[i]) == null) {
                charCountMap.put(message_arr[i], 1);
            } else {
                int newCount = charCountMap.get(message_arr[i]);
                charCountMap.put(message_arr[i], ++newCount);
            }

        }
        //build map of counts for magazine
        Map<Character, Integer> charCountMagMap = new HashMap<Character, Integer>();
        char[] magazine_arr = magazine.toCharArray();
        for (int j = 0; j < magazine_arr.length; j++) {
            if (charCountMagMap.get(magazine_arr[j]) == null) {
                charCountMagMap.put(magazine_arr[j], 1);
            } else {
                int newCount = charCountMagMap.get(magazine_arr[j]);
                charCountMagMap.put(magazine_arr[j], ++newCount);
            }

        }
        //compare maps to see if message has enough of each char
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (charCountMagMap.get(entry.getKey()) < charCountMap.get(entry.getKey())) {
                return false;
            }
        }
        return true; //false;
    }

}
