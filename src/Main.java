import static Page.Q1.q1_main;
import static Page.ArrayQ2.array_q2_main;
import static Page.Q4.q4_main;
import static Page.Q2.q2_main;
import static java.lang.System.out;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.println("1. Q1\n2. Q2\n3. Q3\n4. Q4\n5. ArrayList Q2\n6. Exit the Program");
        out.println("원하는 메뉴를 입력하세요 : ");

        int selectMenu = sc.nextInt();

        if (selectMenu == 1) {
            q1_main(selectMenu);
        } else if (selectMenu == 2) {
            q2_main(selectMenu);
        } else if (selectMenu == 3) {
            out.println("아직 메뉴가 구성이 되지 않았습니다.");
            System.exit(0);
        } else if (selectMenu == 4) {
            q4_main(selectMenu);
        } else if (selectMenu == 5) {
            array_q2_main(selectMenu);
        } else {
            System.exit(0);
        }

        sc.close();
    }
}
