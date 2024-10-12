import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        StringBuilder sb = new StringBuilder();

        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int[] arr = new int[4];

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (Character.isLowerCase(ch))
                    arr[0]++;
                else if (Character.isUpperCase(ch))
                    arr[1]++;
                else if (Character.isDigit(ch))
                    arr[2]++;
                else
                    arr[3]++;
            }

            for (int a : arr) sb.append(a).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}