import java.lang.Math;

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        
        int[] result = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            if (nums[i] == 0) {
                defineResult(nums, result, i, 0);
            } 
            else if (nums[i] < 0) {
                defineResult(nums, result, i, 1);
            }
            else {
                defineResult(nums, result, i, 2);
            }
        }
        
        return result;  
    }
    
    public static void defineResult(int[] nums,int[] result, int i, int move){
        int itr=Math.abs(nums[i]),pos=i;
        
        switch(move){
            case 0:{
                result[pos] = nums[i];
                break;
            }
                
            case 1:{
                while(itr>0){
                    i--;
                    if(i<0) i=nums.length-1;
                    itr--;    
                }
                result[pos] = nums[i];
                break;
            }
                
            case 2:{
                while(itr>0){
                    i++;
                    if(i>=nums.length) i=0;
                    itr--;    
                }
                result[pos] = nums[i];
                break;
            } 
        }
    }
}