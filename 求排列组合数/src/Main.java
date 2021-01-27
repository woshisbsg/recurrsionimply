import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static ArrayList<Integer> currentCombination = new ArrayList<>();

    public static void main(String[] args) {
        int[] num = new int[]{1,1,2};
        System.out.println(permute(num));

    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> data = new ArrayList<>();
        for(int i = 0; i < num.length; i++){
            data.add(num[i]);
        }
        boolean[] visited = new boolean[data.size()];
        for(boolean s : visited){
            s = false;
        }
        dfs(data,0,visited);
        //System.out.println(result.size());
        return result;

    }

    public static void dfs(ArrayList<Integer> data, int currentIndex, boolean[] visited){

        if(isAllVisited(visited)){
            if(!result.contains(currentCombination)){
                result.add(new ArrayList<>(currentCombination));
            }
            return;
        }
        for(int i = 0; i < data.size(); i++){
            if(!visited[i]){
                currentCombination.add(data.get(i));
                visited[i] = true;
                dfs(data,i,visited);
                currentCombination.remove(currentCombination.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isAllVisited(boolean[] visited){
        int counter = 0;
        for(boolean s : visited){
            if(s){
                counter++;
            }
        }
        return counter == visited.length;
    }

}





