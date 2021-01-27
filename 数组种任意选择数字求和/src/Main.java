import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.Scanner;

public class Main {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //int n = sc.nextInt();
            int m = sc.nextInt();
            int[] numbers = new int[]{1,2,3,4,5};
            /*
            for(int i = 0 ; i < numbers.length; i++){
                numbers[i] = i + 1;
            }

             */

            Main a = new Main();
            System.out.println(a.findTargetSumWays(numbers,m));
           // System.out.println(res);



        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null) return 0 ;
        dfs(nums,S,0,0);
        return res ;
    }

    public void dfs(int[] nums , int s , int sum , int k)
    {
        if(k == nums.length)
        {
            if(sum == s)
            {
                res ++ ;
            }
            return ;

        }
        dfs(nums,s,sum + nums[k],k+1) ;
        dfs(nums,s,sum - nums[k],k+1) ;
    }
}
