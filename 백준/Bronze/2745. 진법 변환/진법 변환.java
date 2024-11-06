import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        long answer = 0;

        // Math.pow를 사용한 진법 변환
//        for (int i = n.length()-1; i >= 0; i--) {
//            char ch = n.charAt(n.length()-1-i);
//            if (Character.isDigit(ch)) answer += Character.getNumericValue(ch) * Math.pow(b, i);
//            else answer += (ch - 'A' + 10) * Math.pow(b, i);
//        }

        // 곱셈을 사용한 진법 변환
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            int value;

            if (Character.isDigit(ch)) value = ch - '0';
            else value = ch - 'A' + 10;

            answer = answer * b + value;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
