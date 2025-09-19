class Solution {
public:
    vector<double> getCollisionTimes(vector<vector<int>>& cars) {
        vector<double> ans(cars.size(), -1);

        stack<int>st;

        for(int i=cars.size()-1; i>=0; i--){
            int pos = cars[i][0], speed = cars[i][1];

            while(!st.empty()){
                int j = st.top();

                //Pos and speed of the ahead car
                int pos_j = cars[j][0], speed_j = cars[j][1];

                //step 1: if the current car is slower then it cannot collide
                if(speed <= speed_j){
                    st.pop();
                    continue;
                }

                //Time to collide with car j
                double t = (double)(pos_j - pos) / (speed - speed_j);

                //if the time to collide the curr car with j is greater than the time to collide of jth car to its further car then remove the jth car from stack because it made fleet with another car
                if(ans[j] == -1 || t <= ans[j]){
                    ans[i] = t;
                    break;
                }else{
                    st.pop();
                }
            }
            st.push(i);
        }
        return ans;
    }
};