import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();

        int num = 0;
        int i = 0;
        while (i < n) {
            if (num > n)
                break;

            if (stk.isEmpty()) {
                stk.push(++num);
                sb.append("+\n");
            }

            if (arr[i] == stk.peek()) {
                stk.pop();
                sb.append("-\n");
                i++;
            } else {
                stk.push(++num);
                sb.append("+\n");
            }
        }

        if (!stk.isEmpty())
            bw.write("NO");
        else
            bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}