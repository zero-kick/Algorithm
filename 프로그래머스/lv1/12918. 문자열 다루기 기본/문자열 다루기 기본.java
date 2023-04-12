class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        int len = s.length();
        
        if(len == 4 || len == 6) {
            answer = true;
            
            for(int i = 0; i < len; i++) {
                if(0 > Character.getNumericValue(s.charAt(i))
                   || Character.getNumericValue(s.charAt(i)) > 9) {
                    answer = false;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}