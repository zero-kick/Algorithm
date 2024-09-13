class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계
        answer = answer.replaceAll("\\.+", ".");
        
        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5단계
        if(answer.isEmpty())
           answer = "a";
        
        // 6단계
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        // 7단계
        while(answer.length() < 3)
            answer += answer.substring(answer.length() - 1);
        
        return answer;
    }
}