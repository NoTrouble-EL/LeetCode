package cn.xiaohupao.leetcode877;

/**
 * @Author: Wukun
 * @Date: 2021/8/16下午5:19
 */
public class StoneGame {

    /**
     * Alice and Bob play a game with piles of stones.
     * There are an even number of piles arranged in a row,
     * and each pile has a positive integer number of stones piles[i].
     *
     * The objective of the game is to end with the most stones.
     * The total number of stones across all the piles is odd, so there are no ties.
     *
     * Alice and Bob take turns, with Alice starting first.
     * Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row.
     * This continues until there are no more piles left, at which point the person with the most stones wins.
     *
     * Assuming Alice and Bob play optimally,
     * @param piles
     * @return true if Alice wins the game, or false if Bob wins
     */
    public static boolean stoneGame(int[] piles){
        return true;
    }

    public static void main(String[] args) {
        int[] piles = {5,3,4,3};
        System.out.println(stoneGame(piles));
    }
}
