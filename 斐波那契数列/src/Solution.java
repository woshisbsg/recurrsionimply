public class Solution {
    public static void main(String[] args) {
        int a = 30;
        System.out.println(Fibonacci(a));

    }

    //递归算法：
    /*
    public static int Fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci( n - 2);
    }

     */

    //动态规划：

    public static int Fibonacci(int n) {
        int[] subresult = new int[n + 1];
        subresult[0] = 0;
        subresult[1] = 1;
        //subresult[2] = 1;
        for(int i = 2; i <= n; i++){
            subresult[i] = subresult[i-1] + subresult[i-2];
        }
        return subresult[n];

    }




}
