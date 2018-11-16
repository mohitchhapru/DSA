/**
 * Island Perimeter
 * 
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, 
 * and there is exactly one island (i.e., one or more connected land cells).
 * 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.
 * 
 * Example:
 * 
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * 
 * Output: 16
 * 
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 */

class Solution {
    
    public int countPerimeter(int row,int col,int[][] grid,int count){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length) // not valid position
            return count + 1;
        
        if(grid[row][col] == 0)
            return count + 1;        
        
        if(grid[row][col] == -1)
            return count;
        
        grid[row][col] = -1;
        
        count = countPerimeter(row,col-1,grid,count);
        count = countPerimeter(row,col+1,grid,count);
        count = countPerimeter(row-1,col,grid,count);
        count = countPerimeter(row+1,col,grid,count);
        
        return count;        
    }
    public int islandPerimeter(int[][] grid) {    
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    return countPerimeter(i,j,grid,0);
                }
            }
        }
        
        return 0;
    }
}