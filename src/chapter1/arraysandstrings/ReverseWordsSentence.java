package chapter1.arraysandstrings;

import static util.Utils.printInput;

/**
 * Given a sentence, reverse the words of the sentence.
 * For example, "i live in a house" becomes "house a in live i".
 */
public class ReverseWordsSentence {
    public static void main(String[] args) {
        String str = "i live in a house";
        printInput(reverseWords(str));
        printInput(reverseString(str));
    }

    private static String reverseWords(String str) {
        StringBuilder reversedString = new StringBuilder();
        String[] words = str.split(" ");
        for(int i = words.length - 1; i >= 0; i--){
            reversedString.append(words[i]).append(" ");
        }

        return reversedString.toString().trim();
    }

    // if split method is not allowed
    private static String reverseString(String inputString){
        StringBuilder reversedString = new StringBuilder();
        int currentWordAtIndex = inputString.length();

        for(int i = inputString.length() - 1; i >= 0; i--){
            if(inputString.charAt(i) == ' '){
                reversedString = appendWord(reversedString, inputString.substring(i+1, currentWordAtIndex));
                currentWordAtIndex = i;
            }
        }

        String firstWord = inputString.substring(0, currentWordAtIndex);
        return appendWord(reversedString, firstWord).toString();
    }

    private static StringBuilder appendWord(StringBuilder reversedString, String wordToAppend){
        if(reversedString.length() > 0){
            reversedString.append(' ');
        }
        reversedString.append(wordToAppend);
        return reversedString;
    }
}
