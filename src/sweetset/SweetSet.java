package sweetset;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Implement a Set with unique elements.
 */
public class SweetSet {

    private HashMap<Object, Object> currentSet = new HashMap<>();


    /**
     * Add to set only if object already doesn't exist.
     * @param newObject
     */
    public void add(String newObject) {

        if (newObject != null && currentSet.get(newObject) == null) {

            currentSet.put(newObject, newObject);

        }
    }

    /**
     * Current number of elements in set.
     * @return
     */
    public int size() {
        return currentSet.size();
    }

    /**
     * Prints value in the set.
     */
    public void printString() {

        Iterator iterator = currentSet.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println( "Key = " + key + " Value = " + currentSet.get(key));
        }
    }

    public static void main(String[] args) {

        SweetSet sweetSet = new SweetSet();
        //add elements
        sweetSet.add("Gelato");

        sweetSet.add("Icecream");

        //add duplicate
        sweetSet.add("Gelato");

        sweetSet.add("ShavedIce");

        sweetSet.printString();

        System.out.println("Sweetset size = " + sweetSet.size());

    }
}
