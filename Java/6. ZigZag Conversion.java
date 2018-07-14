class Solution {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();

        int splitLen = numRows + numRows - 2;
        if (splitLen == 0) {
            return s;
        }
        int groupCnt = chars.length / splitLen;
        if (chars.length % splitLen != 0) {
            groupCnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int i2 = 0; i2 < groupCnt; i2++) {
                if (i == 0 || i == numRows - 1) {
                    int index = i2 * splitLen + i;
                    if (index < chars.length) {
                        sb.append(chars[index]);
                    }

                } else {
                    int index = i2 * splitLen + i;
                    int index2 = i2 * splitLen + (splitLen - i);
                    if (index < chars.length) {
                        sb.append(chars[index]);
                    }

                    if (index2 < chars.length) {
                        sb.append(chars[index2]);
                    }
                }
            }
        }

        return sb.toString();
    }
}