class Solution {
    public void moveZeroes(int[] nums) {
       int count=0,temp;
       
       int n=nums.length;
       for (int i=0;i<n;i++){
        if(nums[i]!=0){
            temp=nums[i];
            nums[i]=nums[count];
            nums[count]=temp;
            count++;
        }

       } 
    }
}