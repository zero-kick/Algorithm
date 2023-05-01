import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k;
    public static int[][] map;
    public static boolean[][][] visited;
    public static class Node {
        int x, y, dis, brk, day;
        Node(int x, int y, int dis, int brk, int day) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.brk = brk;
            this.day = day;
        }
    }
    public static Queue<Node> q;
    public static int[] dx = {-1, 1, 0, 0, 0};
    public static int[] dy = {0, 0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 맵의 행 크기
        m = Integer.parseInt(st.nextToken());   // 맵의 열 크기
        k = Integer.parseInt(st.nextToken());   // 벽을 부술 수 있는 횟수

        map = new int[n][m];
        q = new LinkedList<Node>();
        visited = new boolean[k+1][n][m];   // 방문 배열 세팅 시 벽을 부순 횟수 별로 체크하기 위함

        // 맵 세팅
        for(int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        // 시작 위치 세팅 (0, 0), 낮 : 1
        q.offer(new Node(0, 0, 1, 0, 1));
        visited[0][0][0] = true;

        bw.write(String.valueOf(findGoal()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findGoal() {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            // 목적지에 도착했다면 거리 return
            if(cur.x == n-1 && cur.y == m-1) return cur.dis;

            // 인접 칸 탐색
            for(int t = 0; t < 5; t++) {
                int nx = cur.x + dx[t];
                int ny = cur.y + dy[t];

                // 인접 칸이 맵의 범위를 벗어나거나, 이미 방문한 경우 skip
                if(isNotRange(nx, ny) || visited[cur.brk][nx][ny]) continue;

                // 인접 칸이 벽인 경우
                if(map[nx][ny] == 1) {
                    // 낮인 경우
                    if(cur.day == 1) {
                        // 벽을 부술 수 있는 횟수가 남아있고, 인접 칸이 벽을 부수고 방문 한적 없는 경우
                        if(cur.brk < k && !visited[cur.brk+1][nx][ny]) {
                            q.offer(new Node(nx, ny, cur.dis + 1, cur.brk + 1, cur.day*(-1)));    // 이동거리 +1, 벽 부순 횟수 +1, 낮밤 변경
                            visited[cur.brk + 1][nx][ny] = true;  // 벽을 추가로 부셨으므로 부순 횟수를 +1한 방문 배열에 방문처리
                        }
                    }
                    // 밤인 경우 벽을 부술 수 없으므로, 제자리이지만 방문 칸의 개수는 늘고, 낮과 밤은 바뀐다고 하였으므로.
                    else {
                        q.offer(new Node(cur.x, cur.y, cur.dis+1, cur.brk, cur.day*(-1)));
                    }
                // 인접 칸이 벽인데 밤이거나, 벽이 아닌 경우
                } else {
                    q.offer(new Node(nx, ny, cur.dis+1, cur.brk, cur.day*(-1)));  // 이동거리 +1, 낮밤 변경
                    visited[cur.brk][nx][ny] = true;    // 벽을 추가로 부수지 않았으므로, 현재 방문 배열에 방문 처리
                }
            }
        }

        return -1;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= m) ? true : false;
    }
}