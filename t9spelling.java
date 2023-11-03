//Student ID: A0255683U
//Name: Lee Youngjin

import java.util.*;

public class t9spelling {
    public static void main(String[] args) {
        // create dictionary of phone keypad
        Hashtable<Character, String> keypad = new Hashtable<Character, String>();
        keypad.put('a', "2");
        keypad.put('b', "22");
        keypad.put('c', "222");
        keypad.put('d', "3");
        keypad.put('e', "33");
        keypad.put('f', "333");
        keypad.put('g', "4");
        keypad.put('h', "44");
        keypad.put('i', "444");
        keypad.put('j', "5");
        keypad.put('k', "55");
        keypad.put('l', "555");
        keypad.put('m', "6");
        keypad.put('n', "66");
        keypad.put('o', "666");
        keypad.put('p', "7");
        keypad.put('q', "77");
        keypad.put('r', "777");
        keypad.put('s', "7777");
        keypad.put('t', "8");
        keypad.put('u', "88");
        keypad.put('v', "888");
        keypad.put('w', "9");
        keypad.put('x', "99");
        keypad.put('y', "999");
        keypad.put('z', "9999");

        Scanner sc = new Scanner(System.in);
        // first given number is number of test cases
        int num = sc.nextInt();
        sc.nextLine();

        // loop through each test case
        for (int i = 0; i < num; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            String text = sc.nextLine();
            int len = text.length();
            String digits = "";

            boolean space = false;

            for (int j = 0; j < len; j++) {
                char c = text.charAt(j);

                if (c == ' ') {
                    if (!space) {
                        digits = digits + "0";
                        space = true;
                    }

                    else if (space) {
                        digits = digits + " 0";
                        space = true;
                    }
                }

                else if (keypad.containsKey(c)) {
                    String output = keypad.get(c);
                    if (j > 0 && (keypad.containsKey(text.charAt(j - 1)))
                            && (keypad.get(text.charAt(j - 1)))
                                    .charAt(keypad.get(text.charAt(j - 1)).length() - 1) == (output.charAt(0))) {
                        digits = digits + " " + output;
                    } else {
                        digits = digits + output;
                    }
                    space = false;

                }

            }
            System.out.println(digits);
        }

        sc.close();
    }
}
