import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int n, l;
    public static Deque<Node> deque;
    public static class Node {
        int a, idx;
        Node(int a, int idx) {
            this.a = a;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        deque = new ArrayDeque<Node>();
        int sttIdx = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            // 현재 값
            int cur = Integer.parseInt(st.nextToken());

            // 비교 대상 범위 내 첫 인덱스
            sttIdx = i-l+1 < 0 ? 0 : i-l+1;

            // 첫번째 원소는 덱에 넣어주고, 최솟값이므로 출력
            if(deque.isEmpty()) {
                deque.offer(new Node(cur, i));
                bw.write(deque.peek().a + " ");
                continue;
            }

            // 덱의 첫번째 원소가 비교 대상 범위 바깥이면 poll
            if(deque.peekFirst().idx < sttIdx) deque.pollFirst();

            // 새로 들어올 원소가 덱의 마지막 원소보다 작은 경우 덱의 마지막 원소 poll
            // (새로 들어올 원소보다 덱의 마지막 원소가 작은 값이 나올때까지, 이 과정에서 덱에 원소가 하나도 남지 않게되면 반복 종료)
            // > 이렇게 하면 덱 안에서는 오름차순을 유지하게 되고, 덱의 첫번째 원소가 그 비교 범위 내 최솟값이 된다.
            while(!deque.isEmpty() && cur < deque.peekLast().a) {
                deque.pollLast();
            }

            // 현재 원소를 덱에 offer
            deque.offerLast(new Node(cur, i));

            // 모든 조건을 적용시킨 후 최솟값 출력
            bw.write(deque.peekFirst().a + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}