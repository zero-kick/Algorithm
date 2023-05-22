import java.io.*;
import java.util.Stack;

public class Main {
    public static int n, answer;
    public static String str;
    public static Stack<Character> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        answer = 0;

        for(int t = 0; t < n; t++) {
            str = br.readLine();
            stk = new Stack<Character>();

            for(int i = 0; i < str.length(); i++) {
                // 스택이 비어있는 경우 글자 push
                if(stk.isEmpty()) {
                    stk.push(str.charAt(i));
                    continue;
                }

                // 스택의 top과 현재 글자가 같은 경우 선끼리 교차하지 않는 짝을 이룰 수 있으므로 스택에서 pop
                if(stk.peek() == str.charAt(i)) {
                    stk.pop();
                // 스택의 top과 현재 글자가 다른 경우 스택에 push
                } else {
                    stk.push(str.charAt(i));
                }
            }

            // 단어의 모든 글자를 순회하였는데, 스택이 비어있는 경우 모든 글자의 선이 교차하지 않고 짝을 이루는 것이므로 좋은 단어
            if(stk.isEmpty()) {
               answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}