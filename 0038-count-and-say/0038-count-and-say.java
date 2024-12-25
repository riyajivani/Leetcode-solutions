class Solution {
    public String countAndSay(int n) {
     if (n <= 0) return "";

        String result = "1"; // The first term in the sequence
        for (int i = 1; i < n; i++) {
            result = getNextSequence(result);
        }
        return result;
    }

    private String getNextSequence(String s) {
        StringBuilder nextSequence = new StringBuilder();
        int count = 1; // Initialize count of the current digit

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // Increment count if the current digit matches the previous one
            } else {
                // Append the count and the digit
                nextSequence.append(count).append(s.charAt(i - 1));
                count = 1; // Reset count for the new digit
            }
        }

        // Append the last group
        nextSequence.append(count).append(s.charAt(s.length() - 1));

        return nextSequence.toString();   
    }
}