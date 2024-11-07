import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] count = new int[N+1];
        count[1] = 0;

        for (int i = 2; i <= N; i++) {
            count[i] = count[i - 1] + 1;
            if (i % 2 == 0) count[i] = Math.min(count[i], count[i / 2] + 1);
            if (i % 3 == 0) count[i] = Math.min(count[i], count[i / 3] + 1);
        }

        bw.write(String.valueOf(count[N]));

        bw.flush();
        bw.close();
        br.close();
    }
}
