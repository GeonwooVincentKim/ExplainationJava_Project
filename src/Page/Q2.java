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

    /* 중복을 포함한 배열을 가지고 있는 getRandomArray */
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

    // countArray 의 length 만큼 값을 비교하면서,
    // 만약 countArray 의 현재 index 의 수와 같은 숫자가 다른 index 에도 있다면
    // isContainsValue 를 true 를 return 하여 반복되는 숫자가 있다고 출력한다.
    public static boolean isContains(int[] countArray, int temp) {
        boolean isContainsValue = false;

        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == temp) {
                isContainsValue = true;
                return isContainsValue;
            }
        }

        return isContainsValue;
    }

    // 3. 배열 내 빈도수를 세는 getCountArray 가 randomArray 배열을 넘겨 받아 getCountArray 에 저장한다.
    public static int[] getCountArray(int[] temp) {
        int[] countArray = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            if (!isContains(countArray, temp[i])) {
                countArray[i] = Integer.valueOf(temp[i]);
                out.print(countArray[i] + " ");
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

    // 4. countArray 배열을 넘겨받은 후, countArray 배열의 빈도수를 찾음과 동시에 특정 숫자의 빈도 수와
    // 전체 배열을 각각의 기준에 따라 정렬한다.
    public static int[] sortCountArray(int[] randomArray, int[] countArray) {
        int currentValue = 0; // 현재 값
        int currentCount = 0; // 현재 값의 빈도 수
        int nextValue = 0; // 다음 값
        int nextCount = 0; // 다음 값의 빈도 수

        out.println();

        for (int i = 0; i < countArray.length; i++) {
            for (int j = i + 1; j < countArray.length; j++) {
                currentValue = countArray[i];
                nextValue = countArray[j];

                currentCount = arrayFrequency(randomArray, currentValue);
                nextCount = arrayFrequency(randomArray, nextValue);

                // int tempValue = 0;
                if (currentCount < nextCount) {
                    bubbleSort(randomArray, i, j);
                    bubbleSort(countArray, i, j);
                } else if (currentCount == nextCount && currentValue < nextValue) {
                    bubbleSort(randomArray, i, j);
                    bubbleSort(countArray, i, j);
                }
            }
        }

        return countArray;
    }

    // 5. getRandomArray 에서의 특정 숫자의 빈도수와 getCountArray 에서의 특정 숫자의 빈도수를 확인하여
    // 각각 수가 출현할 때마다 count 의 수를 1씩 늘려준다.
    public static int arrayFrequency(int[] randomArray, int number) {
        int count = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == number) {
                count++;
            }
        }

        return count;
    }

    // 6. countArray 의 빈도수, 그리고 숫자의 크기의 값들을 가져와 내림차순으로 정렬한다.
    public static void bubbleSort(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 6. countArray 의 빈도수, 그리고 숫자의 크기의 값들을 가져와 내림차순으로 정렬한다.
    public static void bubbleArraySort(int[] getArray, int currentValue, int nextValue) {
        int tempValue = getArray[currentValue];
        getArray[currentValue] = getArray[nextValue];
        getArray[nextValue] = tempValue;
    }

    // 7. sortCountArray 의 Array 값들을 불러온다.
    public static String getResult(int printT, int[] randomArray, int[] countArray) {
        String result;
        sortCountArray(randomArray, countArray);

        result = printArray(randomArray, countArray, printT) + " ";
        return result;
    }

    // 8. 전체 배열들을 출력한디.
    public static String printArray(int[] randomArray, int[] countArray, int printCount) {
        String setResult = "";

        // 랜덤 배열 목록을 출력한다.
        for (int i = 0; i < randomArray.length; i++) {
            out.print(randomArray[i] + " ");
            setResult += randomArray[i] + " ";
        }

        out.println();

        // 빈도 값을 count 하는 배열의 목록들을 출력한다.
        for (int i = 0; i < countArray.length; i++) {
            out.print(countArray[i] + " ");
        }

        out.println();

        // 랜덤 배열 최빈도 수 내림차순 출력
        for (int i = 0; i < printCount; i++) {
            out.print("#" + (i + 1) + " " + countArray[i]);
            out.println(" (" + arrayFrequency(randomArray, countArray[i]) + ")");
            setResult += "#" + (i + 1) + " " + countArray[i] + "\n";
        }

        return setResult;
    }

    public static String getData(int getValue) {
        int printT = 5;
        // 1. 숫자 N 을 입력받을 때, q2_main 에서 임의의 정수 T 의 크기만큼 입력을 받는다.
        // 2. randomArray 를 선언하여 입력받은 숫자 N의 데이터들 (중복 되는 데이터 또한 포함) 모두 포함하여 저장한다.
        // 3. isContains 를 선언하여 randomArray 내에 있는 데이터들과 모두 값을 비교한 후, 중복되는 값만 따로 저장한다.
        String result = "";
        String loopResult = ""; // printRandomArray 의 randomArray 의 내부 배열 값을 출력
        int randomArray[] = new int[getValue]; // random 값들을 받는 int 배열
        int countArray[] = new int[getValue]; // randomArray 의 중복된 값들을 제거한 후, 중복되지 않는 값들 만을 저장하는 배열

        randomArray = getRandomArray(randomArray);
        out.println();

        loopResult = printRandomArray(randomArray);
        out.println(loopResult);

        countArray = getCountArray(randomArray);
        out.println();

        result = getResult(printT, randomArray, countArray);
        return result;
    }

    // 9. fileWriter 에서 파일을 작성하기 전, getResult 에서 file 입력 값을 미리 받아 놓고, fileWriter 를
    // 이용하여 출력한다.
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
