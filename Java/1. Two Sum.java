//A +B = target
//A = target - B
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int otherIndex = map.get(target - nums[i]);

                if (otherIndex != i) {
                    res[0] = Math.min(i, otherIndex);
                    res[1] = Math.max(i, otherIndex);
                    break;
                }
            }
        }

        return res;
    }
}