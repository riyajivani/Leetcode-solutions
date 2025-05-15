class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0){
            return false;
        }
 
        int originalNum = x;
        int reversedNum = 0;

        while( x > 0) {
            reversedNum = (reversedNum * 10) + (x % 10);
            x = x / 10;
        }

        if(originalNum == reversedNum) return true;
        else return false;
    }
}