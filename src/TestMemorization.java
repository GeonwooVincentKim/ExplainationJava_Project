import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static java.lang.System.out;

public class TestMemorization {

    public static int randNum(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1)) + n1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static String getResult(Scanner readFile) {
        int N = Integer.parseInt(readFile.nextLine());
        int NRcnt = 0; // Non-redundant count

        int[] nums = new int[N];
        int[] freqs = new int[100];

        // for (int i = 0; i < N; i++) {
        // int num = randNum(11, 99);
        // nums[i] = num;
        // if (freqs[num] == 0)
        // NRcnt++;
        // freqs[num]++;
        // }

        for (int i = 0; i < N; i++) {
            nums[i] = randNum(11, 99);
            if (freqs[nums[i]] == 0)
                NRcnt++;

            freqs[nums[i]]++;
            // out.println(freqs[nums[i]]);
            out.print(nums[i] + " ");
        }

        out.println();

        int idx = 0;
        int[] pair_freqs = new int[NRcnt];
        int[] pair_nums = new int[NRcnt];
        for (int num = 11; num <= 99; num++) {
            if (freqs[num] > 0) {
                pair_freqs[idx] = freqs[num];
                pair_nums[idx] = num;
                out.print(pair_freqs[idx] + " ");
                idx++;
            }

        }

        out.println();

        // Sorting
        for (int i = NRcnt - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (pair_freqs[j] < pair_freqs[i]) {
                    swap(pair_freqs, i, j);
                    swap(pair_nums, i, j);
                } else if (pair_freqs[j] == pair_freqs[i] && pair_nums[j] < pair_nums[i]) {
                    swap(pair_freqs, i, j);
                    swap(pair_nums, i, j);
                }
            }
        }

        String result = "";

        for (int i = 0; i < N; i++) {
            result += nums[i] + " ";
        }
        result += "\n";
        for (int i = 0; i < NRcnt && i < 5; i++) {
            result += "#" + (i + 1) + " " + pair_nums[i] + "\n";
        }
        System.out.print(result);

        return result;
    }

    public static Scanner readFile() {
        Scanner fileReader = null;
        File file = new File("testdata.txt");

        try {
            fileReader = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileReader;
    }

    public static void writeFile(String getResult) {
        try {
            FileWriter fileWriter = new FileWriter("test_result.txt");
            fileWriter.write(getResult);
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner readFile = readFile();
        String getResult = getResult(readFile);
        writeFile(getResult);
    }
}