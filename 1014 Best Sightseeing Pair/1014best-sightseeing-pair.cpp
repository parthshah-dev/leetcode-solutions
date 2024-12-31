class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        int maxLeft = values[0]; 
        int maxScore = INT_MIN;

        for (int j = 1; j < values.size(); j++) {
            // Calculate the current score with the best left value
            maxScore = max(maxScore, maxLeft + values[j] - j);

            // Update maxLeft for the next iteration
            maxLeft = max(maxLeft, values[j] + j);
        }

        return maxScore;
    }
};