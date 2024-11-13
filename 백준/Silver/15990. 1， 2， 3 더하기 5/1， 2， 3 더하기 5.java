import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        final int mod = 1000000009;

        int maxN = 100000;
        long[][] dp = new long[maxN+1][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= maxN; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
        }

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            long sum = (dp[n][1] + dp[n][2] + dp[n][3]) % mod;
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
