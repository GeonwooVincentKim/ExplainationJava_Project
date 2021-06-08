public class TsetTest {
    public static void main(String[] args) {
        int[] x = { 2, 2, 3, 5, 6, 3, 5, 6, 7, 8, 9, 1, 7 };
        // Integer[] o = new Integer[x.length];
        int[] o = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            o[i] = Integer.valueOf(x[i]);
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (o[i] == o[j]) {
                    o[j] = -1;
                }
            }
        }
        for (int i = 0; i < x.length; i++) {
            if (o[i] != -1)
                System.out.print(o[i] + " ");
        }
    }

}
