package Page;

import static java.lang.System.out;

import java.util.Scanner;

import Feature.FileManager.FileManager;

public class Q2 {
    public static Scanner fileReader(FileManager fManager, String fileName) {
        return fManager.fileReader(fileName);
    }

    public static void writeFile(FileManager fManager, String fileName, String result) {
        fManager.fileWriter(fileName, result);
    }

    // randomRange 에서 getData 의 사용자 입력 값인 getValue 의 값을 가지고 와서 범위를 n1 ~ n2 로 설정한다.
    public static int randomRange(int n1, int n2) {

        return 0;
    }

    public static void q2_main(int selectNum) {
        // 1. 숫자 N 을 입력받을 때, q2_main 에서 임의의 정수 T 의 크기만큼 입력을 받는다.
        // 2. randomArray 를 선언하여 입력받은 숫자 N의 데이터들 (중복 되는 데이터 또한 포함) 모두 포함하여 저장한다.
        // 3. modeArray 를 선언하여 randomArray 내에 있는 데이터들과 모두 값을 비교한 후, 중복되는 값만 따로 저장한다.
        Scanner sc = new Scanner(System.in);
        out.println("선택하세요");
        out.println("1. 파일 입출력\n2. 직접 수량 입력 후 출력");

        int selectQ2MainNum = sc.nextInt();

        if (selectQ2MainNum == 1) {
            out.println(selectQ2MainNum);
        } else if (selectQ2MainNum == 2) {
            out.println(selectQ2MainNum);
        } else {
            out.println("프로그램을 종료합니다");
            System.exit(0);
        }

        sc.close();
    }
}
