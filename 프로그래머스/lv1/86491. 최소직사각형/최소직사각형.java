class Solution {
    public static int[] w;
    public static int[] h;
    public static int cnt;
    
    public int solution(int[][] sizes) {
        int answer = 0;
        cnt = sizes.length;
        
        w = new int[cnt];
        h = new int[cnt];
        
        for(int i = 0; i < cnt; i++) {
            if(sizes[i][0] > sizes[i][1]) {
                w[i] = sizes[i][0];
                h[i] = sizes[i][1];
            } else {
                w[i] = sizes[i][1];
                h[i] = sizes[i][0];
            }
        }
        
        answer = findSize();
        
        return answer;
    }
    
    public static int findSize() {
        int maxW = w[0];
        int maxH = h[0];
        
        for(int i = 1; i < cnt; i++) {
            if(maxW < w[i]) maxW = w[i];
            if(maxH < h[i]) maxH = h[i];
        }
        
        return maxW * maxH;
    }
}