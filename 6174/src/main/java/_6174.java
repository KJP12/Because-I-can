import java.util.Arrays;

public class $6174 {
    public static void main(String[] arr){
        if(arr.length < 1) {
            System.err.println("Please insert a number to parse to 6174.");
            System.exit(1);
        } else try {
            System.out.println("Calculating...");
            int from = Integer.parseInt(arr[0]);
            int i = $6174(from);
            System.out.println("Took " + i + " rounds to calculate 6174 from " + from);
        } catch (RuntimeException t) {
            System.err.println("Failed to parse - " + t.getLocalizedMessage());
            System.exit(2);
        }
    }

    public static int $6174(int i){
        if(i < 1000) throw new IllegalArgumentException("below 1000 integer");
        if(Math.floorDiv(i, 10000) > 0) throw new IllegalArgumentException("number above 4 digits");
        int[] arr = new int[4], rev = new int[4];
        int c = 0;
        while(i != 6174){
            if(c > 1 << 3) throw new RuntimeException("Too long to execute (Took " + c + " rounds so far, state: " + combine(arr) + " to " + combine(rev) + ")");
            c++;
            arr[0] = Math.floorDiv(i, 1000);
            arr[1] = Math.floorDiv(i % 1000, 100);
            arr[2] = Math.floorDiv(i % 100, 10);
            arr[3] = i % 10;
            Arrays.sort(arr);
            for(int a = 3; a >= 0; a--) rev[a] = arr[3 - a];
            int a = combine(arr), b = combine(rev);
            i = a < b ? a - b : b - a;
        }
        return c;
    }

    private static int combine(int[] arr){
        int i = 0;
        for(int c = 0; c < arr.length; c++) i += arr[c] * Math.pow(10, arr.length - c);
        return i;
    }
}
