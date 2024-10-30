import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String binaryString = br.readLine();

        BigInteger binary = new BigInteger(binaryString, 2);
        String octalString = binary.toString(8);

        bw.write(octalString);
        bw.flush();
        bw.close();
        br.close();
    }
}