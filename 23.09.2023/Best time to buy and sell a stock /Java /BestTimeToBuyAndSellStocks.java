public class BestTimeToBuyAndSellStocks {
    // Brutforce solution
    public static int maximumProfit(int nums[]) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > nums[i]) {
                    maxProfit = Math.max(maxProfit, nums[j]-nums[i]);
                }
            }
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_profit = Integer.MIN_VALUE;
        
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                int profit = prices[i]-min;
                max_profit = Math.max(max_profit, profit);
            }
        }
        return max_profit == Integer.MIN_VALUE ? 0 : max_profit;
    }
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};

        System.out.println(maximumProfit(prices));

        System.out.println(maxProfit(prices));
    }
}
