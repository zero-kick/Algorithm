class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a == b) return (long) a;
                      
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        int cnt = max - min + 1;
        
        answer = (long) cnt * (a + b) / 2;
       
        return answer;
    }
}