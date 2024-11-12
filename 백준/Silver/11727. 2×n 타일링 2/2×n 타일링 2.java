import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) bw.write("1");
        else {
            int[] count = new int[n+1];
            count[1] = 1;
            count[2] = 3;

            for (int i = 3; i <= n; i++)
                count[i] = (count[i-1] + count[i-2] * 2) % 10007;

            bw.write(String.valueOf(count[n]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
