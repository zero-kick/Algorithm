import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int remainder;

        while (n != 0) {
            remainder = n % b;

            if (remainder > 9)
                sb.append((char)('A'-10+remainder));
            else
                sb.append(remainder);

            n = n / b;
        }

        bw.write(sb.reverse().toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
