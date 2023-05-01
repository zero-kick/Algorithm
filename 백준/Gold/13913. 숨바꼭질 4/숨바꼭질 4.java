import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static int n, k;
    public static boolean[] visited;
    public static int[] bfMove;
    public static int[] dx = {2, 1, -1};
    public static class Node {
        int x, time;
        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    public static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        q = new LinkedList<Node>();
        visited = new boolean[100001];
        bfMove = new int[100001];
        Arrays.fill(bfMove, -1);

        q.offer(new Node(n, 0));
        visited[n] = true;

        // 동생을 찾는데 걸리는 최소 시간
        bw.write(String.valueOf(findBro()) + "\n");

        // 경로 역으로 추적하기
        int i = k;
        List<String> strList = new ArrayList<String>();
        strList.add(String.valueOf(k));
        while(bfMove[i] != -1) {
            strList.add(String.valueOf(bfMove[i]));
            i = bfMove[i];
        }
        
        // 역순으로 되어있으므로 반대로 출력
        for(int k = strList.size()-1; k >= 0; k--) {
            bw.write(strList.get(k) + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int findBro() {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == k) return cur.time;

            for(int k = 0; k < 3; k++) {
                int nx = 0;
                if(k == 0) {
                    nx = cur.x * dx[k];
                } else {
                    nx = cur.x + dx[k];
                }

                // 맵의 범위를 벗어나거나, 이미 방문한 칸인 경우 skip
                if(isNotRange(nx) || visited[nx]) continue;

                q.offer(new Node(nx, cur.time+1));      // 큐에 등록
                visited[nx] = true;                          // 방문처리
                bfMove[nx] = cur.x;                          // 이전에 거쳐온 칸 기억
            }
        }

        return -1;
    }

    public static boolean isNotRange(int x) {
        return (x < 0 || x >= 100001) ? true : false;
    }
}