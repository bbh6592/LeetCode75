class Solution {
    public int findKthLargest(int[] nums, int k) {
        //create a min-heap(priority queue) with the initial apacity of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        //iterate over the elements in the array
        for(int num : nums) {
            //add the current number to the heap
            minHeap.offer(num);

            //if the size of the heap exeeds , remove the smallest element
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        //the root of the heap is the th largest element
        return minHeap.peek();
    }
}