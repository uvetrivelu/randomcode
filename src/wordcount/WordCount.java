package wordcount;

/**
 * Count number of words in a sentence.
 */
public class WordCount {

    /**
     * 1. Count the first word if it's not a space.
     * 2. Count everytime there is a space in front of a letter & current letter is not a space.
     * @param sentence
     * @return
     */
    private int calculateCount(String sentence) {

        char currentChar;
        int wordCount = 0;

        for (int i = 0 ; i < sentence.length(); i++) {
            currentChar = sentence.charAt(i);

            if ((i == 0 && currentChar != ' ') || (i > 0 && currentChar != ' ' && sentence.charAt(i - 1) == ' ')) {
                wordCount++;
                System.out.println("Wordcount now at : " + wordCount);
            }
        }
        return wordCount;

    }

    public static void main(String[] args) {

        WordCount wordCount = new WordCount();

        String sample = "Sitting is the new smoking! And standing desks are alright!";

        System.out.println("Word count for sample is " + wordCount.calculateCount(sample));

    }
}
