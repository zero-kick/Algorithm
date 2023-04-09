class Solution {
    public String solution(int n) {
        String answer = "";
        
        int evenCnt = 0;
        int oddCnt = 0;
        
        if(n%2 == 0) {
            evenCnt = n/2;
        } else {
            evenCnt = n/2;
            oddCnt = 1;
        }
        
        for(int i = 0; i < evenCnt; i++) {
            answer += "수박";
        }
        
        if(oddCnt == 1) answer += "수";
        
        return answer;
    }
}