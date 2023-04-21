import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int findVal = 0;
        int idx = 0;
        int answer = 0;

        for(int i = 0; i < n; i++) {
            findVal = x - Integer.parseInt(arr[i]);
            arr[i] = "";
            idx = Arrays.binarySearch(arr, String.valueOf(findVal));
            if(idx >= 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}