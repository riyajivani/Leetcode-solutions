class Solution {
    public int divide(int dividend, int divisor) {
        double answer = dividend / divisor;

        if(answer > Integer.MAX_VALUE || (dividend == Integer.MIN_VALUE && divisor == -1))
        {
            answer = Integer.MAX_VALUE;
        }
        
        if(answer < Integer.MIN_VALUE)
        {
            answer = Integer.MIN_VALUE;
        }

        return (int) answer;
    }
}