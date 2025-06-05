class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        //using slow and fast pointer approach
        int slow = nums[0]; //slow moves 1 move
        int fast = nums[0]; //fast moves 2 moves

        slow = nums[slow];
        fast = nums[nums[fast]];

        //detect cycle
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
};