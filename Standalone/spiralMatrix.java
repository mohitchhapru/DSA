/**
 * Spiral Matrix
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * Input:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {        
        List<Integer> arr = new ArrayList<>();
        if (matrix.length == 0)
            return arr;

        int xMin = 0;
        int xMax = matrix[0].length - 1;
        int yMin = 0;
        int yMax = matrix.length - 1;

        while(xMin <= xMax && yMin <= yMax){
            while (xMin <= xMax && yMin <= yMax) {
                for(int i = xMin; i <= xMax; i++){
                    arr.add(matrix[yMin][i]);
                }
                yMin++;
                for(int i = yMin; i <= yMax; i++){
                    arr.add(matrix[i][xMax]);
                }
                xMax--;
                if(yMin <= yMax){
                    for(int i = xMax; i >= xMin; i--){
                        arr.add(matrix[yMax][i]);
                    }
                    yMax--;
                }
                if(xMin <= xMax){
                    for(int i = yMax; i >= yMin; i--){
                        arr.add(matrix[i][xMin]);
                    }
                    xMin++;
                }
            }
        }
        return arr;
    }
}