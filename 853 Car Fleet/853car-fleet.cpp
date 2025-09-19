class Solution {
    class Car{
        public:
            int speed, pos;
            Car(int p, int s): pos(p), speed(s){};
    };

    static bool myComp(Car& a, Car& b){
        return a.pos < b.pos;
    }
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<Car>cars;
        for(int i=0; i<position.size(); i++){
            Car c(position[i], speed[i]);
            cars.push_back(c);
        } 

        sort(cars.begin(), cars.end(), myComp);

        stack<float>st;
        for(int i=position.size()-1; i>=0; i--){
            float time = (target - cars[i].pos) / ((float) cars[i].speed);

            if(!st.empty() && time <= st.top()) {
                //do nothing
            }else{
                st.push(time);
            }
        }
        return st.size();
    }
};