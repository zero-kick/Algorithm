import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = getGcd(a, b);
        int lcm = getLcm(a, b, gcd);

        System.out.println(gcd);
        System.out.println(lcm);

        br.close();
    }

    public static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }

    public static int getLcm(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}