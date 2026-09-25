package csc400mod2;

import java.util.ArrayList;

/**
 * Bag class represents a bag that can contain
 * duplicate items and does not enforce an order
 * param <T> the type of element stored in the bag
 */
public class Bag<T> {

    // ArrayList to store items
    private ArrayList<T> items;

    // Constructor creates empty bag
    public Bag() {
        items = new ArrayList<>();
    }

    /**
     * Adds item to bag
     * param item the item to add
     */
    public void add(T item) {
        items.add(item);
    }

    /**
     * Removes one occurrence of an item from bag
     * If the item does not exist, nothing happens
     *
     * param item the item to remove
     */
    public void remove(T item) {
        items.remove(item);
    }

    /**
     * Checks whether an item exists in the bag
     * param item the item to search for
     * return true if the item exists, false if not
     */
    public boolean contains(T item) {
        return items.contains(item);
    }

    /**
     * Counts the number of occurrences of an item in bag
     * param item the item to count
     * return number of times item occurs
     */
    public int count(T item) {
        int count = 0;

        // Check every item in bag
        for (T currentItem : items) {
            if (currentItem.equals(item)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Returns total number of elements in bag, including duplicates
     * return number of elements in bag
     */
    public int size() {
        return items.size();
    }

    /**
     * Merges the elements of another bag into this bag, duplicates are included
     * param otherBag the bag to merge into the current bag
     */
    public void merge(Bag<T> otherBag) {
        for (T item : otherBag.items) {
            items.add(item);
        }
    }

    /**
     * Creates and returns a new bag containing only distinct elements from current bag
     * return a new bag containing distinct elements
     */
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();

        for (T item : items) {
            if (!distinctBag.contains(item)) {
                distinctBag.add(item);
            }
        }

        return distinctBag;
    }

    /**
     * Returns a string containing the contents of bag
     * return the contents of bag
     */
    @Override
    public String toString() {
        return items.toString();
    }

    // Main
    public static void main(String[] args) {

        // Create first bag
        Bag<String> bag1 = new Bag<>();

        // Add elements to first bag, including duplicates
        bag1.add("Apple");
        bag1.add("Banana");
        bag1.add("Apple");
        bag1.add("Orange");
        bag1.add("Banana");

        // Create second bag
        Bag<String> bag2 = new Bag<>();

        // Add elements to second bag, including duplicates
        bag2.add("Orange");
        bag2.add("Grape");
        bag2.add("Apple");
        bag2.add("Grape");

        // Print original bags
        System.out.println("Bag 1: " + bag1);
        System.out.println("Bag 2: " + bag2);

        // Print size of each bag
        System.out.println("\nSize of Bag 1: " + bag1.size());
        System.out.println("Size of Bag 2: " + bag2.size());

        // Merge Bag 2 into Bag 1
        bag1.merge(bag2);

        // Print the merged bag
        System.out.println("\nAfter merging Bag 2 into Bag 1:");
        System.out.println("Merged Bag: " + bag1);

        // Print the size of merged bag
        System.out.println("Size of merged Bag: " + bag1.size());

        // Create a new bag containing only distinct elements
        Bag<String> distinctBag = bag1.distinct();

        // Print distinct bag
        System.out.println("\nDistinct Bag: " + distinctBag);

        // Print size of the distinct bag
        System.out.println("Size of distinct Bag: " + distinctBag.size());
    }
}
