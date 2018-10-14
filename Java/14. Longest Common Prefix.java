class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int nowIndex = 0;
        while (nowIndex < strs[0].length()) {
            char nowChar = strs[0].charAt(nowIndex);
            boolean same = true;
            for (int i = 1; i < strs.length; i++) {
                if (nowIndex >= strs[i].length() || strs[i].charAt(nowIndex) != nowChar) {
                    same = false;
                    break;
                }
            }

            if (same) {
                sb.append(nowChar);
                nowIndex++;
            } else {
                break;
            }
        }

        return sb.toString();
    }
}