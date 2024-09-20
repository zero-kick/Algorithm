class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String bab : babbling) {

            bab = bab.replace("aya", "?");
            bab = bab.replace("ye", "?");
            bab = bab.replace("woo", "?");
            bab = bab.replace("ma", "?");
            
            bab = bab.replace("?", "");
            if(bab.equals(""))
                answer++;
        }
        
        return answer;
    }
}