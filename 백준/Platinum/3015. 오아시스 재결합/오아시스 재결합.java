import java.io.*;
import java.util.Stack;

public class Main {
    public static int n;
    public static long cnt;
    public static int[] line;
    public static class Node {
        int height, sameCnt;
        Node(int height, int sameCnt) {
            this.height = height;
            this.sameCnt = sameCnt;
        }
    }
    public static Stack<Node> stk;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        line = new int[n];
        for(int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        stk = new Stack<Node>();
        cnt = 0;

        for(int i = 0; i < n; i++) {
            // 새로운 사람의 키와 중복된 키를 갖는 사람(최초 1) 세팅
            Node newOne = new Node(line[i], 1);

            // 줄의 가장 뒷사람과 새로온 사람의 키를 비교하여,
            // 두 사람의 키가 서로 같거나, 새로온 사람의 키가 큰 경우
            while(!stk.isEmpty() && stk.peek().height <= newOne.height) {
                // 줄의 가장 뒷사람을 pop하고, cnt를 올려준다.
                Node pop = stk.pop();
                cnt += pop.sameCnt;

                // 만약 줄의 가장 뒷사람과 새로온 사람이 키가 같은 경우에는
                // 줄의 가장 뒷사람이 갖고 있는 중복된 키를 갖는 사람의 수를 이어 받는다.
                if(pop.height == line[i]) {
                    newOne.sameCnt += pop.sameCnt;
                }
            }

            // 새로운 사람이 자신 보다 키가 작은 사람들을 스택에서 모두 제거하였는데도,
            // 스택이 비어있지 않다면 자신보다 큰 사람과 쌍을 이룰 수 있는 경우이므로 cnt를 올려준다.
            if(!stk.isEmpty()) cnt++;

            // 새로온 사람이 될 사람을 스택에 담는다.
            stk.push(newOne);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}