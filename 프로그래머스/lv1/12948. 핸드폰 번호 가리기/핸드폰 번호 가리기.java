class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int idx = phone_number.length();
        
        String front_number = phone_number.substring(0, idx-4);
        String back_number = phone_number.substring(idx-4, idx);
        
        answer = front_number.replaceAll("[0-9]", "*") + back_number;
      
        return answer;
    }
}