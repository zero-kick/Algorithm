import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static class Top {
        int num;
        int height;

        Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Top> stk = new Stack<Top>();

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while(true) {
                if(stk.isEmpty()) {
                    bw.write(0 + " ");
                    stk.push(new Top(i, height));
                    break;
                }

                if(stk.peek().height >= height) {
                    bw.write(stk.peek().num + " ");
                    stk.push(new Top(i, height));
                    break;
                } else {
                    stk.pop();
                }
            }
        }

        br.close();

        bw.flush();
        bw.close();

    }
}
