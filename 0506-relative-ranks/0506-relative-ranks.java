import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        String[] rank = new String[score.length];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        
        // Sort the scores in descending order
        Arrays.sort(score);
        reverse(score);
        
        // Assign ranks based on the sorted scores
        for (int i = 0; i < score.length; i++) {
            int originalIndex = map.get(score[i]);
            if (i == 0) {
                rank[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                rank[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                rank[originalIndex] = "Bronze Medal";
            } else {
                rank[originalIndex] = String.valueOf(i + 1);
            }
        }
        
        return rank;
    }
    
    
    private void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
