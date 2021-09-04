package cn.xiaohupao.leetcode554;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 19:34
 */
public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall){
        //找出某个缝隙出现的最多次数
        //用墙的高度 - 最多次数即为所求

        Map<Integer, Integer> map = new HashMap<>();

        //遍历wall
        for (List<Integer> w : wall){
            int index = 0;
            //注意不需要遍历到尾部
            for (int i = 0; i < w.size() - 1; i++){
                index += w.get(i);
                map.put(index, map.getOrDefault(index, 0)+1);
            }
        }

        //遍历map
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }

        return wall.size() - max;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = Arrays.asList(
                Arrays.asList(1,2,2,1),
                Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),
                Arrays.asList(2,4),
                Arrays.asList(3,1,2),
                Arrays.asList(1,3,1,1)
        );
        System.out.println(leastBricks(wall));
    }
}
