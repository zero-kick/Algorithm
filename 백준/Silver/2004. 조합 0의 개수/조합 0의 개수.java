import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long cnt2 = countFactors(n, 2) - countFactors(m, 2) - countFactors(n-m, 2);
        long cnt5 = countFactors(n, 5) - countFactors(m, 5) - countFactors(n-m, 5);

        bw.write(String.valueOf(Math.min(cnt2, cnt5)));
        bw.flush();
        bw.close();
        br.close();
    }

    // 특정 숫자에서 소인수 p의 개수를 구하는 함수
    public static long countFactors(long num, int p) {
        long count = 0;
        while (num >= p) {
            count += num / p;
            num /= p;
        }
        return count;
    }
}