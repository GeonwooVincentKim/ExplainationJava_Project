package Feature;

import static java.lang.System.out;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import FileManager.FileManager;

public class Q1 {
    public static Scanner fileReader(FileManager fManager, String fileName) {
        return fManager.fileReader(fileName);
    }

    public static void fileWriter(FileManager fManager, String fileName, String result) {
        fManager.fileWriter(fileName, result);
    }

    // randomRange 에서 getData 의 사용자 입력 값인 getValue 의 값을 가지고 와서 범위를 n1 ~ n2 만큼 지정한다.
    public static int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    // randomRange 의 범위 값, getData 의 getValue 값들을 각각 넘겨 받고, getValue 의 값만큼
    // randomArray 의 길이를 지정받은 후, randomRange 의 범위만큼 getRandomArray 함수의
    // getRandomArray 배열 안에 값을 순차적으로 지정해준다.
    public static int[] getRandomArray(int[] randomArray) {
        int getRandomArray[] = new int[randomArray.length];

        for (int i = 0; i < getRandomArray.length; i++) {
            getRandomArray[i] = randomRange(11, 99);
        }

        return getRandomArray;
    }

    // randomRange 로부터 값의 범위를 할당받은 randomArray Parameter 를 출력하기 위해 사용하는
    // printRandomNumber 함수
    public static String printRandomNumber(int[] randomArray) {
        String loopResult = "";

        for (int i = 0; i < randomArray.length; i++) {
            loopResult += randomArray[i] + " ";
        }

        return loopResult;
    }

    // randomRange 배열을 sumRandomNumber 의 매개변수로 값을 넘겨 주고, 그 넘겨 준 값의 합을
    // 구하기 위해 사용하는 sumRandomNumber 함수
    public static double sumRandomNumber(int[] randomArray) {
        double sum = 0;

        for (int i = 0; i < randomArray.length; i++) {
            sum += randomArray[i];
        }

        return sum;
    }

    // randomRange 배열을 averageRandomNumber 의 매개변수로 값을 넘겨 주고, 그 넘겨 준 값의 평균을
    // 구하기 위해 사용하는 averageRandomNumber 함수
    public static double averageRandomNumber(int[] randomArray) {
        double sum = sumRandomNumber(randomArray);
        double average = 0;
        average = sum / randomArray.length;

        return average;
    }

    // varianceTotal 함수는 randomRange 배열의 분산 값 (randomArray 의 값에서 average 의 크기 만큼 뺀
    // 값의 제곱) 을 구하기 위해 사용
    public static double varianceTotal(int[] randomArray) {
        double average = averageRandomNumber(randomArray);
        double varianceTotal = 0;

        for (int i = 0; i < randomArray.length; i++) {
            varianceTotal += (randomArray[i] - average) * (randomArray[i] - average);
        }

        return varianceTotal;
    }

    // randomRange 배열과 varianceTotal 값을 각각 varianceNumber() 함수의 매개변수와 varianceTotal
    // 변수로부터 넘겨 받고, varianceNumber 의 (분산) 값을 출력한다.
    public static double varianceNumber(int[] randomArray) {
        double varianceTotal = varianceTotal(randomArray);
        double variance = 0;

        variance = varianceTotal / randomArray.length;
        return variance;
    }

    // randomRange 배열과 variance 값을 각각 varianceNumber() 함수와 variance 변수로부터 넘겨받고,
    // standardDeviation (표준편차) 의 값을 출력한다.
    public static double standardDeviation(int[] randomArray) {
        double variance = varianceNumber(randomArray);
        double standardDeviation = 0;

        standardDeviation = Math.sqrt(variance);
        return standardDeviation;
    }

    // getData 가 평균, 분산, 표준편차 값들을 처리하기 전, fileReader 로부터 file 값을 불러들인 후,
    // 평균, 분산, 표준편차 값들을 처리한 후, 출력
    public static String getData(int getValue) {
        // 1. randomArray 를 생성한 후, getValue 의 크기만큼 randomArray 의 길이를 할당한다.
        int randomArray[] = new int[getValue];

        // 2. randomArray 의 sum 값 및 average 값, 그리고 분산 값을 구하기 전,
        // randomArray 와 average 의 차의 값을 저장할 total variance 값과 standardDeviation 값을
        // 미리 선언
        double sum = 0; // 합계
        double average = 0; // 평균
        double total = 0; // randomArray 와 average 의 차의 값을 저장할 변수
        double variance = 0; // 분산
        double standardDeviation = 0; // 표준 편차

        String result = ""; // 전체 내용을 파일에 담기 위한 변수
        String loopResult = ""; // randomArray 의 배열 값들을 담기 위한 변수

        // 3. randomArray 를 출력하기 전, getRandomArray 로부터 값을 넘겨 받은 후, randomArray 배열에 할당받은
        // 값들을 하나씩 담는다.
        randomArray = getRandomArray(randomArray);

        // 4. randomArray 의 내부 배열을 출력한다.
        loopResult = printRandomNumber(randomArray);
        out.print(loopResult);
        out.println();

        // 5. randomArray 의 sum 값 (합)을 출력한다.
        sum = sumRandomNumber(randomArray);
        out.print(sum);
        out.println();

        // 6. randomArray 의 average 를 출력한다.
        average = averageRandomNumber(randomArray);
        out.print(average);
        out.println();

        // 7. randomArray 의 분산 값 (randomArray 의 값에서 average 의 크기 만큼 뺀 값의 제곱) 를 출력한다.
        total = varianceTotal(randomArray);
        out.println(total);

        // 8. randomArray 의 분산을 출력한다.
        variance = varianceNumber(randomArray);
        out.println(variance);

        // 9. randomArray 의 표준편차를 출력한다.
        standardDeviation = standardDeviation(randomArray);
        out.println(standardDeviation);

        out.print("\n");
        out.printf("평균 : %.2f", average);
        out.print("\n");

        out.printf("분산 : %.2f", variance);
        out.print("\n");

        out.printf("표준 편차 : %.2f", standardDeviation);
        out.print("\n");

        result = loopResult + "\n" + "평균 : " + String.format("%.2f", average) + "\n" + "분산 : "
                + String.format("%.2f", variance) + "\n" + "표준 편차 : " + String.format("%.2f", standardDeviation);

        return result;
    }

    // fileWriter 에서 파일을 작성하기 전, getResult 에서 file 입력 값을 미리 받아 놓고, fileWriter 을 이용하여
    // 출력한다.
    public static void getResult(FileManager fManager, int loopResult, String fileName) {
        String getData = getData(loopResult);
        fileWriter(fManager, fileName, getData);
    }

    // Q1 파일 안에 있는 모든 함수들을
    public static void q1_main(int selectMenu) {
        File file = null;
        Scanner fileReader = null;
        FileWriter fileWriter = null;

        String fileReadName = "input.txt";
        String fileWriteName = "output.txt";
        FileManager fManager = new FileManager(file, fileReader, fileWriter);

        Scanner sc = new Scanner(System.in);
        out.println("선택하세요");
        out.println("1. 파일 입출력\n2. 직접 수량 입력 후 출력");

        int selectQ1MenuNum = sc.nextInt();

        if (selectQ1MenuNum == 1) {
            fileReader = fileReader(fManager, fileReadName);
            int getValue = Integer.parseInt(fileReader.nextLine());
            getResult(fManager, getValue, fileWriteName);
        } else if (selectQ1MenuNum == 2) {
            fileReader = new Scanner(System.in);
            int getValue = fileReader.nextInt();
            getResult(fManager, getValue, fileWriteName);
        } else {
            out.println("프로그램을 중단합니다");
            System.exit(0);
        }

        sc.close();
    }
}
