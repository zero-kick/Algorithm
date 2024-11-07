import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int digits = Integer.parseInt(br.readLine());

        int[] arrA = new int[digits];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < digits; i++)
            arrA[i] = Integer.parseInt(st.nextToken());

        // A진법 > 10진법 변환
        long decimal = 0;
        for (int i = 0; i < digits; i++)
            decimal = decimal * A + arrA[i];

        // 10진법 > B진법
        Stack<Long> stk = new Stack<>();
        while (decimal > 0) {
            stk.push(decimal % B);
            decimal = decimal / B;
        }

        while (!stk.isEmpty())
            bw.write(stk.pop() + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
