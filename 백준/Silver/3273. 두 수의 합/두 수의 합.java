import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean[] boolArr = new boolean[2000001];
        for(int i = 0; i < n; i++) {
            boolArr[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= x; i++) {
            if(boolArr[i] && boolArr[x-i]) {
                answer++;
            }
        }

        System.out.println(answer/2);
    }
}