import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Stack<Character> stkLeft = new Stack<>();
        Stack<Character> stkRight = new Stack<>();

        String string = br.readLine();
        int len = string.length();

        for (int i = 0; i < len; i++)
            stkLeft.push(string.charAt(i));

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "L" :
                    if (stkLeft.isEmpty())
                        continue;
                    else
                        stkRight.push(stkLeft.pop());
                    break;
                case "D" :
                    if (stkRight.isEmpty())
                        continue;
                    else
                        stkLeft.push(stkRight.pop());
                    break;
                case "B" :
                    if (stkLeft.isEmpty())
                        continue;
                    else
                        stkLeft.pop();
                    break;
                case "P" :
                    String s = st.nextToken();
                    stkLeft.push(s.charAt(0));
            }
        }

        while (!stkRight.isEmpty())
            stkLeft.push(stkRight.pop());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stkLeft.size(); i++)
            sb.append(stkLeft.get(i));

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}