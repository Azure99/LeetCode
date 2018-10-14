class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res = binarySearch(nums, target);

        if (res == -1) {
            return new int[]{-1, -1};
        }

        int left = res;
        int right = res;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }

        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }

        return new int[]{left, right};

    }

    private int binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}