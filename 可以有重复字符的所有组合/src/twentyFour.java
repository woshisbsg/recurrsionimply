import java.util.ArrayList;
import java.util.Scanner;

public class twentyFour {
    static boolean result = false;
    static ArrayList<Integer> sum = new ArrayList<>();

    //static int currentSum = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] data = new int[4];
            for(int i = 0 ; i < 4; i++){
                data[i] = sc.nextInt();
            }

            System.out.println(tf(data));
        }


    }
    public static boolean tf(int[] data){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            numbers.add(data[i]);
        }

        boolean[] visited = new boolean[numbers.size()];
        for(boolean s : visited){
            s = false;
        }
        dfs(numbers, visited, 0);
        if(result == false){
            return result;
        }
        else {
            result = false;
            return true;
        }
        //return result;
    }

    public static void dfs(ArrayList<Integer> data, boolean[] visited, int currentSum){
        //截止条件
        //如果全部visited过，则返回
        int counter = 0;
        for(boolean s : visited){
            if(s){
                counter++;
            }
        }
        if(counter == data.size()){
            if(currentSum == 24){
                result = true;
            }
            return;
        }

        for(int i = 0 ; i < data.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(data, visited,currentSum + data.get(i));
                dfs(data, visited,currentSum - data.get(i));
                dfs(data, visited,currentSum * data.get(i));
                if(currentSum % data.get(i) == 0){
                    dfs(data, visited,currentSum / data.get(i));
                }
                visited[i] = false;
            }
        }



    }
}
