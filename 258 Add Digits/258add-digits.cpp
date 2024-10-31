class Solution {
public:
    int addDigits(int num) {
        while(num>9){
            int sum = 0, rem;
            while(num>0){
                rem = num % 10;
                num /= 10;
                sum += rem;
            }
            num = sum;
        }
        return num;
    }
};