package example.ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Compute the value count in a file with lines of key,value pair format.
 * For repeating keys, value has to be an aggregate sum.
 * User: usha
 * Date: 9/30/12
 * Time: 1:18 PM
 */
public class KeyCount {

    /**
     * Accepts text file name with expected format of key,value per line
     * and parses each line to compute the value per unique key and returns
     * it as a Map collection sorted by its natural key order.
     *
     * @param filename
     * @return
     */
    public static Map<String, Integer> countFileKeys(String filename) throws FileNotFoundException {

        Map<String, Integer> result = new TreeMap<String, Integer>();
        Scanner scanner = new Scanner(new FileInputStream(filename));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int position = line.indexOf(",");
            if (position <= 0) continue;
            String key = line.substring(0, position);
            int value = Integer.parseInt(line.substring(position + 1).trim());

            if (result.get(key) != null) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Filename argument is missing");
                return;
            }
            Map<String, Integer> keyCountMap = countFileKeys(args[0]);
            for (Map.Entry<String, Integer> entry : keyCountMap.entrySet()) {
                System.out.println("The total for " + entry.getKey() + " is " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.err.print("Error in reading file: " + e.getMessage());
        }

    }
}
