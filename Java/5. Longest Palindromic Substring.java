class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return "";
        }

        int maxLen = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < s.length(); i++) {
            int nowLen = 1;

            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                nowLen++;
                left--;
            }

            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                nowLen++;
                right++;
            }

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                nowLen += 2;
                left--;
                right++;
            }

            if (nowLen > maxLen) {
                maxLen = nowLen;
                maxLeft = left + 1;
                maxRight = right - 1;
            }

        }

        return s.substring(maxLeft, maxRight + 1);
     }
}