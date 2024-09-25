import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String par = br.readLine();
            int ogLen = par.length();
            par = par.replace("()", "");

            while (ogLen != par.length()) {
                ogLen = par.length();
                par = par.replace("()", "");
            }

            String result = par.isBlank() ? "YES" : "NO";

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}