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

    /* 중복을 포함한 배열을 가지고 있는 getrandomList */
    // 0. randomRange 의 범위 값, getData 의 getValue 값들을 각각 넘겨 받고, getValue 의 값만큼
    // randomList 의 길이를 지정받은 후, randomRange 의 범위만큼 getrandomList 함수의
    // getrandomList 배열 안에 값을 순차적으로 지정해준다.
    public static int[] getTempData(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] = randomRange(11, 99);
            out.print(temp[i] + " ");
        }

        return temp;
    }

    // countList 의 length 만큼 값을 비교하면서,
    // 만약 countList 의 현재 index 의 수와 같은 숫자가 다른 index 에도 있다면
    // isContainsValue 를 true 를 return 하여 반복되는 숫자가 있다고 출력한다.
    public static boolean isContains(List<Integer> countList, int temp) {
        boolean isContainValue = false;

        for (int i = 0; i < countList.size(); i++) {
            if (countList.get(i) == temp) {
                isContainValue = true;
                return isContainValue;
            }
        }

        return isContainValue;
    }

    // 1. temp[] 배열에 추가한 데이터를 randomList ArrayList 에 데이터를 추가한다.
    public static List<Integer> getRandomList(int getValue) {
        List<Integer> randomList = new ArrayList<Integer>();
        out.println(randomList.toString());

        for (int i = 0; i < getValue; i++) {
            randomList.add(randomRange(11, 99));
            out.print(randomList.get(i) + " ");
        }

        return randomList;
    }

    // 2. getrandomList 의 randomList 배열을 넘겨받아서 loopResult 에 저장하여 랜덤 값을 출력한다.
    public static String printRandomList(List<Integer> randomList) {
        String loopResult = "";

        for (int i = 0; i < randomList.size(); i++) {
            loopResult += randomList.get(i) + " ";
        }

        return loopResult;
    }

    // 3. 배열 내 빈도수를 세는 getcountList 가 randomList 배열을 넘겨 받아 getcountList 에 저장한다.
    public static List<Integer> getCountList(List<Integer> randomList) {
        List<Integer> countList = new ArrayList<Integer>();
        out.print(countList);

        for (int i = 0; i < randomList.size(); i++) {
            if (!(isContains(countList, randomList.get(i)))) {
                countList.add(randomList.get(i));
            }
        }

        return countList;
    }

    // 4. countList 배열을 넘겨받은 후, countList 배열의 빈도수를 찾음과 동시에 특정 숫자의 빈도 수와
    // 전체 배열을 각각의 기준에 따라 정렬한다.
    public static List<Integer> getSortCountList(List<Integer> randomList, List<Integer> countList) {
        List<Integer> sortedCountList = new ArrayList<Integer>();
        int currentValue = 0; // 반복되는 수의 빈도 수를 저장하는 countList 의 현재 값
        int currentCount = 0; // countList 의 빈도 수
        int nextValue = 0; // countList 의 다음 값
        int nextCount = 0; // countList 의 다음 빈도 수

        // countList 의 이전 값과 countList 의 다음 값을 각각 currentValue(currentCount),
        // nextValue(nextCount) 에 저장한 후, currentCount 의 값과 nextCount 을 비교해서 정렬한다.
        for (int i = 0; i < countList.size(); i++) {
            for (int j = i + 1; j < countList.size(); j++) {
                currentValue = countList.get(i);
                nextValue = countList.get(j);

                // 현재 값의 빈도 수를 확인한다.
                currentCount = listFrequency(randomList, currentValue);

                // 다음 값의 빈도 수를 확인한다.
                nextCount = listFrequency(randomList, nextValue);

                // 현재 빈도 수의 값이 다음 빈도 수의 값보다 작을 때,
                // 중복 제거가 되지 않은 List 및 중복 제거가 된 List 의 값의
                // 위치를 서로 교환한다.
                if (currentCount < nextCount) {
                    // 중복된 List 인 randomList 따로, 중복된 값을 제거한 countList 따로,
                    // 각각의 List 에 값을 집어넣는다.
                    int tempValue = currentValue;
                    countList.set(i, nextValue);
                    countList.set(j, tempValue);

                    sortedCountList = countList;
                    // bubbleSort(countList, currentValue, nextValue, i, j);
                } else if (currentCount == nextCount && currentValue < nextValue) {
                    // 현재 빈도 수의 값과 다음 빈도 수의 값이 같고,
                    // 중복 제거가 되지 않은 List 의 값과 중복 제거된 List 의 값이 같을 때,
                    // 위치를 서로 교환한다.
                    // bubbleSort(countList, currentValue, nextValue, i, j);
                    int tempValue = currentValue;
                    countList.set(i, nextValue);
                    countList.set(j, tempValue);

                    // 빈도 수, 그리고 값을 내림차순에 따라 정렬한 countList 의 값을 sortedCountList 에 대입한다.
                    sortedCountList = countList;
                }
            }
        }

        return sortedCountList;
    }

    // 5. getrandomList 에서의 특정 숫자의 빈도수와 getcountList 에서의 특정 숫자의 빈도수를 확인하여
    // 각각 수가 출현할 때마다 count 의 수를 1씩 늘려준다.
    public static int listFrequency(List<Integer> randomList, int number) {
        int count = 0;

        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i) == number) {
                count++;
            }
        }
        return count;
    }

    // 6. countList 의 빈도수, 그리고 숫자의 크기의 값들을 가져와 내림차순으로 정렬한다.
    public static void bubbleSort(List<Integer> countList, int currentValue, int nextValue, int i, int j) {
        int tempValue;
        tempValue = currentValue;
        countList.set(i, nextValue);
        countList.set(j, tempValue);
    }

    // 8. 전체 배열들을 출력한다. (숫자의 빈도수를 출력하지 않고, 정렬한 목록만 출력한다)
    public static String printArray(int printT, List<Integer> sortCountList) {
        String getResult = "";
        // 랜덤 배열 최빈도 수 내림차순 출력
        for (int i = 0; i < printT; i++) {
            getResult += "#" + (i + 1) + " " + sortCountList.get(i) + "\n";
        }

        return getResult;
    }

    // 8. 전체 배열들을 출력한다. (숫자의 빈도수와 정렬한 목록 모두 함께 출력한다)
    public static String printArray(int printValue, List<Integer> sortCountArray, List<Integer> randomArray,
            List<Integer> countArray) {
        String getResult = "";

        for (int i = 0; i < printValue; i++) {
            getResult += "#" + (i + 1) + " " + sortCountArray.get(i) + " ("
                    + listFrequency(randomArray, countArray.get(i)) + ")" + "\n";
        }

        return getResult;
    }

    public static String getData(int getValue) {
        // 1. 숫자 N 을 입력받을 때, q2_main 에서 임의의 정수 T 의 크기만큼 입력을 받는다.
        // 2. randomList 를 선언하여 입력받은 숫자 N의 데이터들 (중복 되는 데이터 또한 포함) 모두 포함하여 저장한다.
        // 3. isContains 를 선언하여 randomList 내에 있는 데이터들과 모두 값을 비교한 후, 중복되는 값만 따로 저장한다.
        String result = ""; // 결과 값을 저장한다.
        int printValue = 5; // 출력할 개수를 정한다.

        String loopResult = ""; // RandomList 에서 뽑아온 값을 출력한다.
        // int countValue = 0; // 여러 번 나오는 수의 빈도 값을 저장한다.

        // 1. 사용자가 정한 입력받은(또는 파일로부터 받을) 데이터의 개수 만큼, 랜덤 수들을 randomList 리스트에 저장한다.
        // 랜덤 길이는 사용자가 입력한 배열의 길이로 결정된다.
        List<Integer> randomList = getRandomList(getValue); // 랜덤 길이 만큼 숫자 범위 11 ~ 99의 랜덤 수(난수)들을 넘겨 받는다.
        out.println(randomList);

        // 2. 현재 randomList 리스트 안에 저장되어 있는 random 값들을 출력하여 값을 확인한다.
        loopResult = printRandomList(randomList);
        out.println(loopResult);

        // 3. 중복 된 값들을 제거하여 겹치지 않는 수들을 countList 리스트에 저장한다.
        List<Integer> countList = getCountList(randomList);
        out.println(countList);

        // 4. 중복된 값들이 포함되어 있는 리스트(randomList) 와
        // 중복되지 않은 값들이 포함되어 있는 리스트(countList)를 가지고 온다.
        // 숫자들의 빈도 수, 그리고 전체 리스트를 먼저 빈도 수에 따라 정렬을 한 후, 빈도 수가 아닌 값들을 정렬하여
        // 큰 수를 먼저 출력하고, 작은 수를 나중에 출력하는 내림차순으로 출력한다.
        List<Integer> sortCountList = getSortCountList(randomList, countList);
        out.println();

        // 5. 중복된 값들이 포함된 randomList 의 빈도 수, 그리고 값들을 정렬한 결과를 출력한다.
        result = loopResult + "\n" + printArray(printValue, sortCountList, randomList, countList);
        out.print(result);
        return result;
    }

    // 9. fileWriter 에서 파일을 작성하기 전, getFile 에서 file 입력 값을 미리 받아 놓고, fileWriter 를
    // 이용하여 출력한다.
    public static void getFile(FileManager fManager, int loopResult, String fileName) {
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
            getFile(fManager, getValue, writeFileName);
        } else if (selectQ2MainNum == 2) {
            fileReader = new Scanner(System.in);
            int getValue = fileReader.nextInt();
            getFile(fManager, getValue, writeFileName);
        } else {
            out.println("프로그램을 종료합니다");
            System.exit(0);
        }

        sc.close();
    }
}
