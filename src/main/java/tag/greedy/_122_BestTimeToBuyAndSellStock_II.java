package tag.greedy;

/**
 * Created by he.dong on 10/23/2017.
 */
public class _122_BestTimeToBuyAndSellStock_II {
    public int maxProfit(int[] prices) {
        int profile = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                profile += diff;
            }
        }
        return profile;
    }
}
