# Recursive-Iterative
This program uses both iterative and recursive approaches to implement the following:
- `palindromeIterative` & `palindromeRecursive`: Check if a string is a palindrome 
  - This method is written using both iterative and recursive approaches, however, only the iterative method is called in the implementation
- `anagramChecker`: Check if two strings are anagrams 
- `addSubstring`: Adding a substring into a string at a given index 
- `getLength`: Returning the length of a string
- `occurrenceCounter`: Counting the number of times a substring is in another string 
- `sentenceReversal`: Reversing the order of the words in a sentence
---------------------
Each method was written while keeping the big-O time complexity in mind. The big-O time complexity for each of the methods is as follows:
- `palindromeIterative` - O(n)
- `palindromeRecursive` - O(n)
- `anagramChecker` - O(n^2)
- `addSubstring` - O(n)
- `getLength` - O(1)
- `occurrenceCounter` - O(n * m)
- `sentenceReversal` - O(n)
---------------------
When running the Java file, the program should continuously run while presenting the user with an option menu upon startup. The option menu prints out the options of the functions mentioned above, and also a quit option that can be used to stop the program. When first starting up, the option menu looks like this: <br><br>
Welcome to the App
1. Palindrome Check
2. Anagram Check
3. Add Substring
4. Get Length
5. Count Occurrences
6. Reverse Sentence
7. Quit

Choose an Option:
