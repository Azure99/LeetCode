class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0) {
            return false;
        }

        if (x % 10 == 0) {
            return false;
        }


        int[] bit = new int[10];
        int len = 0;
        while (x > 0) {
            bit[len++] = x % 10;
            x /= 10;
        }

        for (int i = 0; i < len / 2; i++) {
            if (bit[i] != bit[len - i - 1]) {
                return false;
            }
        }

        return true;
    }
}