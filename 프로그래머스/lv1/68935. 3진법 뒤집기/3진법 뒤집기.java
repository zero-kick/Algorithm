class Solution {
    public int solution(int n) {
        int answer = 0;

        // 10진법 > 3진법
        int idx = 0;
        long ternaryScale = 0;
        
        while(n >= 3) {  
            ternaryScale += (long) (n % 3) * (long) Math.pow(10, idx);
            
            n = n / 3;
            idx++;
        }
        
        ternaryScale += n * (long) Math.pow(10, idx);
        
        // 3진법 > 10진법
        String tsStr = String.valueOf(ternaryScale);
        int len = tsStr.length();
        
        for(int i = 0; i < len; i++) {
            answer += Character.getNumericValue(tsStr.charAt(i)) * (long) Math.pow(3, i);
        }
        
        return answer;
    }
}
