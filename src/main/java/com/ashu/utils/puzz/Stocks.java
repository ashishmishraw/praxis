package com.ashu.utils.puzz;

/**
 * Created by mishra.ashish@icloud.com
 */
public class Stocks {

    public static void main(String[] args) {


        int[] stockPricesYesterday = new int[]{10, 33, 0, 7, 5, 8, 11, 9, 87, 211, 13, 25 };

        Result res = getMaxProfit(stockPricesYesterday);
        System.out.println(res.getProfit() + " ( buying for " + res.getBuyPrice() + " & selling for "
                + res.getSellPrice() + " )");

    }

    public static Result getMaxProfit(int[] stockPricesYesterday) {

        return null;
    }


    class Result {

        private int buyPrice;
        private int sellPrice;
        private int profit;

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public int getSellPrice() {

            return sellPrice;
        }

        public void setSellPrice(int sellPrice) {
            this.sellPrice = sellPrice;
        }

        public int getBuyPrice() {

            return buyPrice;
        }

        public void setBuyPrice(int buyPrice) {
            this.buyPrice = buyPrice;
        }
    }

}
