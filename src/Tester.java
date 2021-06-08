import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        String[] arr = str.split(", ");
        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        int mode = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    count++;
                }
            }
            if (count >= mode && count > 1) {
                mode = count;
                list2.add(list.get(i));
                list2.add(mode);
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(i) == list.get(k) && i != k) {
                        list.remove(k);
                        k--;
                    }
                }
            }
        }
        if (list2.size() > 1) {
            int 빈도 = 0;
            for (int i = 1; i < list2.size(); i = i + 2) {
                if (list2.get(i) >= 빈도) {
                    빈도 = list2.get(i);
                }
            }
            for (int i = 1; i < list2.size(); i++) {
                if (list2.get(i) == 빈도) {
                    System.out.print(list2.get(i - 1) + " ");
                }
            }
        }

        else if (list2.size() == 0) {
            System.out.println("없다");
        }

        scan.close();
    }

}
