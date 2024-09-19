import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        // 0. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine().toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {
            String str = word.substring(i, i+1);
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        Iterator<Map .Entry<String, Integer>> it = map.entrySet().iterator();
        int max = Integer.MIN_VALUE;
        String answer = "";
        while(it.hasNext()) {
            Map.Entry<String, Integer> cur = it.next();
            if(cur.getValue() > max) {
                max = cur.getValue();
                answer = cur.getKey();
            } else if(cur.getValue() == max) {
                answer = "?";
            } else {
                continue;
            }
        }

        bw.write(answer.toUpperCase());
        bw.flush();
        bw.close();
        br.close();
    }
}