class Solution {

    private static final String prevFolder = "../";
    private static final String sameFolder = "./";

    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String op: logs) {
            if ((stack.isEmpty() && op.equals(prevFolder)) || op.equals(sameFolder)) {
                continue;
            } else if (op.equals(prevFolder)) {
                stack.pop();
            } else {
                stack.push(op);
            }
        }
        return stack.size();
    }
}