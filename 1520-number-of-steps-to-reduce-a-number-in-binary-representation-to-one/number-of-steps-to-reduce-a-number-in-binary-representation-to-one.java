class Solution {
    public int numSteps(String s) {
        int n = s.length();
        if (s.isBlank() || s.isEmpty()) return 0;
        if (s.length() == 1 && s.charAt(0) == '1') return 0;
        if (s.charAt(n - 1) == '0') {
            return 1 + numSteps(divideByTwo(s));
        } else {
            return 1 + numSteps(addOne(s));
        }
    }

    private String addOne(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;

        while (i >= 0) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                break;
            } else {
                sb.setCharAt(i, '0');
            }
            i--;
        }

        if (i < 0) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    private String divideByTwo(String s) {
        return s.substring(0, s.length() - 1);
    }
}