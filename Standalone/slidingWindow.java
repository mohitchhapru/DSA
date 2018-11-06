/**
 * Sliding Window Maximum
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * 
 * Example:
 * 
 *  Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 * Yes, This is been solved using deque (Ref from GeeksforGeeks)
 */

class slidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {  
        if(nums.length == 0 || k == 0)
            return new int[]{};
        
        int[] maxArr = new int[nums.length+1-k];
        int maxArrCounter = 0;
        
        Deque<Integer> dq = new LinkedList<Integer>();
        
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }
                       
        
        for(int i=k;i<nums.length;i++){
            
            maxArr[maxArrCounter++] = nums[dq.peekFirst()];
            
            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.removeFirst();
            
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.removeLast();
            
            dq.addLast(i);            
        }
        maxArr[maxArrCounter++] = nums[dq.peekFirst()];
        return maxArr;
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return new int[]{};

        int[] minArr = new int[nums.length+1-k];
        int minArrCounter = 0;

        Deque<Integer> dq = new LinkedList<Integer>();

        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[i] <= nums[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }

        for(int i=k;i<nums.length;i++){
            minArr[minArrCounter++] = nums[dq.peekFirst()];
            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.removeFirst();
            while(!dq.isEmpty() && nums[i] <= nums[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        minArr[minArrCounter++] = nums[dq.peekFirst()];
        return minArr;
    }
}