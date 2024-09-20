import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        List<Integer> answerList = new ArrayList<>();

        answerList.add( (A + B) % C );
        answerList.add( ( ( A % C ) + ( B % C ) ) % C );
        answerList.add( ( A * B ) % C );
        answerList.add( ( ( A % C ) * ( B % C) ) % C );

        for(int answer : answerList)
            bw.write(String.valueOf(answer) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}