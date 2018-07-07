package net.kjp12.bic.whitespace;//Created on 7/7/18.

public class Main {

    /**
     * Iterates through every argument to iterate through every character to test if it's a whitespace.
     * So even char ' ' (0x20) gets counted if allowed to be passed in.
     * <p>
     * Prints out the following if a whitespace is found
     * <p>
     * 1
     * Found `u20` at 7 in `String Test`
     * <p>
     * then exits with 1, else it will print out '0' then exit with 0
     * <p>
     * Why? Because I can.
     */
    public static void main(String[] args) {
        for (String s : args) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (Character.isWhitespace(c)) {
                    System.out.println(1);
                    System.out.print("Found `u");
                    System.out.print(Integer.toHexString(c));
                    System.out.print("` at ");
                    System.out.print(i);
                    System.out.print(" in `");
                    System.out.print(s);
                    System.out.println('`');
                    System.exit(1);
                    return;
                }
            }
        }
        System.out.println(0);
        System.exit(0);
    }
}
