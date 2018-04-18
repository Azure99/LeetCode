class Solution {
    public int reverse(int x) {
        long res = 0;
        boolean isMinus = false;
        if (x < 0) {
            isMinus = true;
            x = -x;
        }

        int[] bit = new int[20];
        int len = 0;
        while (x > 0) {
            bit[len++] = x % 10;
            x /= 10;
        }

        for (int i = len - 1; i >= 0; i--) {
            res += bit[i] * Math.pow(10, len - i - 1);
        }

        res = isMinus ? -res : res;
        if (res > 2147483647 || res < -2147483648) {
            return 0;
        }

        return (int) res;
    }
}