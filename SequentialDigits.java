class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
List<Integer> result = new ArrayList<>();
        String digits = "123456789";
        int n = digits.length();

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                String sub = digits.substring(start, start + len);
                int num = Integer.parseInt(sub);

                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;
    }
}
