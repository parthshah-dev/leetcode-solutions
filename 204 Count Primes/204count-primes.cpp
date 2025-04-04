class Solution {
public:
    int countPrimes(int n) {
        if(n < 2)return 0;

        //Sieve of Eratosthenes method
        vector<bool> prime(n, true); //mark all as prime initially
        prime[0] = prime[1] = false;

        int count = 0;
        for(int i=2; i*i<n; i++){
            if(prime[i]){
                for(int j=i*i; j<n; j+=i){
                    prime[j] = false;
                }
            }
        }
        return std::count(prime.begin(), prime.end(), true);
    }
};