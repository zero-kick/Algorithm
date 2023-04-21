import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            answer += Integer.parseInt(strArr[i]) == v ? 1 : 0;
        }

        System.out.println(answer);
    }
}