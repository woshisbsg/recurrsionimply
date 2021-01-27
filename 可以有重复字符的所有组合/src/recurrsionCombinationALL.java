import java.lang.reflect.Array;
import java.util.ArrayList;

public class recurrsionCombinationALL {
    static ArrayList<String> currentCombination = new ArrayList<>(); //也是path
    static ArrayList<ArrayList<String>> resultCombination = new ArrayList<>();
    public static void main(String[] args) {
        String[] data = new String[]{"A", "B","C","D","E"};
        System.out.println(combination(data));
    }
    public static ArrayList<ArrayList<String>> combination(String[] number){
        ArrayList<String> data = new ArrayList<>();

        for(int i = 0; i < number.length; i++){
            data.add(number[i]);
        }
        boolean[] visited = new boolean[data.size()];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        dfs(data,visited,0);
        System.out.println(resultCombination.size());
        return resultCombination;



    }
    public static void dfs(ArrayList<String> data, boolean[] visited, int currentIndex){
        for(int i = currentIndex; i < data.size(); i++){
            if(!visited[i]){
                currentCombination.add(data.get(i));
                ArrayList<String> temp = new ArrayList<>();
                temp = (ArrayList<String>) currentCombination.clone();
                resultCombination.add(temp);
                visited[i] = true;
                dfs(data,visited,i);
                currentCombination.remove(currentCombination.size() - 1);
                visited[i] = false;
            }
        }
    }
}
