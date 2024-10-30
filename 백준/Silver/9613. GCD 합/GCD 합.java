import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int n;
        long sum;

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            sum = 0;

            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    sum += gcd(arr[i], arr[j]);
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}