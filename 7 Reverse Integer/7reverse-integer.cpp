class Solution {
public:
    int reverse(int x) {
        int rem, ans = 0;
        while(x){
            rem = x % 10;

            //check for overflow and underflow condition
            if((ans > INT_MAX / 10) || (ans < INT_MIN / 10)){
                return 0;
            }
            x /= 10;
            ans = ans * 10 + rem;
        }
        return ans;
    }
};