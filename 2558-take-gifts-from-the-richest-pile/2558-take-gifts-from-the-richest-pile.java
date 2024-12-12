class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        
        List<Integer> sortedGifts = new ArrayList<>();
        for (int gift : gifts) {
            sortedGifts.add(gift);
        }
        Collections.sort(sortedGifts);
        
        for(int i=0; i<k; i++){
            int maxEl = sortedGifts.get(n-1);
            sortedGifts.remove(n-1);
            
            int sqrtEl = (int)Math.floor(Math.sqrt(maxEl));
            
            //find the new place for the squareroot in array
            int indexofsqrt = Collections.binarySearch(sortedGifts, sqrtEl);
            
            if(indexofsqrt<0)
                indexofsqrt = -(indexofsqrt+1); //If the value isn't found, binarySearch returns a negative index
            
            sortedGifts.add(indexofsqrt, sqrtEl);
        }
        
        long remainingGifts = 0;
        
        for(int gift:sortedGifts){
            remainingGifts += gift;
        }
        
        return remainingGifts;
    }
}