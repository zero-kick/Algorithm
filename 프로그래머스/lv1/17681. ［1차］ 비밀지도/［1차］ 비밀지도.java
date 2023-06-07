class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        long bitCal;
        String binary;
        
        for(int i = 0; i < n; i++) {
            bitCal = arr1[i] | arr2[i];
            
            binary = String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(bitCal)));
            binary = binary.replace("1", "#");
            binary = binary.replace("0", " ");
            
            answer[i] = binary;
        }
        
        return answer;
    }
}