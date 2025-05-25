class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generatePair(0 , 0, "", n, result);

        return result;

    }

    public void generatePair(int openP, int closeP, String pair, int n, List<String>result){
        if((openP == closeP) && (openP+closeP==n*2)){
            result.add(pair);
            return;
        }

        if(openP < n){
            generatePair(openP+1, closeP, pair + "(", n, result);
        }

        if(closeP < openP){
            generatePair(openP, closeP+1, pair + ")", n, result);
        }
    }
}