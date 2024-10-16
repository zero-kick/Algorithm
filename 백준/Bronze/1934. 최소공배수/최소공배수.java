import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int a, b;

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int gcd = getGcd(a, b);
            int lcm = getLcm(a, b, gcd);

            bw.write(lcm + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b,  a%b);
    }

    public static int getLcm(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}