package cn.xiaohupao.leetcode71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/3 14:55
 */
public class SimplifyPath {

    /**
     * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system,
     * convert it to the simplified canonical path.
     * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level,
     * and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
     * For this problem, any other format of periods such as '...' are treated as file/directory names.
     * The canonical path should have the following format:
     * The path starts with a single slash '/'.
     * Any two directories are separated by a single slash '/'.
     * The path does not end with a trailing '/'.
     * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
     * @param path a string path
     * @return simplified canonical path
     *
     * time: O(n)
     * space: O(n)
     */
    public static String simplifyPath(String path){
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.split("/+");
        for (String s : paths){
            if ("..".equals(s) && !stack.isEmpty()){
                stack.pop();
            }else if("..".equals(s) || ".".equals(s) || "".equals(s)){
            }else{
                stack.push(s);
            }
        }

        if (stack.isEmpty()){
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0, "/" + stack.pop());
        }

        return res.toString();
    }
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
}
