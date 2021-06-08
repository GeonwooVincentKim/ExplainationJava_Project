package Page;

import static java.lang.System.out;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
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
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    /*  */
    // getModeArray 에서 modeArray 를 생성하기 전, getData 에서 randomArray 배열의 크기를 사용자 지정 배열
    // 길이 값인 getValue 만큼 getModeArray 를 할당받는다.
    public static int[] modeArray(int[] randomArray) {
        int[] modeArray = new int[randomArray.length];

        for (int i = 0; i < randomArray.length; i++) {
            modeArray[i] = randomArray[i];
        }

        return modeArray;
    }

    /* 중복을 포함한 배열을 가지고 있는 getRandomArray */
    // randomRange 의 범위 값, getData 의 getValue 값들을 각각 넘겨 받고, getValue 의 값만큼
    // randomArray 의 길이를 지정받은 후, randomRange 의 범위만큼 getRandomArray 함수의
    // getRandomArray 배열 안에 값을 순차적으로 지정해준다.
    public static List<Integer> getRandomArray(List<Integer> randomArray) {
        List<Integer> getRandomArray = new ArrayList<>(randomArray.size());

        for (int i = 0; i < getRandomArray.size(); i++) {
            // getRandomArray.get(i) = (randomRange(11, 99);
        }
        return randomArray;
    }

    // 1. randomRange 의 범위 값, getData 의 getValue 값들을 각각 넘겨 받고, getValue 의 값만큼
    // randomArray 의 길이를 지정받은 후, randomRange 의 범위만큼 getRandomArray 함수의
    // getRandomArray 배열 안에 값을 순차적으로 지정해준다.
    public static int[] getRandomArray(int[] randomArray) {
        int getRandomArray[] = new int[randomArray.length];

        for (int i = 0; i < getRandomArray.length; i++) {
            getRandomArray[i] = randomRange(11, 99);
            out.print(getRandomArray[i] + " | ");
        }

        return getRandomArray;
    }

    public static List<Integer> getCountArray(List<Integer> countArray) {
        List<Integer> getCountArray = new ArrayList<>(countArray.size());

        return getCountArray;
    }

    // 3. 배열 내 빈도수를 세는 getCountArray 가 randomArray 배열을 넘겨 받아 getCountArray 에 저장한다.
    public static int[] getCountArray(int[] countArray) {
        // int[] getRandomArray = getRandomArray(countArray);
        int[] o = new int[countArray.length];
        for (int i = 0; i < countArray.length; i++) {
            o[i] = Integer.valueOf(countArray[i]);

            // for (int j = 0; j < i; j++) {
            // if (getRandomArray[i] == randomArray[i]) {
            // i--;
            // break;
            // }
            // }
            // getRandomArray[i] = randomArray[i];
            // for (int j = i + 1; j < randomArray.length; j++) {
            // if (randomArray[i] == randomArray[j]) {
            // getRandomArray[i]++;
            // }
            // }
            out.print(countArray[i] + " < ");
            out.print(countArray[i] + " > ");
        }

        for (int i = 0; i < countArray.length; i++) {
            for (int j = i + 1; j < countArray.length; j++) {
                if (o[i] == o[j]) {
                    o[j] = -1;
                }
            }
        }

        for (int i = 0; i < countArray.length; i++) {
            if (o[i] != -1) {
                out.print(o[i] + " ");
            }
        }

        return countArray;
    }

    // 2. getRandomArray 의 randomArray 배열을 넘겨받아서 loopResult 에 저장하여 랜덤 값을 출력한다.
    public static String printRandomArray(int[] randomArray) {
        String loopResult = "";

        for (int i = 0; i < randomArray.length; i++) {
            loopResult += randomArray[i] + " ";
        }

        return loopResult;
    }

    public static String getData(int getValue) {
        // 1. 숫자 N 을 입력받을 때, q2_main 에서 임의의 정수 T 의 크기만큼 입력을 받는다.
        // 2. randomArray 를 선언하여 입력받은 숫자 N의 데이터들 (중복 되는 데이터 또한 포함) 모두 포함하여 저장한다.
        // 3. modeArray 를 선언하여 randomArray 내에 있는 데이터들과 모두 값을 비교한 후, 중복되는 값만 따로 저장한다.
        String result = "";
        String loopResult = ""; // printRandomArray 의 randomArray 의 내부 배열 값을 출력
        int randomArray[] = new int[getValue]; // random 값들을 받는 int 배열
        int countArray[] = new int[getValue]; // randomArray 의 중복된 값들을 제거한 후, 중복되지 않는 값들 만을 저장하는 배열

        randomArray = getRandomArray(randomArray);
        out.println();

        loopResult = printRandomArray(randomArray);
        out.println(loopResult);

        countArray = getCountArray(randomArray);
        out.println(countArray);

        result = loopResult + "\n";

        return result;
    }

    // fileWriter 에서 파일을 작성하기 전, getResult 에서 file 입력 값을 미리 받아 놓고, fileWriter 를 이용하여
    // 출력한다.
    public static void getResult(FileManager fManager, int loopResult, String fileName) {
        String getResult = getData(loopResult);
        writeFile(fManager, fileName, getResult);
    }

    public static void q2_main(int selectNum) {
        File file = null;
        Scanner fileReader = null;
        FileWriter fileWriter = null;
        FileManager fManager = new FileManager(file, fileReader, fileWriter);

        String readFileName = "input2.txt";
        String writeFileName = "output2.txt";

        Scanner sc = new Scanner(System.in);
        out.println("선택하세요");
        out.println("1. 파일 입출력\n2. 직접 수량 입력 후 출력");

        int selectQ2MainNum = sc.nextInt();

        if (selectQ2MainNum == 1) {
            fileReader = fileReader(fManager, readFileName);
            int getValue = Integer.parseInt(fileReader.nextLine());
            getResult(fManager, getValue, writeFileName);
        } else if (selectQ2MainNum == 2) {
            fileReader = new Scanner(System.in);
            int getValue = fileReader.nextInt();
            getResult(fManager, getValue, writeFileName);
        } else {
            out.println("프로그램을 종료합니다");
            System.exit(0);
        }

        sc.close();
    }
}
