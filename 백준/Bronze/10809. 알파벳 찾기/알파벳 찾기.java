import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int[] arr = new int[26];

        // 배열 값 -1로 초기화
        Arrays.fill(arr, -1);

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            // 해당 문자가 처음 등장했을 때만 기록
            if (arr[ch -'a'] == -1)
                arr[ch - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int j : arr) sb.append(j).append(" ");

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}