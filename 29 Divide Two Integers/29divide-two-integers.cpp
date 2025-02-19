class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        bool sign = (dividend > 0) == (divisor > 0);

        long n = abs((long)dividend);
        long m = abs((long)divisor);
        long ans = 0;

        while(n >= m){
            long temp = m, count = 1;
            while(n >= (temp << 1)){
                temp <<= 1;
                count <<= 1;
            }
            ans += count;
            n -= temp;
        }

        ans = sign ? ans : -ans;
        return (ans > INT_MAX) ? INT_MAX : (ans < INT_MIN) ? INT_MIN : ans;
    }
};