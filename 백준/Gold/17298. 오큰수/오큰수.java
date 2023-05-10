import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] a;
    public static int[] nge;
    public static Stack<Integer> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        nge = new int[n];
        stk = new Stack<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 오큰수 찾기
        findNge();

        // 정답 출력
        for(int i = 0; i < nge.length; i++) {
            bw.write(String.valueOf(nge[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void findNge() {
        // n개의 수를 돌면서
        for(int i = 0; i < n; i++) {
            // 스택에 a배열의 인덱스가 들어있는 경우
            while(!stk.isEmpty()) {
                // 현재 값과 스택에 들어있는 인덱스를 갖는 배열 값을 비교하여
                // 배열의 값이 큰 경우 오큰수이므로, nge[스택pop인덱스]에 해당 값을 할당한다.
                if(a[stk.peek()] < a[i]) {
                    nge[stk.pop()] = a[i];
                // 현재 값보다 스택에 들어있는 인덱스를 갖는 배열의 값이 더 크거나 같은 경우
                // 오큰수가 아니므로 현재 값을 스택에 담아주고 다음 인덱스를 탐색한다.
                } else {
                    break;
                }
            }
            stk.push(i);
        }

        // 수열을 모두 탐색하였는데도 스택에 남아있는 수의 경우
        // 오큰수가 존재하지 않는다는 것이므로 -1을 할당한다.
        while(!stk.isEmpty()) {
            nge[stk.pop()] = -1;
        }
    }
}