import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String ab = st.nextToken() + st.nextToken();
        String cd = st.nextToken() + st.nextToken();

        long answer = Long.parseLong(ab) + Long.parseLong(cd);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}