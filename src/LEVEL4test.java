import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class LEVEL4test {
    public static void main(String[] args) throws IOException {
        // Scanner scan = new Scanner(System.in);
        // int test = scan.nextInt();
        // for (int test_case = 1; test_case <= test; test_case++) { // test case 만큼
        // Loop
        // String str = scan.next();
        // for (int i = 1; i <= 10; i++) { // Input data 배열에 삽입
        // String pre = str.substring(0, i); // 앞에서 두개 추출
        // String next = str.substring(i, i + i);
        // if (pre.equals(next)) {
        // System.out.println("#" + test_case + " " + pre.length());
        // break;
        // }
        // if (i == 1) { // 마디가 한 개인 경우 예외처리
        // pre = str.substring(0, 1);
        // next = str.substring(1, 2);
        // if (pre.equals(next)) {
        // System.out.println("#" + test_case + " " + "1");
        // break;
        // }
        // }
        // }
        // }
        // scan.close();

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try {
        // // 테스트 개수
        // int N = Integer.parseInt(br.readLine());
        // for (int i = 1; i <= N; i++) {
        // String str = br.readLine();
        // StringBuilder sb = new StringBuilder();
        // int count = 1;
        // // 초기값 설정
        // sb.append(str.charAt(0));
        // // sb에 담긴 글자와 str에서 sb에 담긴 글자 이후~sb길이만큼의 문자를 잘라 비교함
        // // 비교해서 같다면 패턴의 구간을 확인한 경우
        // while (!sb.toString().equals(str.substring(sb.length(), sb.length() * 2))) {
        // sb.append(str.charAt(count));
        // count++;
        // }
        // System.out.println("#" + i + " " + sb.length());
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // int t = Integer.parseInt(br.readLine());

        // for (int i = 1; i <= t; i++) {
        // String s = br.readLine();
        // int ans = 1;
        // for (int j = 0; j * 2 < 30; j++) {
        // String p = s.substring(0, j);
        // String q = s.substring(j, j * 2);

        // if (p.length() > 1 && p.equals(q)) {
        // ans = j;
        // break;
        // }
        // }

        // bw.write("#" + i + " " + ans + "\n");
        // }

        // bw.flush();
        // bw.close();

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int len = 0;
            boolean alpha[] = new boolean[125];
            String pattern = "";

            String input = sc.next();
            for (int i = 0; i < input.length(); i++) {
                // first = input.substring(0, i);
                // last = input.substring(i, i * 2);

                if (!alpha[(int) input.charAt(i)]) {
                    alpha[(int) input.charAt(i)] = true;
                    pattern += input.charAt(i);
                    out.println(pattern);
                } else {
                    String competition = "";
                    len = pattern.length();

                    // first = input.substring(0, i);
                    // last = input.substring(i, i * 2);
                    // if (first.equals(last)) {
                    // result += "#" + t + " " + len;
                    // System.out.println(result);
                    // }
                    for (int k = len; k < len * 2; k++) {
                        competition += input.charAt(k);
                        // out.println(competition);
                    }
                    if (pattern.equals(competition))
                        break;
                    else {
                        pattern += input.charAt(i);
                        out.println(pattern);
                    }
                }
            }
            System.out.println("#" + t + " " + len);
        }
        sc.close();
    }
}
