import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("-------Password Generator by Covenant-------");
        System.out.println("--------------------------------------------");

        char[] str = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '!', '@', '#', '$', '%', '^', '&', '*', '_',
        };

        char[] specialStr = {
                '!', '@', '#', '$', '%', '^', '&', '*', '_',
        };

        char[] num = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        };

        char[] lowerCase = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        };

        char[] upperCase = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        };


        Random random = new Random();
        boolean validateSpecial = false;
        boolean validateLower = false;
        boolean validateUpper = false;
        boolean validateNum = false;

        String concatString = "";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int randomNum = random.nextInt(str.length);

            concatString = concatString.concat(Character.toString(str[randomNum]));
            list.add(Character.toString(str[randomNum]));


            for (int j : num) {
                if (str[randomNum] == j) {
                    validateNum = true;
                    continue;
                }
            }

            for (int k : specialStr) {
                if (str[randomNum] == k) {
                    validateSpecial = true;
                    continue;
                }
            }

            for (int l : lowerCase) {
                if (str[randomNum] == l) {
                    validateLower = true;
                    continue;
                }
            }

            for (int m : upperCase) {
                if (str[randomNum] == m) {
                    validateUpper = true;
                    continue;
                }
            }

            if ((i == 7) && (!validateSpecial || !validateNum || !validateLower || !validateUpper)) {
                i = -1;
                concatString = "";
                list.clear();
            }
        }

        System.out.println("The generated password is " + concatString);
        System.out.println("\n\nThe password contains special character(s): " + validateSpecial);
        System.out.println("The password contains number(s): " + validateNum);
        System.out.println("The password contains lower case letter(s): " + validateLower);
        System.out.println("The password contains a upper case letter(s): " + validateUpper);
        System.out.println("The password length is " + list.size());

        if (validateSpecial && validateNum && validateLower && validateUpper) {
            System.out.println("\nThe password is strong");
        } else {
            System.out.println("\nWarning!!! The password might be weak, you may want to generate another one");
        }

    }
}