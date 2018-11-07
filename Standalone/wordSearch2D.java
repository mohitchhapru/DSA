/**
 * Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */

class wordSearch2D {    
    public boolean isValidPosition(char[][] board, int row, int col,boolean[][] visited){
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col])
            return true;
        return false;
    }

    public boolean existHelper(char[][] board, String word, int currentRow, int currentCol, int nextCharIndex, boolean[][] visited){
        if (nextCharIndex == word.length())
            return true;

        boolean left,right,top,bottom;
        left=right=top=bottom=false;

        if(isValidPosition(board,currentRow,currentCol-1,visited)){ // check on left
            if(board[currentRow][currentCol-1] == word.charAt(nextCharIndex)){
                visited[currentRow][currentCol-1] = true;
                left = existHelper(board,word,currentRow,currentCol-1,nextCharIndex+1,visited);
                if(!left)
                    visited[currentRow][currentCol-1] = false;
            }
        }

        if(isValidPosition(board,currentRow,currentCol+1,visited)){ // check on right
            if(board[currentRow][currentCol+1] == word.charAt(nextCharIndex)){
                visited[currentRow][currentCol+1] = true;
                right = existHelper(board,word,currentRow,currentCol+1,nextCharIndex+1,visited);
                if(!right)
                    visited[currentRow][currentCol+1] = false;
            }
        }

        if(isValidPosition(board,currentRow-1,currentCol,visited)){ // check on top
            if(board[currentRow-1][currentCol] == word.charAt(nextCharIndex)){
                visited[currentRow-1][currentCol] = true;
                top = existHelper(board,word,currentRow-1,currentCol,nextCharIndex+1,visited);
                if(!top)
                    visited[currentRow-1][currentCol] = false;
            }
        }

        if(isValidPosition(board,currentRow+1,currentCol,visited)){ // check on bottom
            if(board[currentRow+1][currentCol] == word.charAt(nextCharIndex)){
                visited[currentRow+1][currentCol] = true;
                bottom = existHelper(board,word,currentRow+1,currentCol,nextCharIndex+1,visited);
                if(!bottom)
                    visited[currentRow+1][currentCol] = false;
            }
        }

        return (left || right || top || bottom);
    }
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)
            return true;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j]=true;
                    if(existHelper(board,word,i,j,1,visited)){
                        return true;
                    }
                    visited[i][j]=false;
                }
            }
        }
        return false;
    }}
}