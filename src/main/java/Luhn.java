import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// Class names should always start with a capital and the file name must always match the class name
public class Luhn {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("16 Digit card");
        String sixteenDigit = input.nextLine();

        //We dont define the implementation for the variable defifitions for lists / maps etc basically anything that implements a interface so in the future the implementation
        // is not coupled with code and we do not rely on the implementation details
        List<Integer> cardNumbers = new LinkedList<Integer>(); // For arrays / lists the variables should be plural
        List<Integer> values = new LinkedList<Integer>(); // dont use list as a variable name because it's unreadable
        List<Integer> patterns = new LinkedList<Integer>(); // patterns is better 
        // A final node about these the var name was Pascal case in i.e CardNum -> cardNum

        int sixteenLength = sixteenDigit.length();
        static final int CARD_COUNT = 16;
        if(sixteenLength == CARD_COUNT /* Wierd one but 16 is what is known as a magic number and we should give these magic numbers a variable to make it more readable */) {
            for (var i = 0; i < sixteenLength; i++) {
                int currentChar = Integer.parseInt(String.valueOf(sixteenDigit.charAt(i)));
                cardNumbers.add(currentChar);

                int updated;
                int module = i % 2;

                if (module == 0) {
                    updated = Integer.parseInt(String.valueOf(currentChar)) * 2;
                    patterns.add(2);
                } else {
                    updated = Integer.parseInt(String.valueOf(currentChar));
                    patterns.add(1);
                }

                if (updated >= 10) {
                    String updatedString = String.valueOf(updated);
                    int first = Integer.parseInt(String.valueOf(updatedString.charAt(0)));
                    int second = Integer.parseInt(String.valueOf(updatedString.charAt(1)));
                    int third = first + second;
                    values.add(third);
                } else {
                    values.add(updated);
                }
            }

            //I like how your using using streams here :)
            int result = values.stream().mapToInt(Integer::intValue).sum();

            System.out.println(patterns);
            System.out.println(values);

            if (result % 10 == 0) {
                System.out.println("Result: " + result  + " Valid token");
            } else {
                System.out.println("Result: " + result  + " Invalid token");
            }
        }
    }
}
