/**
 * RedWhiteAndBlue
 * Level: Medium
 * Note: This solution uses Enums and Exceptions. While optional, it always looks good if you use them in an interview.
 * You're given a list of Marbles. Each marble can have one of 3 colors (Red, White or Blue).
 * Arrange the marbles in order of the colors (Red -> White -> Blue).
 * <p>
 * Colors are represented as follows:
 * 0 - Red
 * 1 - White
 * 2 - Blue
 * <p>
 * For example,
 * A = [1,0,1,2,1,0,1,2],
 * Output = [0,0,1,1,1,1,2,2].
 */
package chapter1.arraysandstrings;

import static util.Utils.*;

enum Color {
    RED(0),
    WHITE(1),
    BLUE(2);
    
    public final int colorId;
    
    Color(int colorId) {
        this.colorId = colorId;
    }
    
    public int getColorId() {
        return colorId;
    }
}

/**
 * @author mandeep
 */
public class RedWhiteAndBlue {
    
    public static void main(String args[]) {
        Integer[] arr = {1, 0, 1, 2, 1, 0, 1, 2};
        printArray(redWhiteAndBlue(arr));
    }
    
    private static Integer[] redWhiteAndBlue(Integer[] arr) {
        if (checkIfArrayIsNull(arr))
            return arr;
        int low = 0, high = arr.length - 1, i = 0;
        
        while (i <= high) {
            if (arr[i] == Color.RED.getColorId()) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] == Color.WHITE.getColorId()) {
                i++;
            } else if (arr[i] == Color.BLUE.getColorId()) {
                swap(arr, i, high);
                high--;
            } else {
                throw new IllegalArgumentException("Unknow Color " + arr[i]);
            }
        }
        return arr;
    }
}

class Marble {
    private Color color;
    private int data;
    
    public Marble(Color color, int data) {
        this.color = color;
        this.data = data;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
}
