package Page;

import static java.lang.System.out;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import Feature.FileManager.FileManager;

public class Q4 {
    public static Scanner fileReader(FileManager fManager, String fileName) {
        return fManager.fileReader(fileName);
    }

    public static void writeFile(FileManager fManager, String fileName, String result) {
        fManager.fileWriter(fileName, result);
    }

    public static String getData(Scanner fileReader) {
        int getLineNumber = Integer.parseInt(fileReader.nextLine());
        String result = "";

        // String 을 입력받을 줄
        for (int i = 1; i <= getLineNumber; i++) {
            int stringLength = 0;
            boolean alphabet[] = new boolean[200];
            String pattern = "";

            String input = fileReader.next();
            for (int j = 0; j < input.length(); j++) {
                // 입력받은 문자열을 한 문자씩 차례차례 읽어온다.
                if (!alphabet[(int) input.charAt(j)]) {
                    alphabet[(int) input.charAt(j)] = true;
                    pattern += input.charAt(j);
                } else {
                    String competition = "";
                    stringLength = pattern.length();

                    for (int k = stringLength; k < stringLength * 2; k++) {
                        competition += input.charAt(k);
                    }

                    // 읽어온 문자열과 읽어온 문자열을 저장한 competition 을 비교해
                    // 만약 pattern 과 competition 가 같다면, 안쪽 for 문을 탈출하여
                    // 반복되는 문자열의 길이를 출력한다.
                    if (pattern.equals(competition))
                        break;
                    else {
                        pattern += input.charAt(j);
                        out.println(pattern);
                    }
                }
            }
            System.out.println("#" + i + " " + stringLength);
            result += "#" + i + " " + stringLength;
        }
        return result;
    }

    public static void getFile(FileManager fManager, Scanner fileReader, String fileName) {
        String getResult = getData(fileReader);
        writeFile(fManager, fileName, getResult);
    }

    public static void q4_main(int selectNum) {
        File file = null;
        Scanner fileReader = null;
        FileWriter fileWriter = null;
        FileManager fManager = new FileManager(file, fileReader, fileWriter);

        String readFileName = "input4.txt";
        String writeFileName = "output4.txt";

        Scanner sc = new Scanner(System.in);
        out.println("선택하세요.\n1. 파일 입출력\n2. 직접 입력하기");

        int selectQ3MenuNum = sc.nextInt();

        if (selectQ3MenuNum == 1) {
            fileReader = fileReader(fManager, readFileName);
            // int getLineNumber = Integer.parseInt(fileReader.nextLine());
            // out.println(getLineNumber);
            getFile(fManager, fileReader, writeFileName);
        } else if (selectQ3MenuNum == 2) {
            fileReader = new Scanner(System.in);
            getFile(fManager, fileReader, writeFileName);
            // int getLineNumber = fileReader.nextInt();
            // getFile(fManager, getLineNumber, writeFileName);
        } else {
            out.println("프로그램을 종료합니다");
            System.exit(0);
        }

        sc.close();
    }
}
