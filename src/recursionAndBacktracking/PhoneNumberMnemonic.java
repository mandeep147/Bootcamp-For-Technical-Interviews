/**
 * Phone Number Mnemonic Problem:
 * Given an N digit phone number, print all the strings that can be made from that phone number.
 * Since 1 and 0 don't correspond to any characters, ignore them.
 * For example:
 * 213 => AD, AE, AF, BD, BE, BF, CD, CE, CF
 * 456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc.
 */
package recursionAndBacktracking;

import java.util.HashMap;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printArrayToIndex;

/**
 * @author mandeep
 */
public class PhoneNumberMnemonic {
    static HashMap<Integer, Character[]> map = new HashMap<>();
    
    private static void buildMap() {
        map.put(0, new Character[]{});
        map.put(1, new Character[]{});
        map.put(2, new Character[]{'A', 'B', 'C'});
        map.put(3, new Character[]{'D', 'E', 'F'});
        map.put(4, new Character[]{'G', 'H', 'I'});
        map.put(5, new Character[]{'J', 'K', 'L'});
        map.put(6, new Character[]{'M', 'N', 'O'});
        map.put(7, new Character[]{'P', 'Q', 'R', 'S'});
        map.put(8, new Character[]{'T', 'U', 'V'});
        map.put(9, new Character[]{'W', 'X', 'Y', 'Z'});
    }
    
    public static void main(String[] args) {
        buildMap();
        generatePhoneNumberMnemonics(new Integer[]{2, 3, 7});
        generatePhoneNumberMnemonics(new Integer[]{2, 3, 0});
        generatePhoneNumberMnemonics(new Integer[]{2, 1, 0});
    }
    
    private static void generatePhoneNumberMnemonics(Integer[] phoneNumber) {
        if (checkIfArrayIsNull(phoneNumber)) {
            return;
        }
        printPhoneNumberMnemonics(phoneNumber, new Character[phoneNumber.length], 0, 0);
    }
    
    private static void printPhoneNumberMnemonics(Integer[] arr, Character[] buffer, int nextIndex, int bufferIndex) {
        if (bufferIndex >= buffer.length || nextIndex >= arr.length) {
            printArrayToIndex(buffer, bufferIndex);
            return;
        }
        
        Character[] letters = getLetters(arr[nextIndex]);
        if (letters.length == 0) {
            printPhoneNumberMnemonics(arr, buffer, nextIndex + 1, bufferIndex);
        }
        
        for(char letter: letters ) {
            buffer[bufferIndex] = letter;
            printPhoneNumberMnemonics(arr, buffer, nextIndex + 1, bufferIndex + 1);
        }
    }
    
    private static Character[] getLetters(int digit) {
        return map.get(digit);
    }
}
