class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        vector<int>minutesArr;
        //step1: Convert the string time array into minutes integer array
        for(int i=0; i<timePoints.size(); i++){
            string current = timePoints[i];
            int hour = stoi(current.substr(0,2));
            int minutes = stoi(current.substr(3,2));
            int totalMinutes = hour*60+minutes;
            minutesArr.push_back(totalMinutes);
        }
        //step2: sort array
        sort(minutesArr.begin(), minutesArr.end());

        //step3: find the minimum difference
        int minTime = INT_MAX;
        for(int i=0; i<minutesArr.size()-1; i++){
            minTime = min(minTime, minutesArr[i+1] - minutesArr[i]);
        }

        //edge case: Find the last and first element difference and update minTime 
        int lastDiff = (minutesArr[0] + 1440) - (minutesArr[minutesArr.size()-1]);
        minTime = min(minTime, lastDiff);

        return minTime;

    }
};