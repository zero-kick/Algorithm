import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int arr[] = new int[9];

        str = str.replace('9', '6');

        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'0']++;
        }

        arr[6] = (int) Math.ceil((double) arr[6] / 2.0);
        Arrays.sort(arr);

        System.out.println(arr[8]);
    }
}