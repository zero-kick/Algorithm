import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int len = str.length();
        String[] arr = new String[len];

        for (int i = 0; i < len; i++)
            arr[i] = str.substring(i);

        Arrays.sort(arr);

        for (String s : arr)
            bw.write(s + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}