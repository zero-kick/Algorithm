import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[201];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())+100]++;
        }

        int v = Integer.parseInt(br.readLine());

        answer = arr[v+100];

        System.out.println(answer);
    }
}