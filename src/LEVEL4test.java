import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class LEVEL4test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int len = 0;
            boolean alpha[] = new boolean[125];
            String pattern = "";

            String input = sc.next();
            for (int i = 0; i < input.length(); i++) {
                if (!alpha[(int) input.charAt(i)]) {
                    alpha[(int) input.charAt(i)] = true;
                    pattern += input.charAt(i);
                    out.println(pattern);
                } else {
                    String competition = "";
                    len = pattern.length();

                    for (int k = len; k < len * 2; k++) {
                        competition += input.charAt(k);
                    }

                    if (pattern.equals(competition))
                        break;

                    else {
                        pattern += input.charAt(i);
                        out.println(pattern);
                    }
                }
            }
            System.out.println("#" + t + " " + len);
        }
        sc.close();
    }
}
