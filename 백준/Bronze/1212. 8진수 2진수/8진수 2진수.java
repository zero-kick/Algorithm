import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String octalString = br.readLine();

        BigInteger octal = new BigInteger(octalString, 8);
        String binaryString = octal.toString(2);

        bw.write(binaryString);
        bw.flush();
        bw.close();
        br.close();
    }
}