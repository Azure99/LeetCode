class Solution {
    private static final int ADD = -1;
    private static final int SUBTRACT = -2;
    private static final int LEFT = -3;
    private static final int RIGHT = -4;

    private String str;
    private int index = 0;

    public int calculate(String s) {
        str = s.replaceAll(" ", "");

        Stack<Integer> numStk = new Stack<>();
        Stack<Integer> operStk = new Stack<>();
        int nowVal = 0;

        int last = ADD;
        while (hasNext()) {
            int now = getNext();
            if (now == ADD) {
                last = ADD;

            } else if (now == SUBTRACT) {
                last = SUBTRACT;

            } else if (now == LEFT) {
                numStk.push(nowVal);
                operStk.push(last);
                last = ADD;
                nowVal = 0;

            } else if (now == RIGHT) {
                if (operStk.pop() == ADD) {
                    nowVal = numStk.pop() + nowVal;
                } else {
                    nowVal = numStk.pop() - nowVal;
                }

            } else {

                if (last == ADD) {
                    nowVal += now;
                } else {
                    nowVal -= now;
                }
            }
        }

        return nowVal;
    }

    private boolean hasNext() {
        return index < str.length();
    }

    private int getNext() {
        int chr = str.charAt(index++);
        if (chr == '(') {
            return LEFT;
        } else if (chr == ')') {
            return RIGHT;
        } else if (chr == '+') {
            return ADD;
        } else if (chr == '-') {
            return SUBTRACT;
        }

        int startIndex = index - 1;

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            index++;
        }

        return Integer.parseInt(str.substring(startIndex, index));
    }
}