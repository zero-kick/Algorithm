import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static int tc, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Integer> answer = new ArrayList<>();

        tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                map.put(kind, map.getOrDefault(kind, 0)+1);
            }

            int cnt = 1;
            for(int a : map.values()) {
                cnt = cnt * (a+1);
            }
            answer.add(cnt-1);
        }

        for(int a : answer)
            bw.write(String.valueOf(a) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}