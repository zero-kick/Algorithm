class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        int length = s.length();
        
        if(length%2 == 0) {
            idx = length/2 - 1; 
            answer = s.substring(idx, idx+2);
        } else {
            idx = (int) length/2;
            answer = s.substring(idx, idx+1);
        }
        
        return answer;
    }
}