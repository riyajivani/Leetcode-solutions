class Solution {
    public String reversePrefix(String word, char ch) {
        
        int pos = word.indexOf(ch);
        
        if (pos == -1) // Character not found
            return word;
        
        char[] charArray = word.toCharArray();
        
        for(int i=0,j=pos; i<=pos/2;i++,j--){
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        
        return new String(charArray);
    }
}