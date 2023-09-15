public class Assignment1 {
    
    public static boolean palindromeIterative(String input) {

        input = input.trim().toLowerCase();
        
        for (int i = 0, e = input.length() - 1; i < input.length()/2; i++, e--) {

            while ((input.charAt(i) < 'a' || input.charAt(i) > 'z') && (input.charAt(i) < '0' || input.charAt(i) > '9') && i < input.length()/2) {
                i++;
            }

            while ((input.charAt(e) < 'a' || input.charAt(e) > 'z') && (input.charAt(e) < '0' || input.charAt(e) > '9') && e > input.length()/2) {
                e--;
            }

            if (input.charAt(i) != input.charAt(e)) {
                return false;
            }

        }

        return true;

    }

    public static boolean palindromeRecursive(String input) {

        input = input.toLowerCase();
        return myPalindromeRecursive(input, 0, input.length() - 1);

    }

    private static boolean myPalindromeRecursive(String input, int left, int right) {
        
        // Recursive case
        while (left < right && (input.charAt(left) < 'a' || input.charAt(left) > 'z') && (input.charAt(left) < '0' || input.charAt(left) > '9')) {
            left++;
        }

        while (right > left && (input.charAt(right) < 'a' || input.charAt(right) > 'z') && (input.charAt(right) < '0' || input.charAt(right) > '9')) {
            right--;
        }

        // Base case
        if (left >= right) {
            return true;
        }

        if (input.charAt(left) != input.charAt(right)) {
            return false;
        }
        else {
            return myPalindromeRecursive(input, left + 1, right - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(palindromeRecursive("A man, a plan, a canal, Panama!"));
        System.out.println(palindromeRecursive("123454321"));
    

        System.out.println(palindromeRecursive("A man, a pan, a canal, Panama!"));
        System.out.println(palindromeRecursive("12454321"));
        // System.out.println(palindromeRecursive("123454321"));


    }

}
