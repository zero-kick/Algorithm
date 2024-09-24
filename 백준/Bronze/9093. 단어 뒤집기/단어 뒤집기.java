import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] words = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();

            for (String word : words)
                sb.append(new StringBuilder(word).reverse()).append(" ");

            bw.write(sb.toString().trim() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}