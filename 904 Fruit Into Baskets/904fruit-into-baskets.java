class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        HashMap<Integer, Integer> basket = new HashMap<>();
        int maxCount = 1;

        while(j < fruits.length){
            basket.put(fruits[j], basket.getOrDefault(fruits[j], 0) + 1);
 
            while(basket.size() > 2){
                basket.put(fruits[i], basket.get(fruits[i])-1);
                if(basket.get(fruits[i]) == 0){
                    basket.remove(fruits[i]);
                }
                i++;
            }
            maxCount = Math.max(maxCount, j-i+1);
            j++;
        }
        return maxCount;
    }
}