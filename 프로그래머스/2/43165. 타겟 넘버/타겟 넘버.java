class Solution {
    int[] numbers;
    int target;
    int answer;

    public void dfs(int idx, int sum) {
        // 1. 탈출 조건
        if(idx == numbers.length) {
            if(sum == target) answer++;
            return;
        }

        // 2. 수행 동작
        dfs(idx+1, sum+numbers[idx]);
        dfs(idx+1, sum-numbers[idx]);
    }

    public int solution(int[] numbers, int target) {

        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }
}