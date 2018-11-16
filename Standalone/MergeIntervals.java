/**
 * Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */

 /**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {        
        if(intervals.size() <= 1)
            return intervals;
        List<Interval> output = new ArrayList<>();
        Collections.sort(intervals, new IntervalComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;        
        for(int i=1; i<intervals.size();i++){
            Interval currentNode = intervals.get(i);
            if(currentNode.start <= end){
                if(currentNode.end>end)
                    end = currentNode.end;
            }
            else{
                Interval previousNode = new Interval(start,end);
                output.add(previousNode);
                start = currentNode.start;
                end = currentNode.end;
            }            
        }
        Interval previousNode = new Interval(start,end);
        output.add(previousNode);        
        return output;
    }
    
    class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval one, Interval two){
            return one.start - two.start;
        }
    }
}