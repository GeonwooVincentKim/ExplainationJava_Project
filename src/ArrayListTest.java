import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ArrayListTest {
    // private static int arrayIndexOfRange;

    public static int arrayIndexOfRange(Object o, int[] temp, int start, int end) {
        for (int i = 0; i < end; i++) {
            if (o.equals(temp[i])) {
                return i;
            }
        }

        return -1;
    }

    public static int arrayIndexOf(Object o) {
        return arrayIndexOfRange(o, null, 0, 0);
    }

    public static boolean isContain(Object o) {
        return arrayIndexOf(o) >= 0;
    }

    // public int indexOf(Object o){
    // return indexOfRange(o, 0, size);
    // }

    public static List<Integer> addToList(int[] temp, List<Integer> originalList) {
        for (int i = 0; i < temp.length; i++) {
            originalList.add(temp[i]);
            out.print(originalList.get(i) + " ");
        }

        return originalList;
    }

    public static int[] getRandomNumber(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (int) (Math.random() * (99 - 11 + 1)) + 11;
            out.print(temp[i] + " ");
        }

        return temp;
    }

    public static int listFrequency(List<Integer> randomList, int number) {
        int count = 0;

        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i) == number) {
                count++;
            }
        }

        return count;
    }

    public static List<Integer> getCountList(int[] temp, List<Integer> countList) {
        for (int i = 0; i < temp.length; i++) {
            // arrayIndexOfRange = ArrayListTest.arrayIndexOfRange(temp[i], temp, i,
            // temp.length);
            // countList.arrayIndexOf
            if (!countList.contains(temp[i])) {
                countList.add(temp[i]);
            }
        }

        return countList;
    }

    public static void main(String[] args) {
        int dataLength = 20;
        int printT = 5;
        int[] temp = new int[dataLength];
        String result = "";

        List<Integer> originalList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();

        temp = getRandomNumber(temp);
        out.println();

        originalList = addToList(temp, originalList);
        out.println();

        countList = getCountList(temp, countList);
        out.println(countList);

        result = getResult(printT, originalList, countList);
        out.println(result);
    }

    private static String getResult(int printT, List<Integer> originalList, List<Integer> countList) {
        String result;
        arrangementRandomList(originalList, countList);

        result = printResult(printT, originalList, countList);
        return result;
    }

    public static String printResult(int printT, List<Integer> originalList, List<Integer> countList) {
        String loopResult = "";

        for (int i = 0; i < originalList.size(); i++) {
            out.print(originalList.get(i) + " ");
        }

        out.println();

        for (int i = 0; i < printT; i++) {
            out.print("#" + (i + 1) + " " + countList.get(i));
            out.println(" (" + listFrequency(originalList, countList.get(i)) + ")");
        }

        return loopResult;
    }

    public static void arrangementRandomList(List<Integer> originalList, List<Integer> countList) {
        int currentValue = 0;
        int currentCount = 0;
        int nextValue = 0;
        int nextCount = 0;

        for (int i = 0; i < countList.size(); i++) {
            for (int j = i + 1; j < countList.size(); j++) {
                currentValue = countList.get(i);
                nextValue = countList.get(j);

                // out.print(currentValue + " ");
                // out.print(nextValue + " ");

                currentCount = listFrequency(originalList, currentValue);
                nextCount = listFrequency(originalList, nextValue);

                if (currentCount < nextCount) {
                    bubbleSort(countList, currentValue, nextValue, i, j);
                } else if (currentCount == nextCount && currentValue < nextValue) {
                    bubbleSort(countList, currentValue, nextValue, i, j);
                }
            }
            out.println();
        }
    }

    private static void bubbleSort(List<Integer> countList, int currentValue, int nextValue, int i, int j) {
        int tempValue;
        tempValue = currentValue;
        countList.set(i, nextValue);
        countList.set(j, tempValue);
    }

}
