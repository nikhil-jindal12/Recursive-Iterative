public class Assignment1 {
    
    public static boolean palindromeIterative(String input) {

        input = input.trim().toLowerCase();
        
        for (int i = 0, e = input.length() - 1; i < input.length()/2; i++, e--) {

            while ((input.charAt(i) < 'a' || input.charAt(i) > 'z' || input.charAt(i) < '0' || input.charAt(i) > '9') && i < input.length()/2) {
                i++;
            }

            while ((input.charAt(e) < 'a' || input.charAt(e) > 'z' || input.charAt(e) < '0' || input.charAt(e) > '9') && e > input.length()/2) {
                e--;
            }

            if (input.charAt(i) != input.charAt(e)) {
                return false;
            }

        }

        return true;

    }

    // public boolean palindromeRecursive(String input) {

    //     input = input.trim().toLowerCase();



    // }

    public static void main(String[] args) {
        System.out.println(palindromeIterative("A man, a plan, a canal, Panama!"));
        System.out.println(palindromeIterative("123454321"));

    }

}
