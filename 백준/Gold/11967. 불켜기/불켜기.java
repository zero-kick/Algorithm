import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, cnt;
    public static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean[][] visited;
    public static boolean[][] lightOn;
    public static boolean[][] ableRoom;
    public static Queue<Node> q;
    public static ArrayList<Node>[][] barn;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        lightOn = new boolean[n][n];    // 불이 켜져있는지 체크
        ableRoom = new boolean[n][n];   // 탐색했던 방의 인접 칸인 경우, 방문 불이 켜진다면 가능한 방임
        q = new LinkedList<Node>();
        cnt = 0;

        // 헛간 세팅
        barn = new ArrayList[n][n];     // 방안에 여러개의 스위치가 있을 수 있으므로 리스트형 배열로 선언
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                barn[i][j] = new ArrayList<Node>();
            }
        }

        // 각 방 별로 스위치 정보 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            barn[x-1][y-1].add(new Node(sx-1, sy-1));
        }

        // 큐 초기 세팅
        q.offer(new Node(0, 0));
        visited[0][0] = true;
        lightOn[0][0] = true;
        cnt++;

        findSwitch();
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findSwitch() {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            // 방문가능한 방 체크하기
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                // 헛간의 범위를 벗어나는 경우 skip
                if(isNotRange(nx, ny)) continue;

                // 헛간의 범위를 벗어나지 않는 경우, 불이 켜져있기만 하다면 방문이 가능해지므로 방문 가능한 방으로 체크
                ableRoom[nx][ny] = true;
            }

            // 현재 방에서 불은 켤 수 있는 방의 불 전부 켜기
            for(int k = 0; k < barn[cur.x][cur.y].size(); k++) {
                Node tmp = barn[cur.x][cur.y].get(k);
                if(!lightOn[tmp.x][tmp.y]) {
                    lightOn[tmp.x][tmp.y] = true;
                    cnt++;
                }

                // 방문 가능한 방이고, 아직 방문한 적이 없다면 큐에 넣고 방문 처리
                if(ableRoom[tmp.x][tmp.y] && !visited[tmp.x][tmp.y]) {
                    q.offer(new Node(tmp.x, tmp.y));
                    visited[tmp.x][tmp.y] = true;
                }
            }

            // 인접 방 탐색
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                // 헛간의 범위를 벗어나거나, 이미 방문한 방이거나, 불이 꺼져있는 방이거나, 방문 불가능한 방인 경우 skip
                if(isNotRange(nx, ny) || visited[nx][ny] || !lightOn[nx][ny] || !ableRoom[nx][ny]) continue;

                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;

            }
        }
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= n) ? true : false;
    }
}
