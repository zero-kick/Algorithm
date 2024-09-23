class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        
        int num = 1;
        
        while (num <= n * n) {
            // 1. (열) 왼 -> 오
            for (int i = left; i <= right; i++)
                answer[top][i] = num++;
            
            top++;
                
            // 2. (행) 위 -> 아래
            for (int i = top; i <= bottom; i++)
                answer[i][right] = num++;
            
            right--;
            
            // 3. (열) 오 > 왼
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    answer[bottom][i] = num++;

                bottom--;
            }
            
            // 4. (행) 아래 -> 위
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    answer[i][left] = num++;

                left++;
            }
        }
        
        return answer;
    }
}