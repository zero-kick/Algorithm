import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();

        HashMap<Character, Double> map = new HashMap<>();
        for (int i = 0; i < N; i++)
            map.put((char)('A'+i), Double.parseDouble(br.readLine()));

        Stack<Double> stk = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char cur = postfix.charAt(i);

            if (Character.isLetter(cur)) {
                // 문자가 알파벳이면 스택에 대응되는 값을 push
                stk.push(map.get(cur));
            } else {
                // 문자가 연산자이면 스택에서 두 값을 꺼내어 계산 후 다시 push
                double b = stk.pop();
                double a = stk.pop();
                double result = 0;

                switch (cur) {
                    case '+' :
                        result = a + b;
                        break;
                    case '-' :
                        result = a - b;
                        break;
                    case '*' :
                        result = a * b;
                        break;
                    case '/' :
                        result = a / b;
                        break;
                }

                stk.push(result);
            }
        }

        // 최종 결과는 스택에 남아있으므로 pop
        bw.write(String.format("%.2f", stk.pop()));
        bw.flush();
        bw.close();
        br.close();
    }
}