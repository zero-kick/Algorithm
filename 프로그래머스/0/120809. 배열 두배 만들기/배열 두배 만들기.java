class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        int i = 0;
        for(int num : numbers) {
            answer[i] = num * 2;
            i++;
        }
        
        return answer;
    }
}