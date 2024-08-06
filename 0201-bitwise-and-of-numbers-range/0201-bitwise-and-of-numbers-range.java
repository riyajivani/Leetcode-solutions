class Solution {
    public int rangeBitwiseAnd(int left, int right) {
//         int next_taken = left+1;
//         int answer=0;
        
//         while(next_taken<=right){
//            answer = left & next_taken++;
//             left=answer;     
//         }
        
//         return answer;
        
        
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}