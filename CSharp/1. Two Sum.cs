//A +B = target
//A = target - B
public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        Dictionary<int, int> dic = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++)
        {
            dic[target - nums[i]] = i;
        }

        int[] res = new int[2];
        for (int i = 0; i < nums.Length; i++)
        {
            if (dic.ContainsKey(nums[i]))
            {
                int otherIndex = dic[nums[i]];
                if (i != otherIndex)
                {
                    res[0] = Math.Min(i, otherIndex);
                    res[1] = Math.Max(i, otherIndex);
                }
            }
        }

        return res;
    }
}