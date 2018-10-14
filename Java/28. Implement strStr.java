//KMP

class Solution {
    char[] str;
    char[] pattern;
    int[] next;

    public int strStr(String haystack, String needle) {
        str = haystack.toCharArray();
        pattern = needle.toCharArray();
        initNext();

        return KMP();
    }

    private void initNext() {
        next = new int[pattern.length + 1];

        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < pattern.length) {
            if (j == -1 || pattern[i] == pattern[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }

        }
    }

    private int KMP() {
        int i = 0;
        int j = 0;
        while (i < str.length && j < pattern.length) {
            if (j == -1 || str[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pattern.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}