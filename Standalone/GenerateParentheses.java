/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

class Solution {
    public void generateParenthesisHelper(List<String> bracesList, String currentStr, int openCount, int closeCount){
        if(openCount == 0 && closeCount == 0)
            bracesList.add(currentStr);
        if(openCount > closeCount)
            return;
        if(openCount>0)
            generateParenthesisHelper(bracesList,currentStr + '(',openCount-1,closeCount);
        if(closeCount>0)
            generateParenthesisHelper(bracesList,currentStr + ')',openCount,closeCount-1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> bracesList = new ArrayList<>();
        generateParenthesisHelper(bracesList,"",n,n);
        return bracesList;
    }
}