import java.util.ArrayList;
public class recurrsionCombinationNumbers {
    static ArrayList<Integer> currentCombination = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> resultCombination = new ArrayList<>();
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5};
        int len = 3;
        System.out.println(combinationAlgorithm(data, len));
    }
    public static ArrayList<ArrayList<Integer>> combinationAlgorithm(int[] num, int len){
        ArrayList<Integer> data = new ArrayList<>();
        //ArrayList<Integer> currentCombination = new ArrayList<>();
        for(int i = 0; i < num.length; i++){
            data.add(num[i]);
        }
        boolean[] visited = new boolean[data.size()];
        for(boolean s : visited){
            s = false;
        }
        dfs(data, 0, len, visited);
        return resultCombination;

    }
    public static void dfs(ArrayList<Integer> data, int currentIndex, int len, boolean[] visited ){
        //递归终止条件

        if(currentCombination.size() == len){
            resultCombination.add(new ArrayList<Integer>(currentCombination));
            return;
        }
        for(int i = currentIndex; i < visited.length; i++){
            if(!visited[i]){
                currentCombination.add(data.get(i));
                visited[i] = true;
                dfs(data, i, len, visited);
                currentCombination.remove(currentCombination.size() - 1);
                visited[i] = false;
            }
        }
    }
}
