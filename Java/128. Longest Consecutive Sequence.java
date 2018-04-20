class Solution {
    private int[] father;

    private int find(int target) {
        int x = target;
        while (father[x] != x) {
            x = father[x];
        }

        int ftr = x;
        x = target;
        int tmp;
        while (father[x] != x) {
            tmp = father[x];
            father[x] = ftr;
            x = tmp;
        }

        return ftr;
    }

    private void union(int x, int y) {
        int xFa = find(x);
        int yFa = find(y);
        if (xFa != yFa) {
            father[yFa] = father[xFa];
        }
    }

    public int longestConsecutive(int[] nums) {
        boolean[] available = new boolean[nums.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        father = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            father[i] = i;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                available[i] = true;
            } else {
                available[i] = false;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (!available[i]) {
                continue;
            }

            if (map.containsKey(nums[i] - 1)) {
                union(i, map.get(nums[i] - 1));
            }

            if (map.containsKey(nums[i] + 1)) {
                union(i, map.get(nums[i] + 1));
            }
        }

        HashMap<Integer, Integer> cntMap = new HashMap<>();
        ArrayList<Integer> cntList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!available[i]) {
                continue;
            }

            int nowFather = find(i);
            if (cntMap.containsKey(nowFather)) {
                int index = cntMap.get(nowFather);
                cntList.set(index, cntList.get(index) + 1);

            } else {
                cntList.add(1);
                cntMap.put(nowFather, cntList.size() - 1);
            }
        }

        int maxLen = 0;
        for (int cnt : cntList) {
            maxLen = Math.max(maxLen, cnt);
        }

        return maxLen;
    }
}