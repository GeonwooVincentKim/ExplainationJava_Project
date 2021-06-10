import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static int arrayFrequency(List<Integer> randomList, int number) {
        int count = 0;

        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i) == number) {
                count++;
            }
        }
        return count;
    }

    public static boolean isContains(List<Integer> countArray, int temp) {
        boolean isContainValue = false;

        for (int i = 0; i < countArray.size(); i++) {
            if (countArray.get(i) == temp) {
                isContainValue = true;
                return isContainValue;
            }
        }

        return isContainValue;
    }

    public boolean contains(CharSequence sequence) {
        return indexOf(sequence.toString()) > -1;
    }

    private int indexOf(String string) {
        return 0;
    }

    public static String printArray(List<Integer> randArr, List<Integer> cntArr, int printCnt) {
        String setResult = "";

        // 랜덤 배열 출력
        for (int i = 0; i < randArr.size(); i++) {
            out.print(randArr.get(i) + " ");
            setResult += randArr.get(i) + " ";
        }
        out.println();

        for (int i = 0; i < cntArr.size(); i++) {
            out.print(cntArr.get(i) + " - ");
        }

        out.println();
        setResult += "\n";

        // 랜덤 배열 최빈도 수 내림차순 출력
        for (int i = 0; i < printCnt; i++) {
            out.print("#" + (i + 1) + " " + cntArr.get(i));
            out.println(" (" + arrayFrequency(randArr, cntArr.get(i)) + ")");
            setResult += "#" + (i + 1) + " " + cntArr.get(i) + "\n";
        }

        return setResult;
    }

    // getRandomArray 의 크기만큼 할당받은 randomList 의 값들은 main 으로부터 값을 넘겨받는다.
    public static int[] getRandomList(int[] getRandomArray) {
        int getRandomList[] = new int[getRandomArray.length];

        for (int i = 0; i < getRandomList.length; i++) {
            getRandomList[i] = (int) (Math.random() * (99 - 11 + 1)) + 11;
        }

        return getRandomList;
    }

    // getRandomList 안에 있는 데이터들을 모두 List<Integer> 형의 randomList 에 삽입한다.
    public static List<Integer> addRandomList(int[] getRandomArray) {
        List<Integer> randomList = new ArrayList<Integer>();

        for (int i = 0; i < getRandomArray.length; i++) {
            randomList.add(getRandomArray[i]);
            out.print(randomList.get(i) + " ");
        }

        return randomList;
    }

    // countList 안에

    public static void main(String[] args) throws Exception {
        String result = ""; // 결과 값을 저장한다.
        int randomValue = 20; // 랜덤 길이는 20으로 설정한다.
        int printValue = 5; // 출력할 개수를 정한다.
        // int countValue = 0; // 여러 번 나오는 수의 빈도 값을 저장한다.

        // int temp = 0;
        int[] temp = new int[randomValue]; // 랜덤 길이 만큼 숫자 범위 11 ~ 99의 랜덤 수(난수)들을 넘겨 받는다.
        List<Integer> randomList = new ArrayList<Integer>(); // temp 배열의 값을 저장한다.
        List<Integer> countList = new ArrayList<Integer>(); // 중복을 제거한 값들을 countArray 에 저장한다.

        for (int i = 0; i < randomValue; i++) {
            temp[i] = (int) (Math.random() * (99 - 11 + 1)) + 11;
            out.print(temp[i] + " ");
        }

        out.println();

        // randomList 에 random 수들로 할당받은 temp 값을 넘겨 받아 randomList 에 저장한다.
        // for (int i = 0; i < randomValue; i++) {
        for (int i = 0; i < temp.length; i++) {
            randomList.add(temp[i]);
            out.print(randomList.get(i) + " ");
        }

        out.println();

        // ArrayList 로 여러 번 나오는 수의 빈도 값 탐색 및 겹치는 수 확인
        // i 와 j 두 개를 만들어놓고, 각각 randomList 라는 ArrayList 에서 겹치는 수 확인 후,
        // count 값에 저장한다.
        for (int i = 0; i < randomList.size(); i++) {
            // Original Code
            // if (!countList.contains(temp[i])) {
            // countList.add(temp[i]);
            // }
            if (!(isContains(countList, temp[i]))) {
                countList.add(temp[i]);
            }
        }

        out.println();

        int currentValue = 0; // 반복되는 수의 빈도 수를 저장하는 countList 의 현재 값
        int currentCount = 0; // countList 의 빈도 수
        int nextValue = 0; // countList 의 다음 값
        int nextCount = 0; // countList 의 다음 빈도 수

        // countList 의 이전 값과 countList 의 다음 값을 각각 currentValue(currentCount),
        // nextValue(nextCount) 에 저장한 후, currentCount 의 값과 nextCount 을 비교해서 정렬한다.
        // for (int i = 0; i < countList.size(); i++) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < countList.size(); j++) {
                // out.print(temp[j] + " ");
                currentValue = countList.get(i);
                nextValue = countList.get(j);

                currentCount = arrayFrequency(randomList, currentValue);
                nextCount = arrayFrequency(randomList, nextValue);

                if (currentCount < nextCount) {
                    bubbleSort(countList, currentValue, nextValue, i, j);
                } else if (currentCount == nextCount && currentValue < nextValue) {
                    bubbleSort(countList, currentValue, nextValue, i, j);
                }
            }
        }

        // randomList 출력
        out.println();

        // countList 출력
        result = printArray(randomList, countList, printValue);
        out.println(result);
    }

    private static void bubbleSort(List<Integer> countList, int currentValue, int nextValue, int i, int j) {
        int tempValue;
        tempValue = currentValue;
        countList.set(i, nextValue);
        countList.set(j, tempValue);
    }
}
