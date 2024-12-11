class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        
        // Handle patterns like "a*", "a*b*", etc., that can match an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);
                
                if (currentP == '.' || currentP == currentS) {
                    // If characters match or the pattern has '.', take the diagonal value
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentP == '*') {
                    // If the pattern has '*', there are two cases:
                    // 1. Treat '*' as matching zero occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2];
                    // 2. Treat '*' as matching one or more occurrences of the preceding character
                    if (p.charAt(j - 2) == currentS || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        // Return whether the entire strings match
        return dp[m][n];
    }
}