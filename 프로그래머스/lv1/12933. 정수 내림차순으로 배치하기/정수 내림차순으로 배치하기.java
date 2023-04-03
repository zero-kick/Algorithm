class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String s = String.valueOf(n);
        String sArr[] = s.split("");
        int intArr[] = new int[sArr.length];
        
        for(int i = 0; i < sArr.length; i++) {
            intArr[i] = Integer.parseInt(sArr[i]);
        }
        
        int temp = 0;
        
        for(int i = 0; i < s.length()-1; i++) {
            for(int j = 1; j < s.length()-i; j++) {
                if(intArr[j-1] < intArr[j]) {
                    temp = intArr[j-1];
                    intArr[j-1] = intArr[j];
                    intArr[j] = temp;
                } else {
                    continue;
                }
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            answer += intArr[i] * Math.pow(10, s.length() - (i+1));
        }
        
        return answer;
    }
}