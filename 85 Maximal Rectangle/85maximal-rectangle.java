class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;

        int heights[] = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j] = heights[j] + 1; 
                }
            }
            maxArea = Math.max(maxArea, largestAreaInHistogram(heights));
        }

        return maxArea;
    }

    public static int largestAreaInHistogram(int[] arr){
        int maxArea = Integer.MIN_VALUE;
        int n = arr.length;

        int[] rsi = new int[n];
        int[] lsi = new int[n];

        Stack<Integer> st = new Stack<>();

        //find right smaller index
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rsi[i] = st.peek(); 
            }else{
                rsi[i] = n;
            }
            st.push(i);
        }

        st.clear();

        //find left smaller index
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                lsi[i] = -1;
            }
            else{
                lsi[i] = st.peek();
            }
            st.push(i);
        }

        //calculate max area
        for(int i=0; i<n; i++){
            int height = arr[i];
            int width = rsi[i]-lsi[i]-1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

}