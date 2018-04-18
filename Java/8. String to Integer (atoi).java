class Solution {
    public int myAtoi(String str) {
        if (str.equals("")) {
            return 0;
        }

        int startP = 0;
        int endP;
        while (str.charAt(startP) == ' ') {
            startP++;
        }

        char nowtChr = str.charAt(startP);
        if (!((nowtChr >= '0' && nowtChr <= '9') || nowtChr == '+' || nowtChr == '-')) {
            return 0;
        }

        for (endP = startP + 1; endP < str.length(); endP++) {
            if (!(str.charAt(endP) >= '0' && str.charAt(endP) <= '9')) {
                break;
            }
        }

        String strNum = str.substring(startP, endP);

        return toInt(strNum);
    }

    private int toInt(String str) {
        boolean isMinus = false;
        if (str.startsWith("-")) {
            str = str.substring(1, str.length());
            isMinus = true;

        } else if (str.startsWith("+")) {
            str = str.substring(1, str.length());
        }

        long res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            res += (str.charAt(i) - '0') * Math.pow(10, str.length() - i - 1);
        }

        res = isMinus ? -res : res;

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int) res;
    }
}