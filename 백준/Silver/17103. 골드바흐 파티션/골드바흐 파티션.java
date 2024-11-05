import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        /* 에라토스테네스의 채를 사용한 소수 판별 */
        int m = 1000000;
        boolean[] isPrime = new boolean[m+1];

        // 모든 수를 소수로 가정
        for (int i = 2; i <= m; i++)
            isPrime[i] = true;

        // 에라토스테네스의 채 알고리즘 적용
        for (int i = 2; i * i <= m; i++)
            if (isPrime[i])
                for (int j = i * i; j <= m; j += i)
                    isPrime[j] = false;

        // 골드바흐 파티션
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 2; i <= n/2; i++)
                if (isPrime[i] && isPrime[n-i]) cnt++;

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
