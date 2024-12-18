//
//import java.io.*;
//import java.nio.file.*;
//import java.util.*;
//
//public class spellChecker {
//    private ArrayList<String> dictionary;
//
//    // Constructor populates the dictionary ArrayList from the file dictionary.txt
//    public spellChecker() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("dictionary.txt"));
//        dictionary = new ArrayList<>(lines);
//        Collections.sort(dictionary); // Ensure dictionary is sorted for binary search
//    }
//
//    /**
//     * Linear search method that finds a word in the dictionary.
//     * Returns the number of words checked during the search.
//     */
//    public int linearSearch(String word) {
////    
////      	for(int i = 0; i < dictionary.size(); i++) {
////      		if(dictionary.equals(dictionary.get(i))) {
////      			return i + 1;
////      			
////      		}
////      		
////      	}
////      	
////      	return dictionary.size(); //get all of them
////      	
////      }
////    
//	
//    int comparisons = 0;
//    for (int i = 0; i < dictionary.size(); i++) {
//        comparisons++;
//        if (dictionary.get(i).equals(word)) {
//            System.out.println("Word found with linear search after " + comparisons + " checks.");
//            return comparisons;
//        }
//    }
//    System.out.println("Word not found with linear search after " + comparisons + " checks.");
//    return comparisons;
//    }
//
//
//    /**
//     * Binary search method that finds a word in the dictionary.
//     * Returns the number of words checked during the search.
//     */
//    
//    public int binarySearch(String word) {
//        int left = 0;
//        int right = dictionary.size() - 1;
//        int comparisons = 0;
//
//        while (left <= right) {
//            int middle = (left + right) / 2;
//            comparisons++;
//            String currentWord = dictionary.get(middle);
//
//            if (currentWord.compareTo(word) < 0) {
//                left = middle + 1;
//            } else if (currentWord.compareTo(word) > 0) {
//                right = middle - 1;
//            } else {
//                System.out.println("Word found with binary search after " + comparisons + " checks");
//                return comparisons;
//            }
//        }
//        System.out.println("Word not found with binary search after " + comparisons + " checks");
//        return comparisons;
//    }
//
//    public static void main(String[] args) throws IOException {
//        spellChecker checker = new spellChecker();
//
//        // Word to check
//        String word = "Bell"; // Change this to test different words
//
//        // Linear search
//        int linearChecks = checker.linearSearch(word);
//
//        // Binary search
//        int binaryChecks = checker.binarySearch(word);
//
//        // Results
////        System.out.println("Linear search steps for \"" + word + "\": " + linearChecks);
////        System.out.println("Binary search steps for \"" + word + "\": " + binaryChecks);
////    }
//}
//
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class spellChecker {
    private ArrayList<String> dictionary;

    // Constructor populates the dictionary ArrayList from the file dictionary.txt
    public spellChecker() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("dictionary.txt"));
        dictionary = new ArrayList<>(lines);
        Collections.sort(dictionary); // Ensure dictionary is sorted for binary search
    }

    /**
     * Linear search method that finds a word in the dictionary.
     * Returns the number of words checked during the search.
     */
    public int linearSearch(String word) {
        int comparisons = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            comparisons++;
            if (dictionary.get(i).equalsIgnoreCase(word)) { // Case-insensitive comparison
                System.out.println("Word found with linear search after " + comparisons + " checks.");
                return comparisons;
            }
        }
        System.out.println("Word not found with linear search after " + comparisons + " checks.");
        return comparisons;
    }

    /**
     * Binary search method that finds a word in the dictionary.
     * Returns the number of words checked during the search.
     */
    public int binarySearch(String word) {
        int left = 0;
        int right = dictionary.size() - 1;
        int comparisons = 0;

        while (left <= right) {
            int middle = (left + right) / 2;
            comparisons++;
            String currentWord = dictionary.get(middle);

            int comparison = currentWord.compareToIgnoreCase(word); // Case-insensitive comparison

            if (comparison < 0) {
                left = middle + 1;
            } else if (comparison > 0) {
                right = middle - 1;
            } else {
                System.out.println("Word found with binary search after " + comparisons + " checks.");
                return comparisons;
            }
        }
        System.out.println("Word not found with binary search after " + comparisons + " checks.");
        return comparisons;
    }

    public static void main(String[] args) throws IOException {
        spellChecker checker = new spellChecker();
//      // Word to check
      String word = "aah"; // Change this to test different words

      // Linear search
      int linearChecks = checker.linearSearch(word);

      // Binary search
      int binaryChecks = checker.binarySearch(word);

      // Results
      System.out.println("Linear search steps for \"" + word + "\": " + linearChecks);
      System.out.println("Binary search steps for \"" + word + "\": " + binaryChecks);
//
//        // Prompt user for input
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a word to search in the dictionary: ");
//        String word = scanner.nextLine();
//        // Perform searches
//        int linearChecks = checker.linearSearch(word);
//        int binaryChecks = checker.binarySearch(word);
//
//        // Display results
//        System.out.println("\nResults:");
//        System.out.println("Linear search checks for \"" + word + "\": " + linearChecks);
//        System.out.println("Binary search checks for \"" + word + "\": " + binaryChecks);
    }
}
