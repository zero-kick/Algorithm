import java.io.*;
import java.util.*;

public class Main {
    public static int m, n, k;
    public static int[][] paper;
    public static boolean[][] visit;
    public static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Queue<Pair> q;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        paper = new int[m][n];
        visit = new boolean[m][n];
        q = new LinkedList<Pair>();

        for(int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());

            // 그림에서 주어진 x, y 축의 개념과 2차원 배열의 i, j의 개념이 다르기 때문에
            // 생각을 잘해야한다. (여러번 찍어보면서 그리는 수밖에 없을듯)
            int sX = Integer.parseInt(st.nextToken());
            int eY = m - Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            int sY = m - Integer.parseInt(st.nextToken());

            for(int i = sY; i < eY; i++) {
                for(int j = sX; j < eX; j++) {
                    paper[i][j] = 1;
                }
            }
        }
        br.close();

        // 나머지 영역 찾기
        List<Integer> list = findEtc();
        bw.write(String.valueOf(list.remove(list.size()-1)) + "\n");

        list.sort(Comparator.naturalOrder());
        for(int temp : list) {
            bw.write(String.valueOf(temp) + " ");
        }

        bw.flush();
        bw.close();

    }

    public static List<Integer> findEtc() {
        List<Integer> returnList = new ArrayList<Integer>();
        int domain = 0;     // 영역 개수
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // 이미 방문한 칸이거나, 직사각형이 그려져 있다면 skip
                if(visit[i][j] || paper[i][j] == 1) continue;

                // 나머지 영역 시작점 세팅
                q.offer(new Pair(i, j));
                visit[i][j] = true;
                domain++;

                // 인접 칸 탐색
                int area = 0;       // 면적
                while(!q.isEmpty()) {
                    area++;

                    Pair pollCell = q.poll();

                    for(int k = 0; k < 4; k++) {
                        int nx = pollCell.x + dx[k];
                        int ny = pollCell.y + dy[k];

                        // 종이의 범위를 벗어나거나, 직사각형이 그려져 있거나, 이미 방문했다면 skip
                        if(isNotRange(nx, ny) || paper[nx][ny] == 1 || visit[nx][ny]) continue;

                        // 인접칸을 큐에 세팅, 방문 처리
                        q.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
                returnList.add(area);
            }
        }
        returnList.add(domain);

        return returnList;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= m || y < 0 || y >= n) ? true : false;
    }
}