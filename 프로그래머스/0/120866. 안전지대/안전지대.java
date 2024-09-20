class Solution {
    public int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    public int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    public int n;
    
    // 범위를 벗어나는지 확인하는 함수
    public boolean isNotArea(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;

        // 위험 지역을 표시할 별도의 배열
        boolean[][] danger = new boolean[n][n];

        // 지뢰를 기준으로 주변 위험 지역을 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {  // 지뢰 발견
                    danger[i][j] = true;  // 지뢰 자체도 위험 지역으로 처리
                    
                    // 8방향 탐색
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if (!isNotArea(nx, ny)) {  // 범위 내에 있으면
                            danger[nx][ny] = true;  // 위험 지역 표시
                        }
                    }
                }
            }
        }

        // 안전한 지역 카운트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !danger[i][j]) {  // 지뢰도 없고 위험 지역도 아닌 경우
                    answer++;
                }
            }
        }

        return answer;
    }
}
