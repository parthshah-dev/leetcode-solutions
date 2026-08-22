class Solution {
    public static boolean isResGreater(int[] res, int[] best){
        for(int i=0; i<res.length; i++){
            if(best[i] > res[i]){
                return false;
            }
            if (res[i] > best[i]) {
                return true;
            }
        }
        return false;
    }
    public static Stack<Integer> maxElements(int[] arr, int take){
        int toRemove = arr.length - take;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            while(!st.isEmpty() && st.peek() < num && toRemove > 0){
                st.pop();
                toRemove--;
            }
            st.push(num);
        }
        while (toRemove > 0) {
            st.pop();
            toRemove--;
        }

        return st;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for(int take1=0; take1<=k && take1<=nums1.length; take1++){
            int take2 = k - take1;

            if(take2 > nums2.length) continue;

            //create stack 1
            st1 = maxElements(nums1, take1);

            //create stack 2
            st2 = maxElements(nums2, take2);

            //compare and merge both stacks and crate a number
            int[] res = new int[k];
            int i=0, j=0, pos=0;
            while(i < st1.size() && j<st2.size()){
                if(st1.get(i) > st2.get(j)){
                    res[pos++] = st1.get(i);
                    i++;
                }else if(st2.get(j) > st1.get(i)){
                    res[pos++] = st2.get(j);
                    j++;
                }else{
                    int p=i;
                    int q=j;
                    while (p < st1.size() &&
                        q < st2.size() &&
                        st1.get(p) == st2.get(q)) {
                            p++;
                            q++;
                    }
                    if(p == st1.size()){
                        res[pos++] = st2.get(j);
                        j++;
                    } 
                    else if(q == st2.size()){
                        res[pos++] = st1.get(i);
                        i++;
                    }
                    else if (st1.get(p) > st2.get(q)) {
                        res[pos++] = st1.get(i++);
                    } 
                    else {
                        res[pos++] = st2.get(j++);
                    }
                }
            }
            while(i<st1.size()){
                res[pos++] = st1.get(i);
                i++;
            }
            while(j<st2.size()){
                res[pos++] = st2.get(j);
                j++;
            }
            
            if(isResGreater(res, best)){
                best = res;
            }
        }

        return best;
    }
}