class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int cnt = 0;
        int nowi = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                cnt++;
            } else {
                nums[nowi++] = nums[i];
            }
        }

        nums[nowi++] = nums[nums.length - 1];
        return nums.length - cnt;
    }
}