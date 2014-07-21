package example.ex2;

import java.util.Scanner;

/**
 * Has utility methods to check if given input string is a palindrome.
 * User: usha
 * Date: 9/30/12
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Palindrome {

    public static boolean checkPalindrome(String input) {

        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        if (input.toLowerCase().charAt(0) == input.toLowerCase().charAt(input.length() - 1))
            return checkPalindrome(input.substring(1, input.length() - 1));

        return false;
    }

    public static String removeAlphaNumerics(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate thru each char in the string to skip alphanumeric char
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Type a word to check palindrome or not");
        String input = new Scanner(System.in).nextLine();
        String str = removeAlphaNumerics(input);
        if (checkPalindrome(str.trim()))
            System.out.println(input + " is a palindrome");
        else
            System.out.println(input + " is not a palindrome");
    }
}
