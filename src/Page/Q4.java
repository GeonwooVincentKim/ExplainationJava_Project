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

    public static String getData(int getLineNumber) {
        String result = "";
        result = getLineNumber + " ";
        return result;
    }

    public static void getFile(FileManager fManager, int loopResult, String fileName) {
        String getResult = getData(loopResult);
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
            int getLineNumber = Integer.parseInt(fileReader.nextLine());
            out.println(getLineNumber);
            getFile(fManager, getLineNumber, writeFileName);
        } else if (selectQ3MenuNum == 2) {
            fileReader = new Scanner(System.in);
            int getLineNumber = fileReader.nextInt();
            getFile(fManager, getLineNumber, writeFileName);
        } else {
            out.println("프로그램을 종료합니다");
            System.exit(0);
        }

        sc.close();
    }
}
