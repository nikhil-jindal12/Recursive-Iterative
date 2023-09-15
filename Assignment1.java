/**
 * Class that has multiple methods that are written using recursion or iteration
 * Methods are called and used based on their big-O efficiency and time complexity
 * @author Nikhil Jindal
 */
public class Assignment1 {
    
    /**
     * Finds whether the input is a palindrome in an iterative fashion
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
     * Helper method for the recursive palindrome checker
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
     * @param x  first string to compare
     * @param y  second string to compare
     * @return  true if one string is the anagram of another
     */
    public static boolean anagramChecker(String x, String y) {
        char[] xarr = x.toLowerCase().toCharArray();
        char[] yarr = y.toLowerCase().toCharArray();

        
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

        for (int i = 0; i < xarr.length; i++) {
            if (Character.isLetterOrDigit(xarr[i])) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Returns the substring added to the input given the specific index
     * @param input  string which will include the substring
     * @param substring  string to be added to the input
     * @param index  index at which to insert substring
     * @return  the substring added to the input at the given index
     */
    public static String addSubstring(String input, String substring, int index) {
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < index; i++) {
            builder.append(input.charAt(i));
        }
        builder.append(substring);
        for (int i = index; i < input.length(); i++) {
            builder.append(input.charAt(i));
        }

        return builder.toString();

    }

    /**
     * Returns the length of a given input string
     * @param input  a string
     * @return  the length of the given input string
     */
    public static int getLength(String input) {
        return input.length();
    }

    /**
     * Returns the number of occurrences of a specified substring in the input string
     * @param input  the string to search for the substring in
     * @param substring  the string you want to search for
     * @return  the number of times that the substring is found in the input string
     */
    public static int occurrenceCounter(String input, String substring) {
        return 1;
    }

    /**
     * Returns the sentence string in the reverse order of words
     * @param input  a sentence string
     * @return  the sentence string in the reverse order of words
     */
    public static String sentenceReversal(String input) {
        return true;
    }


    public static void main(String[] args) {
        // System.out.println(palindromeRecursive("A man, a plan, a canal, Panama!"));
        // System.out.println(palindromeRecursive("123454321"));
        // System.out.println(palindromeRecursive("A man, a pan, a canal, Panama!"));
        // System.out.println(palindromeRecursive("12454321"));
        // System.out.println(palindromeRecursive("123454321"));

        // System.out.println(anagramChecker("listen", "silent"));
        // System.out.println(anagramChecker("Mother-in-law", "Woman Hitler"));

        // System.out.println(addSubstring("eat my dick", "cheese", 7));

        // System.out.println(getLength("0123456789"));
        // System.out.println(getLength("asdfghjkl"));

    }

}
