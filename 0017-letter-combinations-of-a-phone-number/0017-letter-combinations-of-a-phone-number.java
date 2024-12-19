class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
      
        if (digits.length() == 0) {
            return result;
        }
      
        result.add("");
        
        String[] digitToLetters = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      
        for (char digit : digits.toCharArray()) {
            
            String letters = digitToLetters[digit - '2'];
          
            List<String> temp = new ArrayList<>();
          
            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }
            result = temp;
        }
        return result;
    }
}