import static java.lang.System.out;

import java.util.Scanner;
import static Feature.Q1.q1_main;
import static Feature.Q2.q2_main;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.println("1. Q1\n2. Q2\n3. Exit the Program");
        out.println("원하는 메뉴를 입력하세요 : ");

        int selectMenu = sc.nextInt();

        if (selectMenu == 1) {
            q1_main(selectMenu);
        } else if (selectMenu == 2) {
            q2_main(selectMenu);
        } else {
            System.exit(0);
        }

        sc.close();
    }
}
