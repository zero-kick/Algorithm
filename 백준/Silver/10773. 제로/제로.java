import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<Integer>();

        for(int i = 0; i < k; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                stk.pop();
            } else {
                stk.push(x);
            }
        }

        br.close();

        int answer = 0;

        while(!stk.isEmpty()) {
            answer += stk.pop();
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}