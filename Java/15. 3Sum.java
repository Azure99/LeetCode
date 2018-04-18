//Warning : Run slowly

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        TreeSet<IntArr> resSet = new TreeSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (binaryJudge(nums, j + 1, -nums[i] - nums[j])) {
                    int[] arr = new int[3];
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                    arr[2] = -nums[i] - nums[j];
                    IntArr intArr = new IntArr(arr);
                    resSet.add(intArr);
                }
            }
        }

        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        for (IntArr item : resSet) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.add(item.arr[0]);
            newList.add(item.arr[1]);
            newList.add(item.arr[2]);
            resList.add(newList);
        }

        return (List) resList;
    }

    private boolean binaryJudge(int[] arr, int l, int target) {
        int r = arr.length;
        int mid = (l + r) / 2;
        while (l < r) {
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                l = mid + 1;

            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }

        return false;
    }

    class IntArr implements Comparable {
        int[] arr;

        @Override
        public int compareTo(Object o) {
            IntArr other = (IntArr) o;
            for (int i = 0; i < 3; i++) {
                if (arr[i] < other.arr[i]) {
                    return -1;
                } else if (arr[i] > other.arr[i]) {
                    return 1;
                }
            }
            return 0;
        }

        public IntArr(int[] arr) {
            this.arr = arr;
        }
    }
}