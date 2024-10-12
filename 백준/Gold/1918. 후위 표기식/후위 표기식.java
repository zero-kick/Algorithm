import java.io.*;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String infix = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char cur = infix.charAt(i);

            // 피연산자의 경우 바로 결과에 추가
            if (Character.isLetter(cur)) {
                sb.append(cur);
            }
            // 여는 괄호의 경우 스택에 push
            else if (cur == '(') {
                stk.push(cur);
            }
            // 닫는 괄호의 경우 여는 괄호가 나올때까지 스택에서 pop하여 결과에 추가
            else if (cur == ')') {
                while (!stk.isEmpty() && stk.peek() != '(')
                    sb.append(stk.pop());

                // 여는 괄호 스택에서 제거
                stk.pop();
            }
            // 연산자 처리
            else {
                while (!stk.isEmpty() && precedence(stk.peek()) >= precedence(cur))
                    sb.append(stk.pop());
                stk.push(cur);
            }
        }

        while (!stk.isEmpty())
            sb.append(stk.pop());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int precedence(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }
}