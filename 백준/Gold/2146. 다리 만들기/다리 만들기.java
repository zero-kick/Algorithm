import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, min;
    public static int[][] cntr;
    public static boolean[][] visited;
    public static class Node {
        int x, y, dis;
        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static Queue<Node> q;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cntr = new int[n][n];
        visited = new boolean[n][n];
        q = new LinkedList<Node>();

        // 나라 세팅
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                cntr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬마다 넘버링
        numberingIsland();

        // 방문 초기화 및 최단 거리 초기화
        visited = new boolean[n][n];
        min = Integer.MAX_VALUE;

        // 최단 다리 길이 구하기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(cntr[i][j] == 0 || visited[i][j]) continue;

                // 다리 최단 거리 찾기
                findDistance(i, j, cntr[i][j]);

                // 다음 섬 탐색을 위한 방문 초기화
                visited = new boolean[n][n];

            }
        }
        bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
        br.close();

    }

    public static void numberingIsland() {
        int num = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] || cntr[i][j] == 0) continue;

                num++;
                q.offer(new Node(i, j, 0));
                cntr[i][j] = num;
                visited[i][j] = true;

                while(!q.isEmpty()) {
                    Node cur = q.poll();

                    for(int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(isNotRange(nx, ny) || visited[nx][ny] || cntr[nx][ny] == 0) continue;

                        q.offer(new Node(nx, ny, 0));
                        cntr[nx][ny] = num;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void findDistance(int i, int j, int num) {
        q = new LinkedList<Node>();
        q.offer(new Node(i, j, 0));
        visited[i][j] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                // 인접 칸이 나라의 범위를 벗어나거나, 이미 방문했으면 skip
                if(isNotRange(nx, ny) || visited[nx][ny]) continue;

                // 인접 칸이 현재 칸과 같은 섬이면 방문처리 후 skip
                if(cntr[nx][ny] == num) {
                    visited[nx][ny] = true;
                    continue;
                }

                // 인접 칸이 바다일 경우 큐에 넣고, 방문처리 (거리 계산 +1)
                if(cntr[nx][ny] == 0) {
                    q.offer(new Node(nx, ny, cur.dis+1));
                    visited[nx][ny] = true;
                }
                // 인접 칸이 현재 섬과 다른 섬인 경우 최단거리 비교
                else if(cntr[nx][ny] != 0 && cntr[nx][ny] != num) {
                    min = Math.min(min, cur.dis);
                    return;
                }
            }
        }
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= n) ? true : false;
    }
}
