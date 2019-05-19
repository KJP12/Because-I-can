import java.util.Arrays;

public class _6174 {
    public static void main(String[] arr){
        if(arr.length < 1) {
            System.err.println("Please insert a number to parse to 6174.");
            System.exit(1);
        } else try {
            System.out.println("Calculating with " + arr[0]);
            long l = System.nanoTime();
            int from = Integer.parseInt(arr[0]);
            int i = $6174(from);
            long f = System.nanoTime();
            System.out.println("Took " + i + " rounds and " + ((double)(f - l) / 1000000D) + "ms to calculate 6174 from " + from);
        } catch (RuntimeException t) {
            System.err.println("Failed to parse - " + t.getLocalizedMessage());
            System.exit(2);
        }
    }

    public static int $6174(int i){
        if(i < 1 | i > 9999) throw new IllegalArgumentException("Out of bounds of 0001 -> 9999");
        int[] arr = new int[4], rev = new int[4];
        toArr(i, arr);
        a: {
            for (int c = 1; c < arr.length; c++) if (arr[0] != arr[c]) break a;
            throw new IllegalArgumentException("There must be at least 2 unique numbers");
        }
        int c = 0;
        while(i != 6174){
            if(c == Integer.MAX_VALUE || c < 0) throw new RuntimeException("Too long to execute (Took " + Integer.toUnsignedString(c) + " rounds so far, state: " + combine(arr) + " to " + combine(rev) + ")");
            c++;
            Arrays.sort(toArr(i, arr));
            for(int a = 3; a >= 0; a--) rev[a] = arr[3 - a];
            i = combine(rev) - combine(arr);
        }
        return c;
    }

    private static int[] toArr(int i, int[] arr){
        for(int c = arr.length - 1; c >= 0; c--) {
            arr[c] = i % 10;
            i = Math.floorDiv(i, 10);
        }
        return arr;
    }

    private static int combine(int[] arr){
        int i = 0;
        for(int c = 0; c < arr.length; c++) i += arr[c] * Math.pow(10, arr.length - (c + 1));
        return i;
    }
}
