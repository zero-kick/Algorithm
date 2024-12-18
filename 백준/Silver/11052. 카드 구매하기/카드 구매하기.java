import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        int[] maxPay = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            p[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                maxPay[i] = Math.max(maxPay[i], maxPay[i - j] + p[j]);

        bw.write(String.valueOf(maxPay[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}
