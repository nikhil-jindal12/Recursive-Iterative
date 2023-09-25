import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that has multiple methods that are written using recursion or iteration
 * Methods are called and used based on their big-O efficiency and time complexity
 * @author Nikhil Jindal
 */
public class Assignment1 {
    
    /**
     * Finds whether the input is a palindrome in an iterative fashion
     * This method has a big-O time complexity of O(n), where n is the length of the string that is inputted
     * @param input  the possible palindrome
     * @return  true, only if the parameter is a palindrome
     */
    public static boolean palindromeIterative(String input) {

        // trim whitespace at ends to lower traversals and make case insensitive
        input = input.trim().toLowerCase();
        
        // traverse from the beginning and the end at the same time, meeting in the middle of the input
        for (int i = 0, e = input.length() - 1; i < input.length()/2; i++, e--) {

            // ignore any characters that are not letters or numbers
            while ((input.charAt(i) < 'a' || input.charAt(i) > 'z') && (input.charAt(i) < '0' || input.charAt(i) > '9') && i < input.length()/2) {
                i++;
            }

            // ignore any characters that are not letters or numbers
            while ((input.charAt(e) < 'a' || input.charAt(e) > 'z') && (input.charAt(e) < '0' || input.charAt(e) > '9') && e > input.length()/2) {
                e--;
            }

            // verify that the characters at those positions are the same
            if (input.charAt(i) != input.charAt(e)) {
                return false;
            }

        }

        // return true if the entire input was traversed and no faults were found
        return true;

    }

    /**
     * Checks to see if the input is a palindrome using recursion
     * This method has a big-O time complexity of O(n), where n is the length of the string that is inputted
     * @param input  a possible palindrome
     * @return  true, only if the parameter is a palindrome
     */
    public static boolean palindromeRecursive(String input) {

        // trim any whitespace to get rid of uneccesary traversals and make case insensitive
        input = input.trim().toLowerCase();

        // call the recursive method
        return myPalindromeRecursive(input, 0, input.length() - 1);

    }

    /**
     * Helper method for the recursive palindrome checker (palindromeRecursive)
     * @param input  a possible palindrome
     * @param left  the beginning index of the input to check
     * @param right  the last most index value of the input to check
     * @return  true, only if the input is a palindrome and the entire input has been traversed
     */
    private static boolean myPalindromeRecursive(String input, int left, int right) {
        
        // RECURSIVE CASE
        // ignore any characters that are not letters or numbers
        while (left < right && (input.charAt(left) < 'a' || input.charAt(left) > 'z') && (input.charAt(left) < '0' || input.charAt(left) > '9')) {
            left++;
        }

        // ignore any characters that are not letters or numbers
        while (right > left && (input.charAt(right) < 'a' || input.charAt(right) > 'z') && (input.charAt(right) < '0' || input.charAt(right) > '9')) {
            right--;
        }

        // BASE CASE
        if (left >= right) {
            return true;
        }

        // check to see if the characters at the ends match
        if (input.charAt(left) != input.charAt(right)) {
            return false;
        }

        // keep checking the "middle" by calling the method again
        else {
            return myPalindromeRecursive(input, left + 1, right - 1);
        }
    }

    /**
     * Returns true if one string is an anagram of the other
     * In the worst-case, this method has a big-O time complexity of O(n^2), where n is the length of either String
     * @param x  first string to compare
     * @param y  second string to compare
     * @return  true if one string is the anagram of another
     */
    public static boolean anagramChecker(String x, String y) {
        
        // if the two strings are not the same length, they cannot be anagrams
        if (x.length() != y.length()) {
            return false;
        }
        
        // convert each string to an array of characters
        char[] xarr = x.toLowerCase().toCharArray();
        char[] yarr = y.toLowerCase().toCharArray();

        // go through the entire first array and remove the same letter from both arrays if it is present in both places
        for (int i = 0; i < xarr.length; i++) {
            while (!Character.isLetterOrDigit(xarr[i]) && i < xarr.length) {
                i++;
            }
            for (int j = 0; j < yarr.length; j++) {
                if (xarr[i] == yarr[j]) {
                    xarr[i] = ' ';
                    yarr[j] = ' ';
                }
            }
        }

        // if any characters are left in the array, then the two strings are not anagrams
        for (int i = 0; i < xarr.length; i++) {
            if (Character.isLetterOrDigit(xarr[i])) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Returns the substring added to the input given the specific index
     * This method has a big-O time complexity of O(n), where n is the length of the input
     * @param input  string which will include the substring
     * @param substring  string to be added to the input
     * @param index  index at which to insert substring
     * @return  the substring added to the input at the given index
     */
    public static String addSubstring(String input, String substring, int index) {
        
        // create a StringBuilder that will allow the creation of a new String
        StringBuilder builder = new StringBuilder();

        // add the section before the specified index to the builder
        for (int i = 0; i < index; i++) {
            builder.append(input.charAt(i));
        }

        // add the substring to the builder
        builder.append(substring);

        // add the rest of the initial input to the builder
        for (int i = index; i < input.length(); i++) {
            builder.append(input.charAt(i));
        }

        // return the result of the builder
        return builder.toString();

    }

    /**
     * Returns the length of a given input string
     * This method has a big-O time complexity of O(1), since the String class keeps a count of the characters in a String so it does not have to iterate through the String
     * @param input  a string
     * @return  the length of the given input string
     */
    public static int getLength(String input) {
        // return the String's length using the built-in function
        return input.length();
    }

    /**
     * Returns the number of occurrences of a specified substring in the input string
     * This method has a big-O time complexity of O(n * m), where n is the length of the input string and m is the length of the substring 
     * @param input  the string to search for the substring in
     * @param substring  the string you want to search for
     * @return  the number of times that the substring is found in the input string
     */
    public static int occurrenceCounter(String input, String substring) {
        
        // start looking for occurrences at the first index of the string
        int index = 0;

        // call the recursive statement to start looking from the first index
        return myOccurrenceCounter(input.toLowerCase(), substring.toLowerCase(), index);

    }
    
    /**
     * Helper method that uses recursion to search for a specified substring within another String (occurrenceCounter)
     * @param input  the String to search for the substring
     * @param substring  the String we want to search for
     * @param index  the index value of the input we have already checked to
     * @return  1 only if the substring is found, and will recursively call itself until the entire input has been traversed
     */
    private static int myOccurrenceCounter(String input, String substring, int index) {
        
        // base case
        if (input.length() < substring.length()) {
            return 0;
        }
        
        // update the index value
        index = input.indexOf(substring, 0);
        
        // recursive case
        if (index != -1) {
            return 1 + myOccurrenceCounter(input.substring(index + substring.length()), substring, index);
        }
        else {
            return 0;
        }

    }

    /**
     * Returns the sentence string in the reverse order of words
     * This method has a big-O time complexity of O(n), where n is the length of the input String
     * @param input  a sentence string
     * @return  the sentence string in the reverse order of words
     */
    public static String sentenceReversal(String input) {
        
        // initialize a StringBuilder to create a new string to return
        StringBuilder builder = new StringBuilder();

        // turn the String into an array of Strings split up with every space
        String[] sentence = input.split(" ");

        // add each index of the array to the builder in reverse order
        for (int i = sentence.length - 1; i >= 0; i--) {
            builder.append(sentence[i]);
            if (i > 0) {
                builder.append(" ");
            }
        }

        // return the String version of the builder
        return builder.toString();

    }

    /**
     * Prompts the user for continuous inputs and allows them to select from each of the 6 different methods that are present in the class
     * @param args  no arguments should be passed in the main method
     */
    public static void main(String[] args) {
        
        // initialize the scanner to take input from the user
        Scanner sc = new Scanner(System.in);

        // welcome the user to the application
        System.out.println("Welcome to the App");

        // continuously prompt the user for options until they choose the 'Quit' option
        while (true) {
            
            // present the options to the user after every time they run a method
            System.out.print("1. Palindrome Check\n2. Anagram Check\n3. Add Substring\n4. Get Length\n5. Count Occurrences\n6. Reverse Sentence\n7. Quit\n\nChoose an Option: ");
            
            // user the scanner to determine which method to run and catch any inputs that are not integers
            int input = -1;
            boolean isValid = false;

            while (!isValid) {
                try {
                    // keep trying to set the input until a valid integer is given, at which point the loop will be broken
                    input = sc.nextInt();
                    isValid = true;
                } catch (InputMismatchException e) {
                    // print an invalid response statement to the user and reprompt them
                    System.out.print("Invalid Option. Please select a valid number between 1 and 7.\nChoose an Option: ");
                } finally {
                    // get rid of the next line character that is left in the scanner's buffer
                    sc.nextLine();
                }
            }

            // implementation of the palindromeIterative method
            // Using palindromeIterative here instead of palindromeRecursive since it will take less memory
            if (input == 1) {

                // ask user for possible palindrome
                System.out.print("\nEnter String: ");

                // get input from scanner
                String x = ""; 
                while (x.equals("")) {
                    x = sc.nextLine();
                }

                // print a message to the user depending on the result of the method
                if (palindromeIterative(x) == true) {
                    System.out.println("\nYour input \'" + x + "\' is a palindrome!\n");
                }
                else {
                    System.out.println("\nYour input \'" + x + "\' is not a palindrome!\n");
                }
            }

            // implementation of the anagramChecker method
            else if (input == 2) {

                // prompt user for the first string
                System.out.print("\nEnter String: ");

                // get and store their input from the scanner
                String x = ""; 
                while (x.equals("")) {
                    x = sc.nextLine();
                } 

                // prompt the user for the second string
                System.out.print("Enter Possible Anagram: ");

                // get and store their input from the scanner
                String y = sc.nextLine();

                // print a message to the user depending on the result of the method
                if (anagramChecker(x, y) == true) {
                    System.out.println("\n\'" + x + "\' and \'" + y + "\' are anagrams of one another!\n");
                }
                else {
                    System.out.println("\n\'" + x + "\' and \'" + y + "\' are not anagrams of one another.\n");
                }
            }

            // implementation of the addSubstring method
            else if (input == 3) { 

                // prompt user for the first string
                System.out.print("Enter String: ");

                // get and store their input from the scanner
                String in = "";
                while (in.equals("")) {
                    in = sc.nextLine();
                }

                // prompt the user for the second string
                System.out.print("Substring to be Inserted: ");

                // get and store their input from the scanner
                String sub = "";
                while (sub.equals("")) {
                    sub = sc.nextLine();
                }

                // prompt the user for the index value they want to place the substring
                System.out.print("Index Placement: ");

                // get and store the user's input from the scanner, ensuring that it is within the correct bounds
                int idx = sc.nextInt();
                while (idx <= 0 || idx > in.length()) {
                    System.out.print("Invalid index. Please insert a valid index.\nIndex Placement: ");
                    idx = sc.nextInt();
                }

                // print a message to the user indicating the new string that was created
                System.out.println("\nNew String: " + addSubstring(in, sub, idx) + "\n");
            }

            // implementation of the getLength method
            else if (input == 4) {

                // prompt the user for a string
                System.out.print("\nEnter String: ");

                // get and store the user's input from the scanner
                String in = "";
                while (in.equals("")) {
                    in = sc.nextLine();
                }

                // print a message to the user indicating the number of characters in their string
                System.out.println("\nYour string has a length of " + getLength(in) + " characters.\n");
            }

            // implementation of the occurrenceCounter method
            else if (input == 5) {

                // prompt the user for the first string
                System.out.print("\nEnter String: ");

                // get and store the user's input from the scanner
                String in = "";
                while (in.equals("")) {
                    in = sc.nextLine();
                }

                // prompt the user for the second string
                System.out.print("Enter String to Look For: ");

                // get and store the user's input from the scanner
                String sub = "";
                while (sub.equals("")) {
                    sub = sc.nextLine();
                }

                // print a message to the user letting them know how many times the substring was found
                System.out.println("\nThe substring \'" + sub + "\' appears in the string \'" + in + "\' " + Integer.toString(occurrenceCounter(in, sub)) + " times.\n");
            }

            // implementation of the sentenceReversal method
            else if (input == 6) {

                // prompt the user for a sentence
                System.out.print("\nEnter Sentence: ");
                
                // get and store the user's input from the scanner
                String in = "";
                while (in.equals("")) {
                    in = sc.nextLine();
                }

                // print a message to the user showing the reverse of their sentence
                System.out.println("\n The reverse of that sentence is \'" + sentenceReversal(in) + "\'.\n");
            }

            // implementation of quitting the application
            else if (input == 7) {

                // wish the user a nice day, close the scanner, and break out of the infinite loop
                System.out.println("\nHave a nice day :)\n");
                sc.close();
                break;
            }
                
        }

    }

}
