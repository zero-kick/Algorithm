import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int tc, w, h;
    public static char[][] bd;
    public static int[][] fire;
    public static int[][] sg;
    public static int dx[] = {1, 0, -1, 0};
    public static int dy[] = {0, -1, 0, 1};

    public static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Queue<Pair> qFire;
    public static Queue<Pair> qSg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 불 번짐 탐색을 위한 큐 생성
            qFire = new LinkedList<Pair>();
            // 상근 이동위치 탐색을 위한 큐 생성
            qSg = new LinkedList<Pair>();

            // 빌딩, 불, 상근 세팅
            bd = new char[h][w];
            fire = new int[h][w];
            sg = new int[h][w];

            for(int i = 0; i < h; i++) {
                String[] strArr = br.readLine().split("");
                for(int j = 0; j < w; j++) {
                    char ch = strArr[j].charAt(0);
                    
                    // 빌딩 도면 생성
                    bd[i][j] = ch;

                    // 불 시작 위치, 시간 세팅
                    if(ch == '*') {
                        qFire.offer(new Pair(i, j));
                        fire[i][j] = 0;
                    } else {
                        fire[i][j] = -1;
                    }
                    
                    // 상근이 시작 위치, 시간 세팅
                    if(ch == '@') {
                        qSg.offer(new Pair(i, j));
                        sg[i][j] = 0;
                    } else {
                        sg[i][j] = -1;
                    }
                }
            }

            // 빌딩 탈출
            bw.write(findEscape() + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static String findEscape() {
        // 불의 번짐 탐색
        while(!qFire.isEmpty()) {
            Pair pollCell = qFire.poll();

            // 인접 칸 탐색
            for(int k = 0; k < 4; k++) {
                int nx = pollCell.x + dx[k];
                int ny = pollCell.y + dy[k];
                
                // 빌딩 범위를 벗어나거나, 벽이거나, 이미 불이 번져있으면 skip
                if(isNotRange(nx, ny) || bd[nx][ny] == '#' || fire[nx][ny] != -1) continue;
                
                // 불 번짐
                qFire.offer(new Pair(nx, ny));
                fire[nx][ny] = fire[pollCell.x][pollCell.y] + 1;    // 불 번짐 시간 +1초
            }
        }
        
        // 상근 이동 탐색
        while(!qSg.isEmpty()) {
            Pair pollCell = qSg.poll();

            // 상근이가 빌딩 범위를 벗어나면 탈출
            // 즉, 현재 위치가 빌딩의 가장자리이면 탈출
            if(isEdge(pollCell.x, pollCell.y)) return String.valueOf(sg[pollCell.x][pollCell.y] + 1);

            // 인접 칸 탐색
            for(int k = 0; k < 4; k++) {
                int nx = pollCell.x + dx[k];
                int ny = pollCell.y + dy[k];

                // 빌딩 범위를 벗어나거나, 벽이거나, 이미 상근이가 지나간 자리이거나,
                // 상근이 도착 시점에 불이 이미 번져있으면 skip
                if(isNotRange(nx, ny) || bd[nx][ny] == '#' || sg[nx][ny] != -1
                        || (fire[nx][ny] != -1 && fire[nx][ny] <= sg[pollCell.x][pollCell.y]+1)) continue;
                
                // 상근 이동
                qSg.offer(new Pair(nx, ny));
                sg[nx][ny] = sg[pollCell.x][pollCell.y] + 1;    // 상근 이동 시간 +1초
            }
        }
        
        // 상근이가 이동 중에 탈출을 못했으므로
        return "IMPOSSIBLE";
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= h || y < 0 || y >= w) ? true : false;
    }

    public static boolean isEdge(int x, int y) {
        return (x == 0 || x == h-1 || y == 0 || y == w-1) ? true : false;
    }
}