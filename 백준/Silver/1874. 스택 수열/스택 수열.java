import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<Integer>();
        int lastVal = 0;

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x > lastVal) {
                for(int j = lastVal+1; j <= x; j++) {
                    stk.push(j);
                    sb.append("+\n");
                }
                lastVal = x;
            }

            if(x == stk.peek()) {
                stk.pop();
                sb.append("-\n");
            }
        }

        if(!stk.isEmpty()) {
            bw.write("NO");
        } else {
            bw.write(String.valueOf(sb));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}