import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb;
    public static Deque<Character> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        dq = new ArrayDeque<>();
        sb = new StringBuilder();
        boolean isInsideTag = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '<') {
                appendReverseOrder(); // 태그 전에 있던 단어 뒤집기
                dq.offerLast(ch);  // '<' 태그 처리
                isInsideTag = true;
            } else if (ch == '>') {
                dq.offerLast(ch);  // '>' 태그 처리
                appendOrder();     // 태그 전체를 순서대로 추가
                isInsideTag = false;
            } else if (ch == ' ') {
                if (isInsideTag) {
                    dq.offerLast(ch); // 태그 내부의 공백은 그대로 추가
                } else {
                    appendReverseOrder(); // 공백 전에 있던 단어 뒤집기
                    sb.append(ch);        // 공백 추가
                }
            } else {
                dq.offerLast(ch); // 단어 및 태그 문자 처리
            }
        }

        appendReverseOrder(); // 남아있는 단어 뒤집기

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void appendOrder() {
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
    }

    public static void appendReverseOrder() {
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }
    }
}
