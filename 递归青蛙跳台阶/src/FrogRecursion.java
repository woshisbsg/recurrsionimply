public class FrogRecursion {
    //static int counter = 0;
    public static void main(String[] args) {
        int target = 20;
        System.out.println(JumpFloor(target));


    }
    public static int JumpFloor(int target) {

        //递归
        /*
        if(target == 0){
            return 0;
        }
        else if(target == 1){
            return 1;

        }
        else if(target == 2){
            return 2;
        }
        int result = JumpFloor(target - 1) + JumpFloor( target - 2);
        return result;

         */




        //动态规划


        int[] subresult = new int[target + 1];
        subresult[0] = 0;
        subresult[1] = 1;
        subresult[2] = 2;

        for(int i = 3; i <= target; i++){
            subresult[i] = subresult[i-1] + subresult[i-2];
        }

        return subresult[target];





    }
}
