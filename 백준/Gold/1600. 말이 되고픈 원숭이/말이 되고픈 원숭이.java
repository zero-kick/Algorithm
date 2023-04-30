import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int k, w, h;
    public static int[][] map;
    public static boolean[][][] visited;
    public static class Node {
        int x, y, move, hm;
        Node(int x, int y, int move, int hm) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.hm = hm;
        }
    }
    public static Queue<Node> q;
    public static int[] mDx = {-1, 1, 0, 0};
    public static int[] mDy = {0, 0, -1, 1};
    public static int[] hDx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] hDy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[k+1][h][w];
        q = new LinkedList<Node>();

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(findGoal()));
        bw.flush();
        bw.close();
        br.close();

    }

    public static int findGoal() {
        // 시작 세팅
        q.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == h-1 && cur.y == w-1) return cur.move;

            // 원숭이의 이동
            for(int t = 0; t < 4; t++) {
                int nx = cur.x + mDx[t];
                int ny = cur.y + mDy[t];

                // 맵의 범위를 벗어나거나, 이미 방문했거나, 벽이면 skip
                if(isNotRange(nx, ny) || visited[cur.hm][nx][ny] || map[nx][ny] == 1) continue;

                q.offer(new Node(nx, ny, cur.move+1, cur.hm));
                visited[cur.hm][nx][ny] = true;
            }

            // 말처럼 이동할 수 있는 횟수가 남아있으면
            if(cur.hm < k) {
                for(int t = 0; t < 8; t++) {
                    int nx = cur.x + hDx[t];
                    int ny = cur.y + hDy[t];

                    //맵의 범위를 벗어나거나, 이미 방문했거나, 벽이면 skip
                    if(isNotRange(nx, ny) || visited[cur.hm+1][nx][ny] || map[nx][ny] == 1) continue;

                    q.offer(new Node(nx, ny, cur.move+1, cur.hm+1));
                    visited[cur.hm+1][nx][ny] = true;
                }
            }
        }

        return -1;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= h || y < 0 || y >= w) ? true : false;
    }
}