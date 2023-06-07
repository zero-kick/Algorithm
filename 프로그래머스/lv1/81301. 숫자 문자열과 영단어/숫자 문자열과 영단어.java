class Solution {
    public int solution(String s) {
        int answer = 0;
        char ch;
        String str = "";
        
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            
            switch(ch) {
                case 'z':
                    str += '0';
                    i += 3;
                    break;
                case 'o':
                    str += '1';
                    i += 2;
                    break;
                case 't':
                    if(s.charAt(i+1) == 'w') {
                        str += '2';
                        i += 2;
                    } else {
                        str += '3';
                        i += 4;
                    }
                    break;
                case 'f':
                    if(s.charAt(i+1) == 'o') {
                        str += '4';
                        i += 3;
                    } else {
                        str += '5';
                        i += 3;
                    }
                    break;
                case 's':
                    if(s.charAt(i+1) == 'i') {
                        str += '6';
                        i += 2;
                    } else {
                        str += '7';
                        i += 4;
                    }
                    break;
                case 'e':
                    str += '8';
                    i += 4;
                    break;
                case 'n':
                    str += '9';
                    i += 3;
                    break;
                default:
                    str += ch;
                    break;
            }
        }
        
        answer = Integer.parseInt(str);
        
        return answer;
    }
}