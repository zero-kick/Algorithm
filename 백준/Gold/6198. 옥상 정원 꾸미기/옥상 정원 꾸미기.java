import java.io.*;
import java.util.Stack;

public class Main {
    public static int n;
    public static int[] bd;
    public static Stack<Integer> sLeft;
    public static Stack<Integer> sRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        bd = new int[n];
        sLeft = new Stack<Integer>();
        sRight = new Stack<Integer>();

        // 빌딩 세팅
        for(int i = 0; i < n; i++) {
            bd[i] = Integer.parseInt(br.readLine());
        }

        // 맨 우측 빌딩부터 스택에 push
        for(int i = 1; i <= n; i++) {
            sRight.push(bd[n-i]);
        }

        bw.write(String.valueOf(countBm()));
        bw.flush();
        bw.close();
        br.close();

    }

    public static long countBm() {
        long cnt = 0;

        while(!sRight.isEmpty()) {
            // 1. 최초 시작시 또는 새로 나온 빌딩이 이전에 나온 빌딩들보다 높은 경우 sLeft가 비워지게 되므로.
            if(sLeft.isEmpty()) sLeft.push(sRight.pop());

            // 2. sLeft로 원소를 하나 넘겼더니, sRight가 비어져버리는 경우(가장 오른쪽 빌딩이 가장 높은 경우)
            //    현재까지의 cnt를 return한다.
            if(sRight.isEmpty()) {
                return cnt;
            }

            // 지금 빌딩보다 오른쪽 빌딩이 낮은 경우
            // 현재 왼쪽에 위치하고 있는 빌딩들 전부보다 오른쪽 빌딩이 낮은 것이므로 스택에 담겨있는 빌딩 수만큼 cnt를 올려준다.
            // (주의) 오른쪽 빌딩을 sLeft에 담아주기 전에 카운트 먼저 해줘야함.
            if(sLeft.peek() > sRight.peek()) {
                cnt += sLeft.size();
                sLeft.push(sRight.pop());
            } else {
                sLeft.pop();
            }
        }

        return cnt;
    }
}