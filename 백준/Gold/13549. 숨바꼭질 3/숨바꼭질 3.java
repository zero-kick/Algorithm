import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static boolean[] visited;
    public static class Node {
        int x, time;
        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    public static Queue<Node> q;
    public static int[] dx = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 수빈 위치
        k = Integer.parseInt(st.nextToken());   // 동생 위치

        q = new LinkedList<Node>();
        visited = new boolean[100001];      // 두 사람의 이동 위치가 0~100000이므로 배열 크기 100001 세팅

        q.offer(new Node(n, 0));
        visited[n] = true;

        bw.write(String.valueOf(findBro()));
        bw.flush();
        bw.close();
        br.close();

    }

    public static int findBro() {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == k) return cur.time;

            for(int k = 0; k < 3; k++) {
                int nx;
                if(k == 0) {
                    nx = cur.x * dx[k];
                    if(isNotRange(nx) || visited[nx]) continue;
                    q.offer(new Node(nx, cur.time));
                }
                // 변화값 3번쨰는 * 2를 해주는 것
                else {
                    nx = cur.x + dx[k];
                    if(isNotRange(nx) || visited[nx]) continue;
                    q.offer(new Node(nx, cur.time + 1));    // 순간이동 시 0초 걸리므로
                }

                visited[nx] = true;
            }
        }

        return -1;
    }

    public static boolean isNotRange(int x) {
        return (x < 0 || x >= 100001) ? true : false;
    }
}