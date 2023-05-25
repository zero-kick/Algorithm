import java.io.*;
import java.util.Stack;

public class Main {
    public static int t;
    public static String str;
    public static Stack<Character> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++) {
            str = br.readLine();

            // VPS 판단
            bw.write(isVPS(str) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String isVPS(String str) {
        stk = new Stack<Character>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 스택이 비어있으면 현재 괄호 넣고 continue
            if(stk.isEmpty()) {
                stk.push(ch);
                continue;
            }

            // VPS인지 판단
            if(stk.peek() == '(') {
                if(ch == '(') {
                    stk.push(ch);
                } else {
                    stk.pop();
                }
            } else {
                stk.push(ch);
            }
        }

        // 문자열을 모두 순회한 후에도 스택에 원소가 남아있으면 VPS가 아니다.
        if(stk.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}