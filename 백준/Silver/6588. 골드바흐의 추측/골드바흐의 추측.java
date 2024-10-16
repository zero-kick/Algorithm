import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 소수 판별을 위한 배열 생성
        int limit = 1000000;
        boolean[] isPrime = generate(limit);

        int n;

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String answer = "Goldbach's conjecture is wrong.";
            for (int i = 3; i < n; i+=2) {
                if (isPrime[i] && isPrime[n-i]) {
                    answer = n + " = " + i + " + " + (n-i);
                    break;
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean[] generate(int limit) {
        boolean[] isPrime = new boolean[limit+1];

        for (int i = 2; i <= limit; i++)
            if (isPrime(i)) isPrime[i] = true;

        return isPrime;
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;

        return true;
    }
}