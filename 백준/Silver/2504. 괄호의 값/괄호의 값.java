import java.io.*;
import java.util.Stack;

public class Main {
    public static String str;
    public static int answer;
    public static Stack<Character> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        bw.write(String.valueOf(calValue(str)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calValue(String str) {
        stk = new Stack<Character>();
        char ch;
        int tmp = 1;
        answer = 0;

        for(int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            if(ch == '(') {
                stk.push(ch);
                tmp *= 2;
            } else if(ch == '[') {
                stk.push(ch);
                tmp *= 3;
            } else if(ch == ')') {
                if(stk.isEmpty() || stk.peek() != '(') {
                    return 0;
                } else if (str.charAt(i-1) == '(') {
                    answer += tmp;
                }
                stk.pop();
                tmp /= 2;
            } else if(ch == ']') {
                if(stk.isEmpty() || stk.peek() != '[') {
                    return 0;
                } else if(str.charAt(i-1) == '[') {
                    answer += tmp;
                }
                stk.pop();
                tmp /= 3;
            }
        }

        if(!stk.isEmpty()) {
            return 0;
        }

        return answer;
    }
}
