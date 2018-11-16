/**
 * Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 */

class NumberOfIslands {
    boolean[][] visitedGrid;
    
    public boolean isValidPosition(int row,int col,char[][] grid){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length)
            return true;
        return false;
    }
    
    public void markIsland(int row, int col, char[][] grid){
        // check left
        if(isValidPosition(row,col-1,grid)){
            if(grid[row][col-1] == '1' && !visitedGrid[row][col-1]){
                visitedGrid[row][col-1] = true;
                markIsland(row,col-1,grid);                
            }
        }
        // check right
        if(isValidPosition(row,col+1,grid)){
            if(grid[row][col+1] == '1' && !visitedGrid[row][col+1]){
                visitedGrid[row][col+1] = true;
                markIsland(row,col+1,grid);                
            }
        }
        // check top
        if(isValidPosition(row-1,col,grid)){
            if(grid[row-1][col] == '1' && !visitedGrid[row-1][col]){
                visitedGrid[row-1][col] = true;
                markIsland(row-1,col,grid);                
            }
        }
        // check bottom
        if(isValidPosition(row+1,col,grid)){
            if(grid[row+1][col] == '1' && !visitedGrid[row+1][col]){
                visitedGrid[row+1][col] = true;
                markIsland(row+1,col,grid);                
            }
        }
        return;
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        int islandCount = 0;
        
        visitedGrid = new boolean[grid.length][grid[0].length];        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1' && !visitedGrid[i][j]){ // island found
                    visitedGrid[i][j] = true;
                    markIsland(i,j,grid);
                    islandCount++;
                }
            }
        }        
        return islandCount;
    }
}