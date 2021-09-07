package cn.xiaohupao.leetcode874;

import java.util.HashSet;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/7 22:33
 */
public class WalkingRobotSimulation {

    public static int robotSim(int[] commands, int[][] obstacles){

        //定义一个方向数组
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        //定义方向
        int dir = 0;

        //构建一个HashSet用于保存障碍物的位置
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles){
            set.add(obstacle[0] + "," + obstacle[1]);
        }

        //初始位置
        int x = 0, y = 0;
        //距离
        int res = 0;

        //遍历命令
        for (int command : commands){
            if (command == -2){
                //改变方向
                dir = (dir + 3) % 4;
            }else if (command == -1){
                dir = (dir + 1) % 4;
            }else{
                for (int i = 0; i < command; i++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    //检查新位置是否存在障碍物
                    if (set.contains(nx + "," + ny)){
                        break;
                    }

                    //更新位置
                    x = nx;
                    y = ny;
                }
            }

            res = Math.max(res, x*x+y*y);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};

        System.out.println(robotSim(commands, obstacles));
    }
}
