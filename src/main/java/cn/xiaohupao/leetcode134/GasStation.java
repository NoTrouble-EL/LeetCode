package cn.xiaohupao.leetcode134;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/6 16:02
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost){
        //遍历从各个地方出发
        for (int i = 0; i < gas.length; i++){
            //记录当前的油量
            int hasGas = gas[i];
            //记录当前位置
            int j = i;

            //判断是否能去下一个城市
            while (hasGas >= cost[j]){
                //跟新当前油量
                hasGas = hasGas - cost[j] + gas[(j+1)%gas.length];
                //更新当前城市位置
                j = (j+1)%gas.length;
                if (j == i){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4}, cost = {3,4,3};
        int[] gas1 = {1,2,3,4,5}, cost1 = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println(canCompleteCircuit(gas1, cost1));
    }
}
