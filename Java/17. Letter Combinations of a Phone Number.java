class Solution {
    private ArrayList<String> resList = new ArrayList<>();
    private int len = 0;
    private int[] digitsArr;

    private String[] keys = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return resList;
        }

        len = digits.length();
        digitsArr = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            digitsArr[i] = (int) (digits.charAt(i) - '0');
        }

        dfs(0, "");

        return resList;
    }

    private void dfs(int index, String str) {
        if (index == len) {
            resList.add(str);
            return;
        }

        for (int i = 0; i < keys[digitsArr[index]].length(); i++) {
            dfs(index + 1, str + keys[digitsArr[index]].charAt(i));
        }
    }
}