package net.kjp12.bic.whitespace;//Created on 7/7/18.

import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.toHexString;
import static java.lang.Integer.toUnsignedString;
import static java.lang.System.out;

public class Main {
    private static final boolean[] b = new boolean[2];
    private static int exit;

    /**
     * Iterates through every argument to iterate through every character to test if it's a whitespace.
     * If no arguments are available, it uses the Standard Input Stream as its source instead.
     *
     * Why? Because I can.
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            try (InputStreamReader isr = new InputStreamReader(System.in)) {
                char[] chars = new char[1024];
                int index;
                while ((index = isr.read(chars)) >= 0)
                    testChars(chars, index);
            }
        } else for (String arg : args) {
            out.println(arg);
            testChars(arg.toCharArray());
        }
        out.println(exit);
        System.exit(exit);
    }

    public static void testChars(char[] chars) {
        testChars(chars, chars.length);
    }

    public static void testChars(char[] chars, int a) {
        for (int i = 0; i < a; i++) {
            if ((b[0] = Character.isWhitespace(chars[i])) || (b[1] = Character.isSpaceChar(chars[i]))) {
                out.append("`u").append(toHexString(chars[i]))
                        .append(b[0] && b[1] ? "` is white space & space char at " : b[0] ? "` is white space at " : "` is space char at ")
                        .append(toUnsignedString(i))
                        .println();
                exit = 1;
            }
        }
    }
}
