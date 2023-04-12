class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int cnt = 2;
            
            for(int j = 2; j < i; j++) {
                cnt += i%j == 0 ? 1 : 0;
            }
            
            if(i == 1) cnt = 1;
            
            answer += cnt%2 == 0 ? i : (-1)*i;
            
        }
        
        return answer;
    }
}