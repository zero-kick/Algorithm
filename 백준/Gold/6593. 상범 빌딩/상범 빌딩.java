import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int l, r, c;
    public static char[][][] bd;
    public static int[][][] time;
    public static class Pair {
        int z, x, y;
        Pair(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    public static Queue<Pair> q;
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int[] dx = {1, 0, -1, 0, 0, 0};
    public static int[] dy = {0, -1, 0, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        while(l > 0) {
            // 빌딩, 방문 시간 세팅
            bd = new char[l][r][c];
            time = new int[l][r][c];
            q = new LinkedList<Pair>();
            
            for(int k = 0; k < l; k++) {
                for(int i = 0; i < r; i++) {
                    String[] strArr = br.readLine().split("");
                    for(int j = 0; j < c; j++) {
                        char ch = strArr[j].charAt(0);
                        bd[k][i][j] = ch;
                        if(ch == 'S') {
                            q.offer(new Pair(k, i, j));
                            time[k][i][j] = 0;
                        } else {
                            time[k][i][j] = -1;
                        }
                    }
                }
                br.readLine();
            }

            // 탈출 시작
            int result = findEscape();
            if(result > -1) {
                bw.write("Escaped in " + result + " minute(s)." + "\n");
            } else {
                bw.write("Trapped!" + "\n");
            }

            // 다음 테스트 케이스 세팅
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }

        bw.flush();
        bw.close();
    }

    public static int findEscape() {
        while(!q.isEmpty()) {
            Pair pollCell = q.poll();

            // 탈출구에 도착하면
            if(bd[pollCell.z][pollCell.x][pollCell.y] == 'E') return time[pollCell.z][pollCell.x][pollCell.y];

            // 인접 칸 탐색 (하, 좌, 우, 상, 하(3차원), 상(3차원))
            for(int k = 0; k < 6; k++) {
                int nz = pollCell.z + dz[k];
                int nx = pollCell.x + dx[k];
                int ny = pollCell.y + dy[k];

                // 빌딩 범위를 벗어나거나, 금으로 막혀있거나, 이미 방문한 칸이면 skip
                if(isNotRange(nz, nx, ny) || bd[nz][nx][ny] == '#' || time[nz][nx][ny] > -1) continue;

                q.offer(new Pair(nz, nx, ny));
                time[nz][nx][ny] = time[pollCell.z][pollCell.x][pollCell.y] + 1;
            }
        }

        // 이동이 끝난 후에도 탈출구에 도착못했으므로 fail
        return -1;
    }

    public static boolean isNotRange(int z, int x, int y) {
        return (z < 0 || z >= l || x < 0 || x >= r || y < 0 || y >= c) ? true : false;
    }
}