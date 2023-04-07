import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        if(answer.length == 0) return new int[] {-1};
        
        int[] sortArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortArr);
        
        int min = sortArr[0];
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min) {
                answer[cnt] = arr[i];
                cnt++;
            } 
        }
        
        return answer;
    }
}