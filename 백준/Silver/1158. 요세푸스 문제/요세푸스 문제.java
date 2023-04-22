import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String answer = "<";

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<String> strList = new LinkedList<String>();

        for(int i = 0; i < n; i++) {
            strList.add(String.valueOf(i+1));
        }

        int idx = 0;
        while(strList.size() > 1) {
            idx = (idx + k - 1) % strList.size();
            answer += strList.remove(idx) + ", ";
        }
        answer += strList.remove(0) + ">";

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}