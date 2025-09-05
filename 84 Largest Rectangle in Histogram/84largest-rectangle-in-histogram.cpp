class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        //Brute Force
        /*
        int maxArea = INT_MIN;
        int n = heights.size();

        for(int i=0; i<n; i++){
            int minHeight = INT_MAX;
            for(int j=i; j<n; j++){
                minHeight = min(minHeight, heights[j]);
                int area = minHeight * (j-i+1);
                maxArea = max(maxArea, area); 
            }
        }
        return maxArea;
        */

        //optimal approach
        
        int n = heights.size();
        stack<int>st;

        //step 1: find left smaller element array
        vector<int>left(n);
        for(int i=0; i<n; i++){
            while(!st.empty() && heights[st.top()] >= heights[i]){
                st.pop();
            }

            left[i] = st.empty() ? -1 : st.top();
            st.push(i); //store index instead of value
        }

        //empty stack to resuse it for finding right smaller element array
        while(!st.empty()){
            st.pop();
        }
        
        //step 2: find right smaller element array
        vector<int>right(n);
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && heights[st.top()] >= heights[i]){
                st.pop();
            }

            right[i] = st.empty() ? n : st.top();
            st.push(i); //store index instead of value
        }

        //step 3: calculate area
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = max(maxArea, area);
        }
        return maxArea;
    }
};