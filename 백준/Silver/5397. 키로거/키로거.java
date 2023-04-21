import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            Stack<Character> stkLeft = new Stack<Character>();
            Stack<Character> stkRight = new Stack<Character>();

            String cmd = br.readLine();

            for(int j = 0; j < cmd.length(); j++) {
                switch(cmd.substring(j, j+1)) {
                    case "<" :
                        if(stkLeft.isEmpty()) break;
                        stkRight.push(stkLeft.pop());
                        break;
                    case ">" :
                        if(stkRight.isEmpty()) break;
                        stkLeft.push(stkRight.pop());
                        break;
                    case "-" :
                        if(stkLeft.isEmpty()) break;
                        stkLeft.pop();
                        break;
                    default :
                        stkLeft.push(cmd.substring(j, j+1).charAt(0));
                        break;
                }
            }

            while(!stkLeft.isEmpty()) {
                stkRight.push(stkLeft.pop());
            }

            while(!stkRight.isEmpty()) {
                bw.write(stkRight.pop());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}