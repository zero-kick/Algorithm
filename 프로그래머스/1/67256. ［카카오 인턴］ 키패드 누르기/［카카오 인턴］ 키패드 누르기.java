class Solution {
    class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";

            if(this.col == 0) finger = "L";
            else if(this.col == 2) finger = "R";
            else {
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);

                if(leftDist < rightDist)
                    finger = "L";
                else if(leftDist > rightDist)
                    finger = "R";
            }

            return finger;
        }

        public int getDistance(Position p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
    }

    Position left;
    Position right;
    Position numPos;

    public String solution(int[] numbers, String hand) {
        String answer = "";

        // 1. 손가락 위치 초기화
        left = new Position(3, 0);
        right = new Position(3, 2);

        for(int num : numbers) {
//            // 2. 숫자를 누를 손가락 정하기
//            int leftVal, rightVal;
//            // 3. 손가락을 answer에 담고, 손가락 위치 이동
//            switch(num) {
//                case 1:
//                    answer += "L";
//                    left = new Position(0, 0);
//                    break;
//                case 2:
//                    leftVal = Math.abs(left.row - 0)
//                                + Math.abs(left.col - 1);
//                    rightVal = Math.abs(right.row - 0)
//                                + Math.abs(right.col - 1);
//
//                    if(leftVal < rightVal) {
//                        answer += "L";
//                        left = new Position(0, 1);
//                    } else if(leftVal > rightVal) {
//                        answer += "R";
//                        right = new Position(0, 1);
//                    } else {
//                        if(hand.equals("left")) {
//                            answer += "L";
//                            left = new Position(0, 1);
//                        } else {
//                            answer += "R";
//                            right = new Position(0, 1);
//                        }
//                    }
//
//                    break;
//                case 3:
//                    answer += "R";
//                    right = new Position(0, 2);
//                    break;
//                case 4:
//                    answer += "L";
//                    left = new Position(1, 0);
//                    break;
//                case 5:
//                    leftVal = Math.abs(left.row - 1)
//                            + Math.abs(left.col - 1);
//                    rightVal = Math.abs(right.row - 1)
//                            + Math.abs(right.col - 1);
//
//                    if(leftVal < rightVal) {
//                        answer += "L";
//                        left = new Position(1, 1);
//                    } else if(leftVal > rightVal) {
//                        answer += "R";
//                        right = new Position(1, 1);
//                    } else {
//                        if(hand.equals("left")) {
//                            answer += "L";
//                            left = new Position(1, 1);
//                        } else {
//                            answer += "R";
//                            right = new Position(1, 1);
//                        }
//                    }
//
//                    break;
//                case 6:
//                    answer += "R";
//                    right = new Position(1, 2);
//                    break;
//                case 7:
//                    answer += "L";
//                    left = new Position(2, 0);
//                    break;
//                case 8:
//                    leftVal = Math.abs(left.row - 2)
//                            + Math.abs(left.col - 1);
//                    rightVal = Math.abs(right.row - 2)
//                            + Math.abs(right.col - 1);
//
//                    if(leftVal < rightVal) {
//                        answer += "L";
//                        left = new Position(2, 1);
//                    } else if(leftVal > rightVal) {
//                        answer += "R";
//                        right = new Position(2, 1);
//                    } else {
//                        if(hand.equals("left")) {
//                            answer += "L";
//                            left = new Position(2, 1);
//                        } else {
//                            answer += "R";
//                            right = new Position(2, 1);
//                        }
//                    }
//
//                    break;
//                case 9:
//                    answer += "R";
//                    right = new Position(2, 2);
//                    break;
//                case 0:
//                    leftVal = Math.abs(left.row - 3)
//                            + Math.abs(left.col - 1);
//                    rightVal = Math.abs(right.row - 3)
//                            + Math.abs(right.col - 1);
//
//                    if(leftVal < rightVal) {
//                        answer += "L";
//                        left = new Position(3, 1);
//                    } else if(leftVal > rightVal) {
//                        answer += "R";
//                        right = new Position(3, 1);
//                    } else {
//                        if(hand.equals("left")) {
//                            answer += "L";
//                            left = new Position(3, 1);
//                        } else {
//                            answer += "R";
//                            right = new Position(3, 1);
//                        }
//                    }
//
//                    break;
//            }

            // 2. 숫자를 누를 손가락 정하기
            numPos = new Position((num-1)/3, (num-1)%3);
            if(num == 0)
                numPos = new Position(3, 1);
            String finger = numPos.getFinger(hand);

            // 3. 정해진 손가락을 answer에 담고 손가락 위치 이동
            answer += finger;
            if(finger.equals("L"))
                left = numPos;
            else
                right = numPos;
        }

        return answer;

    }
}