class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            Character nowChr = s.charAt(i);
            if (nowChr == '[' || nowChr == '{' || nowChr == '(') {
                stk.push(nowChr);
            } else {
                if (!stk.empty() && stk.peek() == map.get(nowChr)) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stk.empty()) {
            return false;
        }
        return true;
    }
}