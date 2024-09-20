class Solution {
    public boolean isParallel(int[] d1, int[] d2, int[] d3, int[] d4) {
        
        
        return (d1[1] - d2[1]) * (d3[0] - d4[0]) == (d3[1] - d4[1]) * (d1[0] - d2[0]);
    }
    
    public int solution(int[][] dots) {
        int answer = 0;
        
        if(isParallel(dots[0], dots[1], dots[2], dots[3])) answer = 1;
        if(isParallel(dots[0], dots[2], dots[1], dots[3])) answer = 1;
        if(isParallel(dots[0], dots[3], dots[2], dots[1])) answer = 1;
        
        return answer;
    }
}