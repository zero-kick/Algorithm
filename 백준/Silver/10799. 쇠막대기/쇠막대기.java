import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<Character> stk = new Stack<>();
        int answer = 0;
        char bf;

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (i == 0) {
                stk.push(cur);
                continue;
            }

            bf = str.charAt(i-1);
            if (cur == '(')
                stk.push(cur);
            else {
                if (bf == '(')
                    answer += stk.size()-1;
                else
                    answer++;
                stk.pop();
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}