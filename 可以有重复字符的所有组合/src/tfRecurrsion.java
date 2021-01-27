import java.util.Arrays;
import java.util.Scanner;

public class tfRecurrsion {
    static int count=0;
    static int level=0;
    static int opIndex=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 初始化数字数组和标志数组
            int[] nums = new int[4];
            int[] signs = new int[4];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }

            boolean can = false; // 是否能得到24

            for (int i = 0; i < nums.length; i++) {
                signs[i] = 1;
                if (dfs(nums, signs, nums[i], 24,level,"")) {
                    can = true;
                    break;
                }
                signs[i] = 0;
            }
            System.out.println(can);// 输出结果
        }
    }

    private static boolean dfs(int[] nums, int[] signs, int v, int required,int level,String op) {

        boolean allVisited = true;// 四个角均被访问
        for (int sign : signs) {
            if (sign == 0) {
                allVisited = false;
            }
        }

        if (allVisited) {
            if(v==required)
                System.out.println("operator=   "+op);
            return v == required; // 在所有节点均被访问的前提下，判断最后的结果是否为所需要的结果。
        }

        // 访问所有的邻接顶点
        for (int i = 0; i < nums.length; i++) {

            if (signs[i] == 0) {
                System.out.println("Level"+level+"-----"+ ++count+"    v="+v+"   op="+op);
                System.out.println(Arrays.toString(signs));
                level++;
                signs[i] = 1;
                if (dfs(nums, signs, v + nums[i], required,level,"+") // 加法
                        || dfs(nums, signs, v - nums[i], required,level,"-") // 减法
                        || dfs(nums, signs, v * nums[i], required,level,"x") // 乘法
                        ||  nums[i] != 0 && v % nums[i] == 0 && dfs(nums, signs, v / nums[i], required,level,"/")/* 除法 */) {

                    return true;// 如果可以通过四则运算得到需要的结果，则返回true。
                }
                signs[i] = 0; // 如果不能通过四则运算得到，则进行回溯。

            }
        }
        return false;//当所有情况均得不到需要的结果，返回false。
    }
}

