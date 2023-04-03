class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String number = String.valueOf(x);
        int sum = 0;
        
        for(int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            
            sum += Character.getNumericValue(ch);
        }
        
        answer = (x%sum == 0) ? true : false;
        
        return answer;
    }
}