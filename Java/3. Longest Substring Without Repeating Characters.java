class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int strLen = s.length();
        int maxLen = 0;

        int i;
        int starti = 0;

        for (i = 0; i < strLen; i++) {
            Character nowChr = s.charAt(i);
            int lastIndex;
            if (map.containsKey(nowChr) && (lastIndex = map.get(nowChr)) >= starti) {
                starti = lastIndex + 1;
                map.put(nowChr, i);

            } else {
                map.put(nowChr, i);
            }
            maxLen = Math.max(maxLen, i - starti + 1);
        }
        return maxLen;
    }
}