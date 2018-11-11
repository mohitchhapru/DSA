/**
 * Product of the maximum and minimum in a dataset
 * 
 * We start with an empty set of Integers named elements. we want to perform the following query operation
 * 
 * The command "Push" x inserts the value x into the elements
 * The command "Pop" x remove the value x from the elements
 * 
 * We need to order the integers in elemets in such a way that after performing each operation we can easily calculate the product 
 * of the maximum and minimum values in the elements
 * 
 * Eg: 
 * Operations = {"push","push","push","push","Pop"}
 * x          = {   1 ,    2 ,    3,     4,    1  }   
 * 
 * Solution
 *     
 * Input        |   1   |   2   |   3   |   4   |   1
 * Operation    |"Push" |"Push" |"Push" |"Push" |"Pop"
 * Current Eles |   1   |1,2    |1,2,3  |1,2,3,4|2,3,4
 * Min          |   1   |   1   |   1   |   1   |   2
 * Max          |   1   |   2   |   3   |   4   |   4
 * Product      |   1   |   2   |   3   |   4   |   8
 * 
 * Return the Product Array: {1,2,3,4,8}
 * 
 */

class minMaxDataSet{
    public static List<Long> minMax(List<String> operations, List<Integer> x) {
        List<Long> minMaxProd = new ArrayList<>();
        TreeSet<Integer> ts = new TreeSet<>();
        Integer min = null;
        Integer max = null;

        for(int i=0;i<operations.size();i++){
            if(operations.get(i).toLowerCase().equals("push")){
                ts.add(x.get(i));
                if(min == null){
                    min = x.get(i);
                    max = x.get(i);
                }
                else {
                    if(min > x.get(i))
                        min = x.get(i);
                    if(max < x.get(i))
                        max = x.get(i);
                }

                minMaxProd.add(Long.valueOf(min.longValue()*max.longValue()));
            }
            else{
                ts.remove(x.get(i));
                min = ts.first();
                max = ts.last();
                minMaxProd.add(Long.valueOf(min*max));
            }
        }
        return  minMaxProd;
    }
}