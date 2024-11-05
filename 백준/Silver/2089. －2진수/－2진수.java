import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder binaryString = new StringBuilder();

        if (N == 0) bw.write("0");
        else bw.write(binary(binaryString, N).reverse().toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static StringBuilder binary(StringBuilder binaryString, int N) {
        if(N == 0) return binaryString;
        int next;

        if (N % -2 < 0) {
            binaryString.append("1");
            next = (N/-2)+1;
        } else {
            binaryString.append(N % 2);
            next = N/-2;
        }

        return binary(binaryString, next);
    }
}
