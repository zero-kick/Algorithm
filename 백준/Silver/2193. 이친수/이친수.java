import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int maxN = 90;
        long[][] dp = new long[maxN+1][2];

        dp[1][1] = 1;

        for (int i = 2; i <= maxN; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        bw.write(String.valueOf(dp[n][0] + dp[n][1]));

        bw.flush();
        bw.close();
        br.close();
    }
}
