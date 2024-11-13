import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        int[] minCost = new int[n+1];

        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            p[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                minCost[i] = Math.min(minCost[i], minCost[i - j] + p[j]);

        bw.write(String.valueOf(minCost[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}
