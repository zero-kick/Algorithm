import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[i])
                answer[stk.pop()] = arr[i];

            stk.push(i);
        }

        while (!stk.isEmpty())
            answer[stk.pop()] = -1;

        for (int a : answer)
            bw.write(a + " ");

        bw.flush();
        bw.close();
        br.close();
    }

}
