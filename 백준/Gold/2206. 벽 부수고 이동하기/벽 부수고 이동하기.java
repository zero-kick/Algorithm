import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n , m;
    public static int[][] map;
    public static boolean[][][] visit;      // 벽을 부수지 않고 이동한 경우와
                                            // 벽을 부수고 이동한 경우를 각각 따져주기위해 3차원 배열 선언
    public static class Node {
        int x, y, dist, brk;      // 경로와, 벽을 부순 횟수를 체크하기 위해 노드 클래스에 변수 선언
        Node(int x, int y, int dist, int brk) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.brk = brk;
        }
    }
    public static Queue<Node> q;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[2][n][m];
        q = new LinkedList<Node>();

        // 맵 세팅, 초기 위치 세팅
        for(int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                int cell = Integer.parseInt(strArr[j]);
                map[i][j] = cell;

                if(i == 0 && j == 0) {
                    q.offer(new Node(i, j, 1, 0));
                    visit[0][i][j] = true;  // 벽을 부수지 않고 이동한 경우를 따져주기 위함
                    visit[1][i][j] = true;  // 벽을 부수고 이동한 경우를 따져주기 위함
                }
            }
        }

        // 목적지 찾기
        bw.write(String.valueOf(findGoal()));
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int findGoal() {
        while(!q.isEmpty()) {
            Node pc = q.poll();

            // 목적지에 도착했으면 return
            if(pc.x == n-1 && pc.y == m-1) return pc.dist;

            // 인접한 칸 탐색
            for(int k = 0; k < 4; k++) {
                int nx = pc.x + dx[k];
                int ny = pc.y + dy[k];

                // 맵의 범위를 벗어나거나, 이전에 방문한 적이 있는 경우 skip
                if (isNotRange(nx, ny) || visit[pc.brk][nx][ny]) continue;

                // 인접 칸이 벽인 경우
                if(map[nx][ny] == 1) {
                    if(pc.brk == 0) {   // 벽을 한번도 부수지 않고 해당 경로까지 온 경우 벽을 부수고 이동한다.
                        q.offer(new Node(nx, ny, pc.dist + 1, pc.brk + 1));
                        visit[pc.brk][nx][ny] = true;
                    }
                }
                // 인접 칸이 벽이 아닌 경우
                else {
                    // 큐에 넣고, 방문처리 (경로 + 1)
                    q.offer(new Node(nx, ny, pc.dist + 1, pc.brk));
                    visit[pc.brk][nx][ny] = true;
                }

            }
        }

        // 이동이 끝나도록 목적지에 도달하지 못했으므로 -1
        return -1;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= m) ? true : false;
    }
}